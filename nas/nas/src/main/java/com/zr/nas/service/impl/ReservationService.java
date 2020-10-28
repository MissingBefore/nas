package com.zr.nas.service.impl;

import java.util.List;

import com.zr.nas.dao.impl.ReservationDao;
import com.zr.nas.pojo.Reservation;
import com.zr.nas.pojo.ReservationToday;
import com.zr.nas.service.IReservationService;

public class ReservationService implements IReservationService{
	ReservationDao reservationDao = new ReservationDao();
	@Override
	public List<ReservationToday> showTodayReservation() {
		
		return reservationDao.findTodayReservation();
	}

}
