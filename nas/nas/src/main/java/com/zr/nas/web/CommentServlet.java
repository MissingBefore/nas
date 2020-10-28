package com.zr.nas.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.pojo.Comment;
import com.zr.nas.service.ICommentService;
import com.zr.nas.service.impl.CommentService;

@SuppressWarnings("serial")
@WebServlet("/CommentServlet")
/**
 * 评论管理
 * 
 * @author YYT
 *
 */
public class CommentServlet extends BaseServlet {

	/**
	 * 展示所有评论
	 */
	public void showCommentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICommentService commentService = new CommentService();
		ArrayList<Comment> commentList = commentService.showCommentList();
		JSONArray json = new JSONArray(commentList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 展示所有评论
	 */
	public void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		showCommentList(req, resp);
	}

	/**
	 * 展示差评
	 */
	public void bad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICommentService commentService = new CommentService();
		ArrayList<Comment> commentList = commentService.showBadCommentList();
		JSONArray json = new JSONArray(commentList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 展示好评
	 */
	public void paise(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICommentService commentService = new CommentService();
		ArrayList<Comment> commentList = commentService.showPaiseCommentList();
		JSONArray json = new JSONArray(commentList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 展示详情评论
	 */
	public void showdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		ICommentService commentService = new CommentService();
		String id = req.getParameter("id");
		Comment comment = commentService.showdetail(Integer.parseInt(id));
		String detail = comment.getCom_content();
		detail = "{\"msg\":\"" + detail + "\"}";
		resp.getWriter().print(detail);
	}

}
