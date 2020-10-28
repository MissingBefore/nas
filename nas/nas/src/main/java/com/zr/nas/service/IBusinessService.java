package com.zr.nas.service;

import java.util.ArrayList;

import com.zr.nas.pojo.Business;
import com.zr.nas.pojo.Performance_report;

public interface IBusinessService {

	Business search(String start_date, String end_date);

	ArrayList<Performance_report> Performance_report(Integer i);

}
