package com.zr.nas.service;



import java.util.List;

import com.zr.nas.pojo.Reservation;
import com.zr.nas.pojo.ReservationToday;



public interface ReservationService {
	List<Reservation> showReservations();
	List<ReservationToday> showTodayReservation();
}
