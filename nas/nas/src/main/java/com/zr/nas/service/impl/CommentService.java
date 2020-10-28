package com.zr.nas.service.impl;

import java.util.ArrayList;

import com.zr.nas.dao.ICommentDao;
import com.zr.nas.dao.impl.CommentDao;
import com.zr.nas.pojo.Comment;
import com.zr.nas.service.ICommentService;

public class CommentService implements ICommentService {

	ICommentDao commentDao = new CommentDao();
	@Override
	public ArrayList<Comment> showCommentList() {
		// TODO Auto-generated method stub
		return commentDao.showCommentList();
	}
	@Override
	public ArrayList<Comment> showBadCommentList() {
		// TODO Auto-generated method stub
		return commentDao.showBadCommentList();
	}
	@Override
	public ArrayList<Comment> showPaiseCommentList() {
		// TODO Auto-generated method stub
		return commentDao.showPaiseCommentList();
	}
	@Override
	public Comment showdetail(int id) {
		// TODO Auto-generated method stub
		return commentDao.showdetail(id);
	}

}
