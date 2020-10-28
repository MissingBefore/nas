package com.zr.nas.service;
import java.util.List;

public interface IReservationUserService {
//查预约用户
	List chaYuYue(Integer fw, Integer zt, String addtime, String endtime, String hao);
//查服务
	List chaFuWu();
	//修改预约
	void gaiYue(Integer id, String name, Integer fw, String addtime, String ttime, Integer zt, String phone,
			String chepai, String beizhu);
	//查询所有的预约信息
	List chaAllYuYue();

}
