package com.zr.nas.dao;

import java.util.ArrayList;

import com.zr.nas.pojo.Comment;

public interface ICommentDao {

	ArrayList<Comment> showCommentList();

	ArrayList<Comment> showBadCommentList();

	ArrayList<Comment> showPaiseCommentList();

	Comment showdetail(int id);

	

}
