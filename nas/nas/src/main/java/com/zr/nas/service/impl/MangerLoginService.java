package com.zr.nas.service.impl;

import com.zr.nas.dao.IMangerLoginDao;
import com.zr.nas.dao.impl.MangerLoginDao;
import com.zr.nas.pojo.Manger;
import com.zr.nas.service.IMangerLoginService;

public class MangerLoginService implements IMangerLoginService {
//创建管理员登陆dao层对象
	IMangerLoginDao il=new MangerLoginDao();
	public Manger managerLogin(String zhanghao, String mima) {
		// TODO Auto-generated method stub
		return il.mangerLogin(zhanghao,mima);
	}

}
