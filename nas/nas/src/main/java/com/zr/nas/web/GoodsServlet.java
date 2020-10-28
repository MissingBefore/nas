package com.zr.nas.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.service.IGoodsService;
import com.zr.nas.service.impl.GoodsService;

@WebServlet("/goods")
public class GoodsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	//goods服务层接口ig
	IGoodsService ig=new GoodsService();
	/**
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	//展示商品
	public String showGoodsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Goods> list = new ArrayList<Goods>();
		List list=ig.showGoodsList();
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();
		resp.getWriter().print(jsonString);//json返回信息
		   return null;
	}
	
	
	
	//修改商品的上架或者下架
	public String shangxiaJiaGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Integer id=Integer.parseInt(req.getParameter("id"));
     Integer state=Integer.parseInt(req.getParameter("state"));
     //a标志符，判断修改成功没有
          int a=ig.goodsGaiState(id,state);
		
		return null;
	}
	
	//添加商品
	public String tianJiaGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			        String name = req.getParameter("proname");
	        Integer price = Integer.parseInt(req.getParameter("pricein"));
	        Integer ticheng = Integer.parseInt(req.getParameter("ticheng"));
	        Integer digits = Integer.parseInt(req.getParameter("digits"));
	        Integer state = Integer.parseInt(req.getParameter("state"));
	        Integer classfiy = Integer.parseInt(req.getParameter("classfiy"));
	        String detail= req.getParameter("detail");
	         SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ");
	          String date = sf.format(new Date());
	       ig.tianJiaGoods(name,price,ticheng,digits,state,classfiy,detail,date);
	         return null;
		}
	
		//展示商品种类
	public void showGoodsLeiList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list=ig.showGoodsLeiList();
		JSONArray jsonArray = new JSONArray(list);
		String string = jsonArray.toString();
		resp.getWriter().print(string);
		
		
		
	} 
	//添加商品类型
 public void tianGoodsLei(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String classify = req.getParameter("classify");
	 System.out.println(classify);
	   ig.tianGoodsLei(classify);
	   List list=ig.showGoodsLeiList();
		JSONArray ja = new JSONArray(list);
		String xinxi = ja.toString();
		resp.getWriter().print(xinxi);}
 
 //对商品的类型进行更改
public void gaiGoodsLei(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Integer id=Integer.parseInt(req.getParameter("id"));
	 String editclass = req.getParameter("editclass"); 
	 ig.gaiGoodsLei(id,editclass);
 }
 
//对商品进行修改
public void gaiGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer id=Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	Double price = Double.parseDouble(req.getParameter("price"));
	Double tc = Double.parseDouble(req.getParameter("tc"));
	Integer cun=Integer.parseInt(req.getParameter("cun"));
	Integer state=Integer.parseInt(req.getParameter("state"));
	int xz = Integer.parseInt(req.getParameter("xz"));
	String ms = req.getParameter("ms");
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	String date = sd.format(new Date());
	ig.gaiGoods(id,name,price,tc,cun,state,xz,ms,date);
}
//删除商品后并返回目前商品的信息
public void shanGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Integer id=Integer.parseInt(req.getParameter("id"));
	 ig.shanGoods(id);
	List list=ig.showGoodsLeiList();
	
	JSONArray ja = new JSONArray(list);
	String xinxi = ja.toString();
	resp.getWriter().print(xinxi);
}
//删除商品种类的类型
public void shanGoodsLei(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	ig.shanGoodsLei(id);
    List list=ig.showGoodsLeiList();
	JSONArray ja = new JSONArray(list);
	String xinxi = ja.toString();
	resp.getWriter().print(xinxi);
}
}
