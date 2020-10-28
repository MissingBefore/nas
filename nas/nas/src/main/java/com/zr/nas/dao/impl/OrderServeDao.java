package com.zr.nas.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;


import com.zr.nas.pojo.ServeInfoDTO;
import com.zr.nas.utils.TxDBUtils;

public class OrderServeDao {
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());

	public boolean insert(ServeInfoDTO serveInfoDTO,int order_id,int constructorsId) {
		String sql ="insert into nas_order_service(order_id,service_id,car_type_id,emp_constructors_id,emp_seller_id) value(?,?,?,?,?)";
		try {
			int execute = queryRunner.execute(sql, order_id,serveInfoDTO.getServeId(),serveInfoDTO.getModelsId(),constructorsId,serveInfoDTO.getStaffId());
			if(execute==1)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
