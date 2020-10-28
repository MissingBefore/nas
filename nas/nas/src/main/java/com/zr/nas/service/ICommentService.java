package com.zr.nas.service;

import java.util.ArrayList;

import com.zr.nas.pojo.Comment;

public interface ICommentService {

	ArrayList<Comment> showCommentList();

	ArrayList<Comment> showBadCommentList();

	ArrayList<Comment> showPaiseCommentList();

	Comment showdetail(int id);


}
