package com.zr.nas.dao.impl;

import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.ICommentDao;
import com.zr.nas.pojo.Comment;
import com.zr.nas.utils.TxDBUtils;

public class CommentDao implements ICommentDao {


	@Override
	public ArrayList<Comment> showCommentList() {
		ArrayList<Comment> commentList = null;
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT nas_order.order_id AS order_id,nas_user.`name` AS `name`,nas_order.order_createdate AS order_createdate,nas_station_comment.submit_time AS com_date,nas_station_comment.detail AS com_content,nas_station_comment.`level` AS com_score,nas_station_comment.id AS id FROM nas_user,nas_order INNER JOIN nas_station_comment ON nas_order.order_id = nas_station_comment.order_id WHERE nas_station_comment.order_id = nas_order.order_id AND nas_order.u_id = nas_user.id";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			commentList = (ArrayList<Comment>) runner.query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return commentList;
	}

	@Override
	public ArrayList<Comment> showBadCommentList() {
		ArrayList<Comment> commentList = null;
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT nas_order.order_id AS order_id,nas_user.`name` AS `name`,nas_order.order_createdate AS order_createdate,nas_station_comment.submit_time AS com_date,nas_station_comment.detail AS com_content,nas_station_comment.`level` AS com_score,nas_station_comment.id AS id FROM	nas_user,	nas_order	INNER JOIN nas_station_comment ON nas_order.order_id = nas_station_comment.order_id WHERE	nas_station_comment.order_id = nas_order.order_id	AND nas_order.u_id = nas_user.id AND nas_station_comment.`level` < 3";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			commentList = (ArrayList<Comment>) runner.query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return commentList;
	}

	@Override
	public ArrayList<Comment> showPaiseCommentList() {
		ArrayList<Comment> commentList = null;
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT nas_order.order_id AS order_id,nas_user.`name` AS `name`,nas_order.order_createdate AS order_createdate,nas_station_comment.submit_time AS com_date,nas_station_comment.detail AS com_content,nas_station_comment.`level` AS com_score,nas_station_comment.id AS id FROM	nas_user,	nas_order	INNER JOIN nas_station_comment ON nas_order.order_id = nas_station_comment.order_id WHERE	nas_station_comment.order_id = nas_order.order_id	AND nas_order.u_id = nas_user.id AND nas_station_comment.`level` >= 3";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			commentList = (ArrayList<Comment>) runner.query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return commentList;
	}

	@Override
	public Comment showdetail(int id) {
		Comment comment = null;
		
		try {
			String sql = "SELECT nas_order.order_id AS order_id,nas_user.`name` AS `name`,nas_order.order_createdate AS order_createdate,nas_station_comment.submit_time AS com_date,nas_station_comment.detail AS com_content,nas_station_comment.`level` AS com_score,nas_station_comment.id AS id FROM nas_user,nas_order INNER JOIN nas_station_comment ON nas_order.order_id = nas_station_comment.order_id WHERE	nas_station_comment.order_id = nas_order.order_id AND nas_order.u_id = nas_user.id 	AND nas_station_comment.id = ?";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			comment = runner.query(sql, new BeanHandler<Comment>(Comment.class),id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return comment;
	}

	

}
