package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IReservationUserDao;
import com.zr.nas.pojo.Reservation;
import com.zr.nas.pojo.Service;
import com.zr.nas.utils.TxDBUtils;

public class ReservationUserDao implements IReservationUserDao {
//通过条件查找预约用户
	public List chaYuYue(Integer fw, Integer zt, String addtime, String endtime, String hao) {
		String biao;
		if(zt==1){biao="已预约";}
		else {biao="已服务";}
		    QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		    if(fw==1&&zt==0){
		    	String sql1=" select nas_user_reservation.id,yuyue_user,phone,yuyue_che,service_name,state,addtime,beizhu from nas_user_reservation,nas_service where service_id=nas_service.id and (addtime between ? and ?) and(phone=? or yuyue_che=?);";
		    	try {
					List<Reservation> query = q.query(sql1, new BeanListHandler<Reservation>(Reservation.class),addtime,endtime,hao,hao);
					return query;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}return null;
		    	
		    }
		    else if(fw!=1&&zt==0){
		    String sql2="select nas_user_reservation.id,yuyue_user,phone,yuyue_che,service_name,state,addtime,beizhu from nas_user_reservation,nas_service where ?=nas_service.id and (addtime between ? and ?) and(phone=?or yuyue_che=?);";
		    List<Reservation> query;
			try {
				query = q.query(sql2, new BeanListHandler<Reservation>(Reservation.class),fw,addtime,endtime,hao,hao);
				return query;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;		   
		    }
		    else if(fw==1&&zt!=0){ String sql3="select nas_user_reservation.id,yuyue_user,phone,yuyue_che,service_name,state,addtime,beizhu from nas_user_reservation,nas_service where service_id=nas_service.id and state=? and (addtime between ? and ?) and(phone=? or yuyue_che=?);";
		    List<Reservation> query;
		    try {
				query = q.query(sql3, new BeanListHandler<Reservation>(Reservation.class),biao,addtime,endtime,hao,hao);
				return query;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return null;}
		    else{String sql4="select nas_user_reservation.id,yuyue_user,phone,yuyue_che,service_name,addtime,state,addtime,beizhu from nas_user_reservation,nas_service where ?=nas_service.id and state=? and (addtime between ? and ?) and(phone=?or yuyue_che=?);";
		    List<Reservation> query;
		    try {
				query = q.query(sql4, new BeanListHandler<Reservation>(Reservation.class),fw,biao,addtime,endtime,hao,hao);
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return null;}
	}
//查服务
	public List chaFuWu() {
		  QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		  String sql="select *from nas_service";
		    try {List query= q.query(sql, new BeanListHandler<Service>(Service.class));
			
				return query;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return null;
	}
	//编辑预约信息
	public void gaiYue(Integer id, String name, Integer fw, String addtime, String ttime, Integer zt, String phone,
			String chepai, String beizhu) {
		String biao=null;
		if(zt==1){biao="已预约";}
		else if(zt==2){biao="已服务";}
		 QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		 String sql="update nas_user_reservation set yuyue_user=?,service_id=?,addtime=?,finishtime=?,state=?,beizhu=?,yuyue_che=?,phone=? where id=?";
		 try {
			q.update(sql,name,fw,addtime,ttime,biao,beizhu,chepai,phone,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//查看所有预约信息
	public List chaAllYuYue() {
		 QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		   String sql=" select nas_user_reservation.id,yuyue_user,phone,yuyue_che,service_name,state,addtime,beizhu from nas_user_reservation,nas_service where service_id=nas_service.id";
	          try {
				return q.query(sql, new BeanListHandler<Reservation>(Reservation.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     return null;
	}

}
