package com.zr.nas.service.impl;

import java.util.List;

import com.zr.nas.dao.IReservationUserDao;
import com.zr.nas.dao.impl.ReservationUserDao;
import com.zr.nas.service.IReservationUserService;

public class ReservationUserService implements IReservationUserService{
//预约Dao层对象
	IReservationUserDao ird=new ReservationUserDao();
	public List chaYuYue(Integer fw, Integer zt, String addtime, String endtime, String hao) {
		// TODO Auto-generated method stub
		return ird.chaYuYue(fw, zt, addtime, endtime, hao);
		
	}
	public List chaFuWu() {
		// TODO Auto-generated method stub
		return ird.chaFuWu();
	}
	public void gaiYue(Integer id, String name, Integer fw, String addtime, String ttime, Integer zt, String phone,
			String chepai, String beizhu) {
		ird.gaiYue(id,name,fw,addtime,ttime,zt,phone,chepai,beizhu);
	}
	public List chaAllYuYue() {
		// TODO Auto-generated method stub
		return ird.chaAllYuYue();
	}

}
