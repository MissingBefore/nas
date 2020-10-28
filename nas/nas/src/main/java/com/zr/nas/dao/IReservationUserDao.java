package com.zr.nas.dao;

import java.util.List;

public interface IReservationUserDao {

  List chaYuYue(Integer fw, Integer zt, String addtime, String endtime, String hao);

	List chaFuWu();

	void gaiYue(Integer id, String name, Integer fw, String addtime, String ttime, Integer zt, String phone,
			String chepai, String beizhu);

	List chaAllYuYue();

}
