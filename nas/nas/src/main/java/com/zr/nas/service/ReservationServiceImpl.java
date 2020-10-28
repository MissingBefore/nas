package com.zr.nas.service;



import java.util.List;


import com.zr.nas.dao.impl.ReservationDao;
import com.zr.nas.pojo.Reservation;
import com.zr.nas.pojo.ReservationToday;



public class ReservationServiceImpl implements ReservationService{
	ReservationDao reservationDao = new ReservationDao();
	@Override
	public List<ReservationToday> showTodayReservation() {
		
		return reservationDao.findTodayReservation();
	}

	@Override
	public List<Reservation> showReservations() {
		return null;
	}

}
