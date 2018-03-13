package com.avd.dao;

import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.avd.common.util.JdbcConnection;
import com.avd.model.LOG_ERROR;
import com.avd.model.ProductDisplayImages;
import com.avd.model.ProductFinalOrder;
import com.avd.model.ProductFinalOrdersInformation;
import com.avd.model.ProductImages;
import com.avd.model.ProductReviews;
import com.avd.model.TblCartRecord;
import com.avd.model.TblMessageLog;
import com.avd.model.TblProductInformation;
import com.avd.model.UserLogin;
import com.avd.service.vo.ProductMenu;
import com.avd.service.vo.SubProduct;


public class CustomerServiceDaoImpl extends HibernateDaoSupport implements CustomerServiceDao{

	

	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	Query query = null;
	Criteria cr = null;
	@Override
	public List<Object[]> getProductInfo(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price, "
+ " t2.product_images from tbl_product_information t1"
+" inner join tbl_product_display_images t2 on t2.p_id= t1.product_id and t2.category_id=t1.category_id and t1.sub_category_id=t2.sub_category_id" +
" where t1.category_id='"+map.get("category").toString()+"' and t2.sub_category_id='"+map.get("subCategory").toString()+"' and t1.is_active=1 and t1.quantity >0 LIMIT "+map.get("count1").toString()+","+map.get("count2").toString());
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}


	@Override
	public List<Object[]> getSelectedProductImages(Map<String, Object> map) {
	List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select t1.p_id, t1.product_image_large,t1.product_image_medium  "
+ "  from tbl_product_images t1"
+" where t1.category_id='"+map.get("categoryId").toString()+"' and t1.sub_category_id='"+map.get("subCategoryId").toString()+"'and t1.p_id='"+map.get("productId").toString()+"' order by t1.image_id");
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}


	@Override
	public String signup(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		String login_id="";
		try{
		
			
			SQLQuery qry = session
					.createSQLQuery("select max(login_id)+1 ,max(login_id) as a from user_login");
			productInfo=qry.list();
			for(Object[] reslt: productInfo)
			{
				
				login_id=String.valueOf(reslt[0]);
			}

			if("null".equals(login_id))
			{
				login_id="0";
			}
			String validCode=map.get("code").toString()+login_id;
			
			UserLogin user = new UserLogin();
			user.setEmailId(map.get("email").toString());
			user.setUserName(map.get("userName").toString());
			user.setPassword(map.get("password").toString());
			user.setValidCode(validCode);
			user.setFlag("0");
			user.setIsActive("0");
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
			System.out.println(user.getLoginId());

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return login_id;
	}

		
	
	@Override
	public List<ProductMenu> getProductMenu(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		List<Object[]> productInf = new ArrayList<Object[]>();
		
		List<ProductMenu> menu =  new ArrayList<ProductMenu>();
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select category_Id, category_name from lu_category where is_active=1");
		productInfo=qry.list();
		
		
		
		for(Object[] obj : productInfo)
		{
			
			ProductMenu product = new ProductMenu();
			product.setCategoryId(String.valueOf(obj[0]));
			product.setCategoryDesc(String.valueOf(obj[1]));
			product.setFlag("0");
			
			List<SubProduct> subMenu = new ArrayList<SubProduct>();
			qry = session
					.createSQLQuery("select category_Id, sub_category_Id,sub_category_desc from lu_sub_category where category_id='"+product.getCategoryId()+"' and is_active=1");
			productInf=qry.list();
			for(Object[] ob: productInf)
			{
				product.setFlag("1");
				SubProduct sub = new SubProduct();
				sub.setCategoryId(String.valueOf(ob[0]));
				sub.setSubCategoryId(String.valueOf(ob[1]));
				sub.setSubCatDesc(String.valueOf(ob[2]));
				subMenu.add(sub);
			}
			
			product.setMemberList(subMenu);
			menu.add(product);
		}
		
		

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return menu;
	}


	@Override
	public String checkEmail(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		String login_id="0";
		try{
		
			
			SQLQuery qry = session
					.createSQLQuery("select email_Id ,user_name from user_login where email_id='"+map.get("email").toString()+"'");
			productInfo=qry.list();
			for(Object[] reslt: productInfo)
			{
				
				login_id="1";
			}

					

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return login_id;
	}



	@Override
	public String authenticateSignup(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		Query query = null;
		String login_id="";
		String flag="0";
		try{
			SQLQuery qry = session
					.createSQLQuery("select valid_code ,login_Id  from user_login where valid_code='"+map.get("validCode").toString()+"' and is_active='0' and flag='0'");
			productInfo=qry.list();
			for(Object[] reslt: productInfo)
			{
				login_id=String.valueOf(reslt[1]);
				System.out.println(login_id);
				flag="1";
				txn = session.getTransaction();
				txn.begin();
				query = session.createQuery("from UserLogin where login_Id=?");
				query.setInteger(0, Integer.parseInt(login_id));
				UserLogin familyAdd = null;
				List<UserLogin> familyAddList = query.list();
				familyAdd = familyAddList.get(0);
				familyAdd.setIsActive("1");
				familyAdd.setFlag("1");
				session.update(familyAdd);
				txn.commit();
			}
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return flag;
	}
	@Override
	public String authenticateLogin(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		Query query = null;
		String login_id="";
		String flag="0";
		try{
		
		
			SQLQuery qry = session
					.createSQLQuery("select valid_code ,login_Id  from user_login where email_id='"+map.get("email").toString()+"' and is_active='1' and password='"+map.get("password").toString()+"'");
			productInfo=qry.list();
			for(Object[] reslt: productInfo)
			{
				
				flag="1";

			}
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return flag;
	}
	
	
	@Override
	public List<Object[]> getLoginCredentials(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select login_id, user_name,email_Id, user_code from user_login where email_Id='"+map.get("email").toString()+"'");
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}
	public List<TblProductInformation> getProductData(Map<String,Object> map) {
		List<TblProductInformation> cityList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			int pId=Integer.parseInt(map.get("productId").toString());
			Criteria cr = session.createCriteria(TblProductInformation.class);
			cr.add(Restrictions.eq("productId", pId));
			cityList = cr.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return cityList;

	}

	
	@Override
	public String getCartProducts(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		Query query = null;
		String login_id="";
		String flag="0";
		try{
		
		
			SQLQuery qry = session
					.createSQLQuery("select count(product_id) ,count(user_id) from tbl_cart_record where user_id='"+map.get("loginId").toString()+"'");
			productInfo=qry.list();
			for(Object[] reslt: productInfo)
			{
				
				flag=String.valueOf(reslt[0]);

			}
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return flag;
	}
	
	@Override
	public String getCartProductId(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		Query query = null;
		String login_id="";
		String flag="0";
		try{	
			SQLQuery qry = session
					.createSQLQuery("select product_id , quantity  from tbl_cart_record where user_id='"+map.get("loginId").toString()+"'");
			productInfo=qry.list();
			String id="";
		String	matchedId=map.get("productId").toString();
			for(Object[] reslt: productInfo)
			{
				id=String.valueOf(reslt[0]);
				if(matchedId.equals(id))
				{
					flag="1";
					break;
				}
			}
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return flag;
	}
	
	
	
	public Integer getArtificalId() {
		String code = "";
		ResultSet rs = null;
		Connection conn = null;
		String prdctId="0";
		Integer productId=0;
		PreparedStatement ps = null;
		try {

			conn = new JdbcConnection().getConnection();
			ps = conn
					.prepareStatement("select max(id)  as cnt from USER_VISIT_LOG");
			rs = ps.executeQuery();

			while (rs.next()) {
				prdctId= rs.getString("cnt");
			}

			
			
			if ("null".equalsIgnoreCase(prdctId) | null==prdctId | "".equals(prdctId))
			productId=1;
				else
			productId= new Integer(prdctId)+1;
					

			
			
			ps = conn
					.prepareStatement("INSERT INTO  USER_VISIT_LOG (ID) VALUES"
							+ "  ("+productId+")");
			
			System.out.println("ps"+ps);
			
			ps.executeUpdate();

			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {

			}
		}

		return productId;
	}
	
	
	
	
	public String saveToCart(Map<String,Object> map)
			 {



		Session session = sessionFactory.openSession();
		Transaction tx = null;
		java.util.Date date = new java.util.Date();
		try {
			
			tx = session.beginTransaction();
			TblCartRecord image = new TblCartRecord();
			image.setProductId(new Integer(map.get("productId").toString()));
			image.setUserId(map.get("loginId").toString());
			image.setQuantity(new Integer(map.get("quantity").toString()));
			image.setCreatedDate(new Timestamp(date.getTime()));
			session.saveOrUpdate(image);
			
			tx.commit();
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return "2";
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}	
	
	
	
	
	@Override
	public List<Object[]> getCartProductsDesc(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price,t3.quantity ,t1.discounted_price * t3.quantity "
+ " ,t2.product_images , t1.is_active , t1.quantity as quant from tbl_cart_record t3"
+" inner join tbl_product_display_images t2 on t2.p_id= t3.product_id " 
+" inner join tbl_product_information t1 on t1.product_id= t3.product_id " 
+" where  t3.user_id='"+map.get("loginId").toString()+"'");
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}

	
	public String removeProducts(Map<String,Object> map)
			 {

		PreparedStatement ps = null;

		Session session = sessionFactory.openSession();
		Transaction tx = null;
	
		try {
			
			tx = session.beginTransaction();
			TblCartRecord image = new TblCartRecord();
			image.setProductId(new Integer(map.get("productId").toString()));
			image.setUserId(map.get("loginId").toString());
			session.delete(image);
			
			tx.commit();
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return "2";
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}	
	
	public String saveFinalProducts(Map<String,Object> map)
	{

		PreparedStatement ps = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		java.util.Date date = new java.util.Date();
		String str="";
		try {	
			System.out.println("flag>>>"+map.get("flag"));
			
			if("1".equals(map.get("flag")))
			{
			tx = session.beginTransaction();
			ProductFinalOrdersInformation obj = new ProductFinalOrdersInformation();
			java.util.Date now = new java.util.Date(); 
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp( now.getTime()); 
			Long ln = (currentTimestamp.getTime()); 
			 str = String.valueOf(ln);
			obj.setOrderId(str);
			obj.setLoginId(map.get("loginId").toString());
			obj.setAddress(map.get("address").toString());
			obj.setName(map.get("name").toString());
			obj.setEmailId(map.get("email").toString());
			obj.setOrderDate(currentTimestamp);
			obj.setMobileNo(map.get("mobileNo").toString());
			obj.setPinCode(Integer.parseInt(map.get("pincode").toString()));
			obj.setTotalAmount(Integer.parseInt(map.get("totalAmount").toString()));
			session.saveOrUpdate(obj);

			ProductFinalOrder order = new ProductFinalOrder();
			order.setAmount(Integer.parseInt(map.get("totalAmount").toString()));
			order.setOrderId(str);
			order.setProductId(Integer.parseInt(map.get("productId").toString()));
			order.setQuantity(1);
			order.setOrderDate(currentTimestamp);
			order.setReturnDays(Integer.parseInt(map.get("returnDays").toString()));
			session.saveOrUpdate(order);

			tx.commit();
			
			}
			else if("3".equals(map.get("flag")))
			{
				str=map.get("orderId").toString();
				tx = session.beginTransaction();
				ProductFinalOrdersInformation obj = new ProductFinalOrdersInformation();
				java.util.Date now = new java.util.Date(); 
				java.sql.Timestamp currentTimestamp = new java.sql.Timestamp( now.getTime()); 
				obj.setOrderId(str);
				obj.setLoginId(map.get("loginId").toString());
				obj.setAddress(map.get("address").toString());
				obj.setName(map.get("name").toString());
				obj.setEmailId(map.get("email").toString());
				obj.setOrderDate(currentTimestamp);
				obj.setMobileNo(map.get("mobileNo").toString());
				obj.setPinCode(Integer.parseInt(map.get("pincode").toString()));
				obj.setTotalAmount(Integer.parseInt("0"));
				session.saveOrUpdate(obj);
				tx.commit();
			}
			
			else{
				tx = session.beginTransaction();
				ProductFinalOrdersInformation obj = new ProductFinalOrdersInformation();
				java.util.Date now = new java.util.Date(); 
				java.sql.Timestamp currentTimestamp = new java.sql.Timestamp( now.getTime()); 
				Long ln = (currentTimestamp.getTime()); 
				 str = String.valueOf(ln);
				obj.setOrderId(str);
				obj.setLoginId(map.get("loginId").toString());
				obj.setAddress(map.get("address").toString());
				obj.setName(map.get("name").toString());
				obj.setEmailId(map.get("email").toString());
				obj.setOrderDate(currentTimestamp);
				obj.setMobileNo(map.get("mobileNo").toString());
				obj.setPinCode(Integer.parseInt(map.get("pincode").toString()));
				obj.setTotalAmount(Integer.parseInt(map.get("totalAmount").toString()));
				session.saveOrUpdate(obj);
				List<Object[]> mem = new ArrayList<Object[]>();
				SQLQuery qry = session
						.createSQLQuery("select t1.product_Id, t1.quantity , t2.discounted_price , t2.return_days from  tbl_cart_record t1 "+
								" inner join tbl_product_information t2 on t2.product_id=t1.product_id "
								+ " where t1.user_id=? and t2.is_active=1 and t2.quantity>0");

				String bhId = map.get("loginId").toString();
				
				System.out.println("bhId" + bhId);
				
				qry.setString(0, bhId);

				System.out.println("sql>>>" + qry);
				mem = qry.list();
				for(Object[] a: mem)
				{
				ProductFinalOrder order = new ProductFinalOrder();
				order.setAmount(Integer.parseInt(String.valueOf(a[2])));
				order.setOrderId(str);
				order.setProductId(Integer.parseInt(String.valueOf(a[0])));
				order.setQuantity(Integer.parseInt(String.valueOf(a[1])));
				order.setOrderDate(currentTimestamp);
				order.setReturnDays(Integer.parseInt(String.valueOf(a[3])));
				session.saveOrUpdate(order);
				}
				tx.commit();
								
				
				
			}			
			
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return "X";
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	

	@Override
	public List<Object[]> getReceiverAddress(Map<String, Object> map) {
List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select email_id , name, order_id , total_amount , address , mobile_no , pin_code "
+ "  from product_final_orders_information "
+" where  login_id='"+map.get("loginId").toString()+"' and order_id='"+map.get("orderId").toString()+"'");
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}	
		

	@Override
	public List<Object[]> getFinalProductsDesc(Map<String, Object> map) {
		
		List<Object[]> productInfo = new ArrayList<Object[]>();
		
		Session session = sessionFactory.openSession();
		try{
		SQLQuery qry = session
				.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price,t3.quantity,t1.discounted_price * t3.quantity "
+ " ,t2.product_images ,t1.is_active , t1.quantity as quant from product_final_orders t3"
+" inner join tbl_product_display_images t2 on t2.p_id= t3.product_id " 
+" inner join tbl_product_information t1 on t1.product_id= t3.product_id " 
+" where   t3.order_id='"+map.get("orderId").toString()+"'");
		productInfo=qry.list();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return productInfo;
	}	
	
	/*select t1.quantity*t2.discounted_price from tbl_cart_record t1
	inner join tbl_product_information t2 on t1.product_id=t2.product_id
*/
	public List<Object[]> updateCartProducts(Map<String,Object> map)
	 {


List<Object[]> productInfo = new ArrayList<Object[]>();
		
		
Session session = sessionFactory.openSession();
Transaction tx = null;
java.util.Date date = new java.util.Date();
try {
	
	tx = session.beginTransaction();
	TblCartRecord image = new TblCartRecord();
	image.setProductId(new Integer(map.get("productId").toString()));
	image.setUserId(map.get("loginId").toString());
	image.setQuantity(new Integer(map.get("quantity").toString()));
	image.setCreatedDate(new Timestamp(date.getTime()));
	session.saveOrUpdate(image);
	
	tx.commit();
	
	
	SQLQuery qry = session
			.createSQLQuery("select t1.product_id, t1.quantity*t2.discounted_price from tbl_cart_record t1 "
+" inner join tbl_product_information t2 on t1.product_id=t2.product_id " 
+" where  t1.user_id='"+map.get("loginId").toString()+"'");
	productInfo=qry.list();

} catch (Exception e) {
	e.printStackTrace();
	if (tx != null) {
		tx.rollback();
	}
	
} finally {
	if (session != null) {
		session.close();
	}
}
return productInfo;

}	


	public String removeFinalProducts(Map<String,Object> map)
	 {

		PreparedStatement ps = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
	
	tx = session.beginTransaction();
	ProductFinalOrder order = new ProductFinalOrder();
	order.setOrderId(map.get("orderId").toString());
	order.setProductId(Integer.parseInt(map.get("productId").toString()));
	session.delete(order);
	
	tx.commit();
	return "1";
} catch (Exception e) {
	e.printStackTrace();
	if (tx != null) {
		tx.rollback();
	}
	return "2";
} finally {
	if (session != null) {
		session.close();
	}
}
}	

public List<Object[]> updateFinalCartProducts(Map<String,Object> map)
	 {

List<Object[]> productInfo = new ArrayList<Object[]>();		
Session session = sessionFactory.openSession();
Transaction tx = null;
java.util.Date date = new java.util.Date();
Connection conn = null;

PreparedStatement ps = null;
try {
	conn = new JdbcConnection().getConnection();
	ps = conn
			.prepareStatement("update product_final_orders set quantity='"+map.get("quantity").toString()+"' where order_id='"+map.get("orderId").toString()+"' and product_id='"+map.get("productId").toString()+"'");
	 ps.executeUpdate();

	SQLQuery qry = session
			.createSQLQuery("select t1.product_id, t1.quantity*t1.amount from  product_final_orders t1 "
+" where  t1.order_id='"+map.get("orderId").toString()+"'");
	productInfo=qry.list();

} catch (Exception e) {
	e.printStackTrace();
	if (tx != null) {
		tx.rollback();
	}
	
} finally {
	if (session != null) {
		session.close();
	}
	
	try {
		if (conn != null) {
			conn.close();
		}

		if (ps != null) {
			ps.close();
		}

	} catch (SQLException e) {

	}
	
}
return productInfo;
}	





@Override
public List<Object[]> getOrderDetails(Map<String, Object> map) {
	
	List<Object[]> productInfo = new ArrayList<Object[]>();
	
	Session session = sessionFactory.openSession();
	try{
		
		String toAppend=" t4.order_id is null";
		if("1".equals(map.get("flag").toString()))
		{
			toAppend=" t4.login_id='"+map.get("loginId").toString()+"'";
		}
		else if("2".equals(map.get("flag").toString())){
			toAppend=" t4.order_id='"+map.get("orderId").toString()+"'";
		}
	SQLQuery qry = session
			.createSQLQuery("select t4.*, t2.status from product_final_orders_information t4 " 
					+" inner join lu_order_status t2 on t2.id=t4.status_id "
					+" where t4.customer_finalize=1 and "+toAppend);
	productInfo=qry.list();

	} catch (HibernateException e) {

		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();

		}
	}

	return productInfo;
}	


public String updateTotalAmount(Map<String,Object> map)
{

List<Object[]> productInfo = new ArrayList<Object[]>();		
Session session = sessionFactory.openSession();
Transaction tx = null;
java.util.Date date = new java.util.Date();
Connection conn = null;

PreparedStatement ps = null;
try {
conn = new JdbcConnection().getConnection();


if("1".equals(map.get("flag").toString()))
{
ps = conn
		.prepareStatement("update product_final_orders_information set total_Amount='"+map.get("totalAmount").toString()+"' where order_id='"+map.get("orderId").toString()+"'");
ps.executeUpdate();
}
else if("2".equals(map.get("flag").toString()))
{
	String deliveryTime="7";
	SQLQuery qry = session
			.createSQLQuery("select max(delivery_time ),'1' from tbl_product_information t1 where t1.product_id in (select product_id from product_final_orders where order_id='"+map.get("orderId").toString()+"')");

	productInfo=qry.list();
	
	for(Object[] a : productInfo)
	{
		deliveryTime=String.valueOf(a[0]);
		
	}
	ps = conn
		.prepareStatement("update product_final_orders_information set order_date=current_timestamp ,expected_delivery_date=curdate()+"+deliveryTime+" , TOTAL_AMOUNT_RECEIVED='"+map.get("amount").toString()+"' , created_at='"+map.get("createdAt").toString()+"',payment_id='"+map.get("paymentId").toString()+"' , status_id='"+1+"',customer_finalize='"+1+"' where order_id='"+map.get("orderId").toString()+"'");
ps.executeUpdate();


ps = conn
.prepareStatement("delete from  tbl_cart_record  where user_id='"+map.get("loginId").toString()+"' and product_id in (select product_id from product_final_orders where order_id='"+map.get("orderId").toString()+"' )");
System.out.println(ps);
ps.executeUpdate();


ps = conn
.prepareStatement(" update tbl_product_information t1 set t1.quantity=t1.quantity-(select t2.quantity from product_final_orders t2 where  order_id='"+map.get("orderId").toString()+"' ) where  t1.product_id in (select t2.product_id from product_final_orders t2 where  order_id='"+map.get("orderId").toString()+"' )");
ps.executeUpdate();
}

else if("3".equals(map.get("flag").toString()))
{
	tx = session.beginTransaction();
	LOG_ERROR image = new LOG_ERROR();
	image.setPaymentId(map.get("paymentId").toString());
	image.setOrderId(map.get("orderId").toString());
	image.setEmail(map.get("email").toString());
	image.setCreatedAt(new Timestamp(date.getTime()));
	session.save(image);
	
	tx.commit();
	
}



} catch (Exception e) {
e.printStackTrace();
if (tx != null) {
	tx.rollback();
}

} finally {
if (session != null) {
	session.close();
}

try {
	if (conn != null) {
		conn.close();
	}

	if (ps != null) {
		ps.close();
	}

} catch (SQLException e) {

}

}
return "";
}	

public String saveComplain(Map<String,Object> map)
{

	PreparedStatement ps = null;
	Session session = sessionFactory.openSession();
	Transaction tx = null;
	java.util.Date date = new java.util.Date();
	String str="";
	Integer a=0;
	try {	

			tx = session.beginTransaction();
			TblMessageLog obj = new TblMessageLog();
			java.util.Date now = new java.util.Date(); 
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp( now.getTime()); 
			obj.setName(map.get("name").toString());
			obj.setEmail(map.get("email").toString());
			obj.setCreatedAt(currentTimestamp);
			obj.setMobile(map.get("mobileNo").toString());
			obj.setMessage(map.get("message").toString());
			session.save(obj);
			 a =obj.getId();
			tx.commit();
		return str;
	} catch (Exception e) {
		e.printStackTrace();
		if (tx != null) {
			tx.rollback();
		}
		return a.toString();
	} finally {
		if (session != null) {
			session.close();
		}
	}
}



@Override
public List<Object[]> getShowProducts(Map<String, Object> map) {	
	List<Object[]> productInfo = new ArrayList<Object[]>();
	Session session = sessionFactory.openSession();
	try{
	SQLQuery qry = session
			.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price, "
+ " t2.product_images from tbl_product_information t1"
+" inner join tbl_product_display_images t2 on t2.p_id= t1.product_id and t2.category_id=t1.category_id and t1.sub_category_id=t2.sub_category_id" +
" where t1.show_id='"+map.get("showId").toString()+"' and t1.is_active=1 and t1.quantity>0");
	productInfo=qry.list();

	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();
		}
	}
	return productInfo;
}
@Override
public List<Object[]> productOfTheDay(Map<String, Object> map) {
	
	List<Object[]> productInfo = new ArrayList<Object[]>();
	
	Session session = sessionFactory.openSession();
	try{
		SQLQuery qry=null;
		if("1".equals(map.get("slideFlag").toString()))
		{
		
 qry = session
			.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price, "
+ " t2.product_images from tbl_product_information t1"
+" inner join tbl_product_display_images t2 on t2.p_id= t1.product_id and t2.category_id=t1.category_id and t1.sub_category_id=t2.sub_category_id" +
" where t1.product_id in (select t7.product_id from tbl_product_day t7 where t7.is_active=1)");
	productInfo=qry.list();

		}
		
		
		else{
			
			qry = session
					.createSQLQuery("select t1.id, t1.image "
		+ "  from tbl_slide_show t1"
				+" where t1.is_active=1 ");
			productInfo=qry.list();
			
		}
	} catch (HibernateException e) {

		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();

		}
	}

	return productInfo;
}


@Override
public List<Object[]> getProductReview(Map<String, Object> map) {
	
	List<Object[]> productInfo = new ArrayList<Object[]>();
	
	Session session = sessionFactory.openSession();
	try{
	SQLQuery qry = session
			.createSQLQuery("select t1.product_id, t1.review from product_reviews t1"
+" where t1.product_id='"+map.get("product_id").toString()+"'");
	productInfo=qry.list();

	} catch (HibernateException e) {

		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();

		}
	}

	return productInfo;
}

public String addReview(Map<String,Object> map)
{

	PreparedStatement ps = null;
	Session session = sessionFactory.openSession();
	Transaction tx = null;
	java.util.Date date = new java.util.Date();
	String str="";
	Integer a=0;
	try {	

			tx = session.beginTransaction();
			ProductReviews obj = new ProductReviews();
			java.util.Date now = new java.util.Date(); 
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp( now.getTime()); 
			obj.setLoginId(map.get("loginId").toString());
			obj.setProductId(new Integer(map.get("productId").toString()));
			obj.setCreatedAt(currentTimestamp);
			obj.setReview(map.get("review").toString());
			obj.setIsActive(map.get("isActive").toString());
			session.save(obj);
			tx.commit();
		return str;
	} catch (Exception e) {
		e.printStackTrace();
		if (tx != null) {
			tx.rollback();
		}
		return a.toString();
	} finally {
		if (session != null) {
			session.close();
		}
	}
}
@Override
public List<Object[]> getTrackDesc(Map<String, Object> map) {
	
	List<Object[]> productInfo = new ArrayList<Object[]>();
	
	Session session = sessionFactory.openSession();
	try{
	SQLQuery qry = session
			.createSQLQuery("select t1.product_id, t1.product_name,t1.discount, t2.category_id,t2.sub_category_id,t1.discounted_price , t1.actual_price,t3.quantity,t3.amount * t3.quantity "
+ " ,t2.product_images,t3.return_days, t3.amount , t3.status_id from product_final_orders t3"
+" inner join tbl_product_display_images t2 on t2.p_id= t3.product_id " 
+" inner join tbl_product_information t1 on t1.product_id= t3.product_id " 
+" where   t3.order_id='"+map.get("orderId").toString()+"'");
	productInfo=qry.list();

	} catch (HibernateException e) {

		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();

		}
	}

	return productInfo;
}	



}