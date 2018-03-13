package com.avd.dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.avd.common.util.JdbcConnection;
import com.avd.model.Lu_Category;
import com.avd.model.ProductDisplayImages;
import com.avd.model.ProductImages;
import com.avd.model.Slider;
import com.avd.model.TblProductInformation;

public class SellerServiceDaoImpl extends HibernateDaoSupport implements SellerServiceDao{
	
	
	

	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	Query query = null;
	Criteria cr = null;
	@Override
	public List<Lu_Category> getCategory(Map<String, String> map) {
		List<Lu_Category> catList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();


			catList = session.createCriteria(Lu_Category.class)
					.addOrder(Order.asc("categoryName")).list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return catList;

	}

	@Override
	public String saveImage(Map<String,Object> map)
			throws Exception {

		
		Clob a = stringToClob(map.get("mainImage").toString());
		Clob b = stringToClob(map.get("mediumImage").toString());
		Clob c = stringToClob(map.get("smallImage").toString());
		
		PreparedStatement ps = null;

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			ProductImages image = new ProductImages();
			image.setProductId(new Integer(map.get("pId").toString()));
			image.setCategoryId(new Integer(map.get("categoryId").toString()));
			image.setSubCategoryId(new Integer(map.get("subCategoryId").toString()));
			image.setProductImageLarge(a);
			image.setProductImageMedium(b);
			image.setImageId(new Integer(map.get("imageId").toString()));
			session.saveOrUpdate(image);
			
			if("1".equals(map.get("imageId").toString()))
			{
			
			
			ProductDisplayImages imag = new ProductDisplayImages();
			imag.setProductId(new Integer(map.get("pId").toString()));
			imag.setCategoryId(new Integer(map.get("categoryId").toString()));
			imag.setSubCategoryId(new Integer(map.get("subCategoryId").toString()));
			imag.setProductImages(c);
			
			session.saveOrUpdate(imag);
			
			}
			
			
			
			
			
			
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

	
	
	private Clob stringToClob(String source) {
		try {
			return new javax.sql.rowset.serial.SerialClob(source.toCharArray());
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	public Integer getProductId() {
		String code = "";
		ResultSet rs = null;
		Connection conn = null;
		String prdctId="0";
		Integer productId=0;
		PreparedStatement ps = null;
		try {

			conn = new JdbcConnection().getConnection();
			ps = conn
					.prepareStatement("select max(id)  as cnt from TBL_PRODUCT_SEQUENCE");
			rs = ps.executeQuery();

			while (rs.next()) {
				prdctId= rs.getString("cnt");
			}

			
			
			if ("null".equalsIgnoreCase(prdctId) | null==prdctId | "".equals(prdctId))
			productId=1;
				else
			productId= new Integer(prdctId)+1;
					

			
			
			ps = conn
					.prepareStatement("INSERT INTO  TBL_PRODUCT_SEQUENCE (ID) VALUES"
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

	@Override
	public String saveProduct(Map<String, Object> map) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {

			tx = session.beginTransaction();
			session.saveOrUpdate(map.get("info"));
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
	public List<TblProductInformation> getProductsData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		List<TblProductInformation> tblInfo = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();

			Criteria cr = session.createCriteria(TblProductInformation.class);
			cr.add(Restrictions.eq("productId", Integer.parseInt(map.get("productId").toString())));
			tblInfo = cr.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return tblInfo;

	}

		
	@SuppressWarnings("unchecked")
	@Override
	public List<TblProductInformation> getUnauthorizedProductDetails( int startPage, int pageSize, Map<String,Object> map) {
		
/*
		System.out.println(">>>>>>getUnauthorizedEnrollmentDetails");
		return getHibernateTemplate().findByExample(c, startPage * pageSize, pageSize);*/
		
		
		System.out.println(">>>>>>>getAllFamilyEnrollmentDetails");
		DetachedCriteria criteria = DetachedCriteria.forClass(TblProductInformation.class);
	
		
		return (List<TblProductInformation>) getHibernateTemplate().findByCriteria(criteria, startPage * pageSize, pageSize);

	}
	@SuppressWarnings("unchecked")
	@Override
	public int getcountProductRegistered(Map<String,Object> map) {

		System.out.println(">>>>>getcountFamilyEnrollment");
		DetachedCriteria criteria = DetachedCriteria.forClass(TblProductInformation.class)
			.setProjection(Projections.rowCount());
		return ((Long) getHibernateTemplate().findByCriteria(criteria).get(0)).intValue();
	}
	
	
	
	
	@Override
	public List<ProductImages> getProductImages(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		List<ProductImages> tblInfo = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();

			Criteria cr = session.createCriteria(ProductImages.class);
			cr.add(Restrictions.eq("productId", Integer.parseInt(map.get("productId").toString())));
			tblInfo = cr.addOrder(Order.asc("imageId")).list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return tblInfo;

	}


	@Override
	public String saveSliderImage(Map<String,Object> map)
			throws Exception {

		
				Clob b = stringToClob(map.get("image").toString());
	
		
		PreparedStatement ps = null;

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			Slider image = new Slider();
			image.setIsActive("1");
						image.setImage(b);
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

	
		
	}