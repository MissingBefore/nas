package com.zr.nas.service.impl;

import java.util.ArrayList;

import com.zr.nas.dao.IBusinessDao;
import com.zr.nas.dao.impl.BusinessDao;
import com.zr.nas.pojo.Business;
import com.zr.nas.service.IBusinessService;
import com.zr.nas.pojo.Performance_report;
public class BusinessService implements IBusinessService {

	
	IBusinessDao businessDao = new BusinessDao();
	@Override
	public Business search(String start_date, String end_date) {
		// TODO Auto-generated method stub
		return businessDao.search(start_date, end_date);
	}
	@Override
	public ArrayList<Performance_report> Performance_report(Integer i) {
		// TODO Auto-generated method stub
		return businessDao.Performance_report(i);
	}

}
