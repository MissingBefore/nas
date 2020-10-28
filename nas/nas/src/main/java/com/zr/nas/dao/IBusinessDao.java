package com.zr.nas.dao;

import java.util.ArrayList;

import com.zr.nas.pojo.Business;
import com.zr.nas.pojo.Performance_report;

public interface IBusinessDao {

	Business search(String start_date, String end_date);

	ArrayList<Performance_report> Performance_report(Integer i);

}
