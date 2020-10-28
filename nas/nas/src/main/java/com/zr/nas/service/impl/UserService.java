package com.zr.nas.service.impl;


import java.util.List;

import com.zr.nas.dao.IUserDao;
import com.zr.nas.dao.impl.UserDao;
import com.zr.nas.pojo.Car;
import com.zr.nas.pojo.DebitCard;
import com.zr.nas.pojo.GiftPack;
import com.zr.nas.pojo.User;
import com.zr.nas.pojo.UserVO;
import com.zr.nas.pojo.YearCard;
import com.zr.nas.service.IUserService;

public class UserService implements IUserService{
	IUserDao userDao = new UserDao();
	@Override
	public boolean insert(UserVO userVO) {
		
		return userDao.Insert(userVO);
	}

	@Override
	public UserVO findByKeywords(String keywords) {
		return userDao.findByKeywords(keywords);
	}

	//显示所有的会员信息
	@Override
	public List<User> showUserList() {
		
		return userDao.showUserList();
	}

	//显示会员详情信息
	@Override
	public List<User> searchUserInfo(String input) {
		
		return userDao.searchUserInfo(input);
	}


	//修改会员详情信息
	@Override
	public void updateUser(User user) {
		UserDao.updateUser(user);
	}

	//查询会员的车辆信息
	@Override
	public List<Car> searchUserCarInfo(String id) {
		
		return userDao.searchUserCarInfo(id);
	}

	//查询会员的储值卡信息
	@Override
	public List<DebitCard> searchDebitCardInfo(String id) {
		
		return userDao.searchDebitCardInfo(id);
	}

	//查询会员的年卡信息
	@Override
	public List<YearCard> searchYearCardInfo(String id) {
		
		return userDao.searchYearCardInfo(id);
	}

	//查询会员的大礼包信息
	@Override
	public List<GiftPack> searchGiftPackInfo(String id) {
		
		return userDao.searchGiftPackInfo(id);
	}
	
}
