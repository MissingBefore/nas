package com.zr.nas.utils;
/**
 * 带有事物功能的连接池工具类
 * 优点AOP（面向切面编程思想）
 * 优点动态代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TxDBUtils {
	
	/**
	 * 私有化构造方法
	 */
	private TxDBUtils() {
		
	}
	
	//获取到连接池对象（也就是数据源对象）
	private static DataSource source=new ComboPooledDataSource();
	
	/**
	 * ThreadLocal是本地线程对象
	 * set()方法，是向ThreadLocal中存入数据
	 * get()方法，是从ThreadLocal中获取数据
	 * remove()方法，把对象从ThreadLocal中清除
	 */
	
	//做是否开启事物的标记
	private static ThreadLocal<Boolean> isTx_local=new ThreadLocal<Boolean>() {
		@Override
		protected Boolean initialValue() {
			//设置为false，说明是没有开启事物
			return false;
		}
	};
	//保存真实连接的代理连接，改造close()方法
	private static ThreadLocal<Connection> proxyConn_local=new ThreadLocal<Connection>() {
	};
	//保存真实的连接
	private static ThreadLocal<Connection> realConn_local=new ThreadLocal<Connection>(){
	};
	
	/**
	 * 开启事物的方法
	 * @throws SQLException 
	 */
	public static void startTX() throws SQLException {
		//标记为true
		isTx_local.set(true);
		//首先获取连接对象，然后对该连接对象进行处理
		final Connection connection=source.getConnection();
		
		//开启事物，也就是不自动提交事物
		connection.setAutoCommit(false);
		
		//将该连接对象保存到当前线程中
		realConn_local.set(connection);
		
		//由于一个事物需要执行多条sql语句，每个sql执行完毕之后都要关闭连接，
		//这样的话，后面的sql就没办法执行了，所以我们要改造close(),使它不关闭连接
		
		Connection proxyConn=(Connection)Proxy.newProxyInstance(connection.getClass().getClassLoader(),connection.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if ("close".equals(method.getName())) {
					return null;
				}else {
					return method.invoke(connection, args);
				}
			}
		});
		
		proxyConn_local.set(proxyConn);
	}
	/**
	 * 提交事物
	 */
	public static void commit() {
		DbUtils.commitAndCloseQuietly(proxyConn_local.get());
	}
	/**
	 * 回滚事物
	 */
	public static void rollback() {
		//回滚的是代理的connection对象
		DbUtils.rollbackAndCloseQuietly(proxyConn_local.get());
	}
	/**
	 * 获取到连接池对象
	 * 如果没有开启过事物，则返回的就是普通的连接池对象
	 * 如果是开启过事物，则必须返回一个改造过的getConnection()对象
	 */
	
	public static DataSource getSource() {
		if(isTx_local.get()) {
			//这里也就是说，开启了事物
			//所以，我们需要改造getConnection()方法
			 return (DataSource) Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("getConnection".equals(method.getName())) {
						return proxyConn_local.get();
					}else {
						return method.invoke(source, args);
					}
				}
			});
		}else {
			//这里是没有开启事物
			//直接过去到普通的连接对象
			return source;
		}
		
	}
	/**
	 * 释放资源
	 */
	public static void release() {
		//关闭真实对象的连接
		DbUtils.closeQuietly(realConn_local.get());
		
		//把对象和ThreadLocal拆开
		realConn_local.remove();
		proxyConn_local.remove();
		isTx_local.remove();
	}
	
	
	
}
