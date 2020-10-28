package com.zr.nas.service.impl;

import java.util.List;

import com.zr.nas.dao.IReservationCardDao;
import com.zr.nas.dao.impl.ReservationCardDao;
import com.zr.nas.service.IReservationCardService;

public class ReservationCardService implements IReservationCardService {
//创建预售卡dao层对象
	IReservationCardDao irc=new ReservationCardDao();
	public List chaXiaoShou() {
		// TODO Auto-generated method stub
		return irc.chaXiaoShou();
	}
	public void tianYuShouKa(Integer yushouka, Integer chuka, Integer nianka, Integer kahao, Integer chongzhi,
			String pay, String xiaoshou) {
		irc.tianYuShouKa(yushouka,chuka,nianka,kahao,chongzhi,pay,xiaoshou);
		
	}
	
	
}
