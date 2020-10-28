package com.zr.nas.dao;



import java.util.List;

import com.zr.nas.pojo.Car;
import com.zr.nas.pojo.DebitCard;
import com.zr.nas.pojo.GiftPack;
import com.zr.nas.pojo.User;
import com.zr.nas.pojo.UserBilling;
import com.zr.nas.pojo.UserVO;
import com.zr.nas.pojo.YearCard;



public interface IUserDao {
	List<UserBilling> findById();

	boolean Insert(UserVO userVO);

	UserVO findByKeywords(String keywords);

	//显示所有的会员信息
	List<User> showUserList();

	//查询会员详细信息
	List<User> searchUserInfo(String input);

	//查询会员的车辆信息
	List<Car> searchUserCarInfo(String id);

	//查询会员的储蓄卡信息
	List<DebitCard> searchDebitCardInfo(String id);

	//查询会员的年卡信息
	List<YearCard> searchYearCardInfo(String id);

	//查询会员的大礼包信息
	List<GiftPack> searchGiftPackInfo(String id);
}
