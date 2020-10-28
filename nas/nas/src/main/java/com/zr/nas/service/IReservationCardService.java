package com.zr.nas.service;


import java.util.List;

public interface IReservationCardService {
//查看销售人员
	List chaXiaoShou();
//添加预售卡

	void tianYuShouKa(Integer yushouka, Integer chuka, Integer nianka, Integer kahao, Integer chongzhi, String pay,
			String xiaoshou);

	
	
	

	
}
