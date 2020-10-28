package com.zr.nas.service;



import java.util.List;

import com.zr.nas.pojo.Car;
import com.zr.nas.pojo.DebitCard;
import com.zr.nas.pojo.GiftPack;
import com.zr.nas.pojo.User;
import com.zr.nas.pojo.UserVO;
import com.zr.nas.pojo.YearCard;

public interface IUserService {
	boolean insert(UserVO userVO);

	UserVO findByKeywords(String keywords);

	//显示所有会员
	List<User> showUserList();

	//查询会员详细信息
	List<User> searchUserInfo(String input);

	//修改会员信息
	void updateUser(User user);

	//查询会员车辆信息
	List<Car> searchUserCarInfo(String id);

	//查询会员储值卡信息
	List<DebitCard> searchDebitCardInfo(String id);

	//查询会员年卡信息
	List<YearCard> searchYearCardInfo(String id);

	//查询会员大礼包
	List<GiftPack> searchGiftPackInfo(String id);
}
