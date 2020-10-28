package com.zr.nas.dao;

import java.util.List;

public interface IReservationCardDao {

	List chaXiaoShou();

	void tianYuShouKa(Integer yushouka, Integer chuka, Integer nianka, Integer kahao, Integer chongzhi, String pay,
			String xiaoshou);

	
	
}
