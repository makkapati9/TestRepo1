package com.avd.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avd.model.Lu_Category;
import com.avd.model.TblProductInformation;
import com.avd.service.SellerService;
import com.avd.service.vo.PagedCustView;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Controller
public class SellerController {

	@Autowired
	SellerService sellServc;
	
	//work by Chandu

	@RequestMapping("/sellerLogin")
	public ModelAndView sellerLogin(HttpServletRequest httpReq, HttpServletResponse httpResp) {
		return new ModelAndView("sellerLogin");
	}

	@RequestMapping("/validateSeller")
	public ModelAndView validateSeller(HttpServletRequest httpReq, HttpServletResponse httpResp) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = httpReq.getSession(false);
		if (httpReq.getParameter("emailId") == null || httpReq.getParameter("pass").trim() == null) {
			map.put("msg", "Please provide emailId and Password");
			map.put("errorMsg", "1");
			return new ModelAndView("sellerLogin", "map", map);
		} else if ("manish.gupta@gmail.com".equals(httpReq.getParameter("emailId").trim())
				&& "manish123".equals(httpReq.getParameter("pass").trim())) {
			try {
				System.out.println("goin to get Product id");
				Integer productId = sellServc.getProductId();
				System.out.println("Yeah... Here is my product id " + productId);
				httpReq.getSession().setAttribute("productId", productId);
				
				// Adding values to session
				session.setAttribute("loginId", "admin");
				session.setAttribute("loginName", "admin");
				session.setAttribute("emailId", "manish.gupta@gmail.com");
				session.setAttribute("loginFlag", "1");
				map.put("loginName", "admin");
				//map.put(key, value)
				return new ModelAndView("redirect:sellerEnd", "map", map);
			} catch (Exception ex) {
				ex.printStackTrace();
				map.put("msg", "There is some problem. Please try again later!");
				map.put("emailId", httpReq.getParameter("emailId"));
				map.put("errorMsg", "1");
				return new ModelAndView("sellerLogin", "map", map);

			}

			

		} else {
			map.put("msg", "Email Id or Password does not match!");
			map.put("errorMsg", "1");
			map.put("emailId", httpReq.getParameter("emailId"));
			return new ModelAndView("sellerLogin", "map", map);
		}

	}

	@RequestMapping("/sellerEnd")
	public ModelAndView sellerEnd(HttpServletRequest httpReq, HttpServletResponse httpResp) {
		Map<String, String> mapper = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Lu_Category> catList = sellServc.getCategory(mapper);
		System.out.println("going on seller Page");
		map.put("catList", catList);
		try {
			String productId = httpReq.getSession().getAttribute("productId").toString();
			map.put("productId", productId);

		} catch (Exception ex) {
		}

		return new ModelAndView("sellerEnd", "map", map);

	}

	@RequestMapping("/existingProduct")
	public ModelAndView existingProduct(HttpServletRequest request, HttpServletResponse httpResp) {

		Map<String, Object> map = new HashMap<String, Object>();

		/*
		 * List<TblProductInformation> productData=
		 * sellServc.getProductsData(map); map.put("productData", productData);
		 */

		Map<String, PagedCustView> model = new HashMap<String, PagedCustView>();
		PagedCustView pcustv = new PagedCustView();

		String page = (String) request.getParameter("page");
		pcustv.getNavInfo().setRowCount(sellServc.getcountProductRegistered(map));

		if (null == page)
			pcustv.getNavInfo().setCurrentPage(0);
		else
			pcustv.getNavInfo().setCurrentPage(Integer.parseInt(page));

		pcustv.setproductInfo(sellServc.getUnauthorizedProductDetails(pcustv.getNavInfo().getCurrentPage(),
				pcustv.getNavInfo().getPageSize(), map));

		request.getSession().setAttribute("pagedcust", pcustv);
		model.put("pagedcust", pcustv);

		request.setAttribute("page", page);

		return new ModelAndView("existingProduct", "map", map);

	}

	@RequestMapping("/orders")
	public ModelAndView orders(HttpServletRequest httpReq, HttpServletResponse httpResp) {

		Map<String, String> mapper = new HashMap<String, String>();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Lu_Category> catList = sellServc.getCategory(mapper);
		map.put("catList", catList);

		return new ModelAndView("orders", "map", map);

	}

	@RequestMapping("/rating")
	public ModelAndView rating(HttpServletRequest httpReq, HttpServletResponse httpResp) {

		Map<String, String> mapper = new HashMap<String, String>();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Lu_Category> catList = sellServc.getCategory(mapper);
		map.put("catList", catList);

		return new ModelAndView("rating", "map", map);

	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public void saveEnrollmentImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();

		String pId = request.getParameter("pId");
		String categoryId = request.getParameter("categoryId");
		String subCategoryId = request.getParameter("subCategoryId");
		String imageId = request.getParameter("imageId");
		System.out.println("pid is " + pId);
		PrintWriter out = response.getWriter();
		byte[] encoded = null;
		byte[] subMain;
		byte[] displayMain;
		String encodedString = null;
		String subMainString = null;
		String displayMainString = null;

		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			System.out.println("formItems.size()" + formItems.size());
			if (formItems != null && formItems.size() > 0) {
				Iterator<FileItem> iter = formItems.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					String fieldName = item.getFieldName();
					if ("pId".equalsIgnoreCase(fieldName)) {
						pId = item.getString();
						System.out.println("pId is " + pId);
					}

					if ("upfile".equalsIgnoreCase(fieldName)) {
						encoded = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(item.get());
						System.out.println("encoded" + encoded);
					}

					if ("categoryId".equalsIgnoreCase(fieldName)) {
						categoryId = item.getString();
						System.out.println("categoryId is " + categoryId);
					}
					if ("subCategoryId".equalsIgnoreCase(fieldName)) {
						subCategoryId = item.getString();
						System.out.println("subCategoryId is " + subCategoryId);
					}

					if ("imageId".equalsIgnoreCase(fieldName)) {
						imageId = item.getString();
						System.out.println("imageId is " + imageId);
					}

				}

				byte[] k = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(encoded);
				Properties props = new Properties();
				props.load(request.getServletContext().getResourceAsStream("/WEB-INF/path.properties"));
				String filePath = props.getProperty("filePath");
				String fileName = filePath + pId + "_compressed.jpg";
				// String fileNam=filePath+pId+".jpg";
				File compressedImageFile = new File(fileName);
				// File imageFile = new File(fileNam);

				BufferedImage image = ImageIO.read(new ByteArrayInputStream(k));

				// ImageIO.write(image, "jpeg", imageFile);
				// till here

				// InputStream is = new FileInputStream(imageFile);
				OutputStream os = new FileOutputStream(compressedImageFile);
				float quality = 0.5f;

				// create a BufferedImage as the result of decoding the supplied
				// InputStream
				// BufferedImage image = ImageIO.read(is);

				// get all image writers for JPG format
				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

				if (!writers.hasNext())
					throw new IllegalStateException("No writers found");

				ImageWriter writer = (ImageWriter) writers.next();
				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				writer.setOutput(ios);

				ImageWriteParam param = writer.getDefaultWriteParam();

				// compress to a given quality
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(quality);

				// appends a complete image stream containing a single image and
				// associated stream and image metadata and thumbnails to the
				// output
				writer.write(null, new IIOImage(image, null, null), param);

				os.close();
				ios.close();
				writer.dispose();

				ByteArrayOutputStream ba = new ByteArrayOutputStream();
				BufferedImage imag = ImageIO.read(new File(fileName));
				ImageIO.write(imag, "jpeg", ba);
				ba.flush();
				ba.close();
				encoded = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(ba.toByteArray());

				/*
				 * Image originalImage= ImageIO.read(new File(fileName)); int
				 * scaledWidth=360; int scaledHeight =480; boolean
				 * preserveAlpha=true;
				 * 
				 * System.out.println("resizing..."); int imageType =
				 * preserveAlpha ? BufferedImage.TYPE_INT_RGB :
				 * BufferedImage.TYPE_INT_ARGB; BufferedImage scaledBI = new
				 * BufferedImage(scaledWidth, scaledHeight, imageType);
				 * 
				 * Graphics2D g = scaledBI.createGraphics(); if (preserveAlpha)
				 * { g.setComposite(AlphaComposite.Src); }
				 * g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight,
				 * null); g.dispose();
				 * 
				 * ByteArrayOutputStream baos= new ByteArrayOutputStream();
				 * ImageIO.write(scaledBI, "jpg", baos);
				 * 
				 * 
				 */
				int scaledWidth = 360;
				int scaledHeight = 480;
				subMain = resizeImage(scaledWidth, scaledHeight, fileName);

				/*
				 * scaledWidth=360; scaledHeight =480;
				 * 
				 * 
				 * displayMain=resizeImage(scaledWidth, scaledHeight, fileName);
				 */
				encodedString = new String(encoded);
				subMainString = new String(subMain);
				displayMainString = new String(subMain);

				File file = new File(fileName);

				if (file.exists()) {
					file.delete();
				}

				// System.out.println("encoded string is " + encodedString);
				// }

				map.put("categoryId", categoryId);
				map.put("subCategoryId", subCategoryId);
				map.put("mainImage", encodedString);
				map.put("mediumImage", subMainString);
				map.put("smallImage", displayMainString);
				map.put("pId", pId);
				map.put("imageId", imageId);

				String result = sellServc.saveImage(map);
				if ("1".equals(result)) {
					out.print(encodedString);
				} else {
					out.print(result);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			out.print("2");
		}

		// encodedString =
		// "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";

		System.out.println("===========SAVED SUCCESSFULLY===========");

		request.setAttribute("isImageSaved", "y");
		// return ViewMukhiyaDataForEdit(request, response);
	}

	public byte[] resizeImage(int scaledWidth, int scaledHeight, String fileName) {
		byte[] stream = null;
		ByteArrayOutputStream baos = null;
		try {

			Image originalImage = ImageIO.read(new File(fileName));
			boolean preserveAlpha = true;

			System.out.println("resizing...");
			int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
			Graphics2D g = scaledBI.createGraphics();
			if (preserveAlpha) {
				g.setComposite(AlphaComposite.Src);
			}
			g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
			g.dispose();

			baos = new ByteArrayOutputStream();
			ImageIO.write(scaledBI, "jpg", baos);

			stream = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(baos.toByteArray());

		} catch (Exception ex) {

		} finally {
			try {
				baos.flush();
				baos.close();
			} catch (Exception ex) {

			}
		}

		return stream;

	}

	@RequestMapping(value = "/setSlider", method = RequestMethod.POST)
	public void setSlider(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();

		PrintWriter out = response.getWriter();
		byte[] encoded = null;
		byte[] subMain;
		byte[] displayMain;
		String encodedString = null;
		String subMainString = null;
		String displayMainString = null;

		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			System.out.println("formItems.size()" + formItems.size());
			if (formItems != null && formItems.size() > 0) {
				Iterator<FileItem> iter = formItems.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					String fieldName = item.getFieldName();

					if ("upfile".equalsIgnoreCase(fieldName)) {
						encoded = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(item.get());
						System.out.println("encoded" + encoded);
					}

				}

				byte[] k = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(encoded);
				Properties props = new Properties();
				props.load(request.getServletContext().getResourceAsStream("/WEB-INF/path.properties"));
				String filePath = props.getProperty("filePath");
				String fileName = filePath + "123_compressed.jpg";
				// String fileNam=filePath+pId+".jpg";
				File compressedImageFile = new File(fileName);
				// File imageFile = new File(fileNam);

				BufferedImage image = ImageIO.read(new ByteArrayInputStream(k));

				// ImageIO.write(image, "jpeg", imageFile);
				// till here

				// InputStream is = new FileInputStream(imageFile);
				OutputStream os = new FileOutputStream(compressedImageFile);
				float quality = 0.5f;

				// create a BufferedImage as the result of decoding the supplied
				// InputStream
				// BufferedImage image = ImageIO.read(is);

				// get all image writers for JPG format
				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

				if (!writers.hasNext())
					throw new IllegalStateException("No writers found");

				ImageWriter writer = (ImageWriter) writers.next();
				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				writer.setOutput(ios);

				ImageWriteParam param = writer.getDefaultWriteParam();

				// compress to a given quality
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(quality);

				// appends a complete image stream containing a single image and
				// associated stream and image metadata and thumbnails to the
				// output
				writer.write(null, new IIOImage(image, null, null), param);

				os.close();
				ios.close();
				writer.dispose();

				ByteArrayOutputStream ba = new ByteArrayOutputStream();
				BufferedImage imag = ImageIO.read(new File(fileName));
				ImageIO.write(imag, "jpeg", ba);
				ba.flush();
				ba.close();
				encoded = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(ba.toByteArray());

				int scaledWidth = 800;
				int scaledHeight = 450;
				subMain = resizeImage(scaledWidth, scaledHeight, fileName);
				subMainString = new String(subMain);

				File file = new File(fileName);

				if (file.exists()) {
					file.delete();
				}

				map.put("image", subMainString);

				String result = sellServc.saveSliderImage(map);
				if ("1".equals(result)) {
					out.print(encodedString);
				} else {
					out.print(result);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			out.print("2");
		}

		// encodedString =
		// "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";

		System.out.println("===========SAVED SUCCESSFULLY===========");

		request.setAttribute("isImageSaved", "y");
		// return ViewMukhiyaDataForEdit(request, response);
	}

	@RequestMapping("/sliderPage")
	public ModelAndView sliderPage(HttpServletRequest httpReq, HttpServletResponse httpResp) {

		return new ModelAndView("sliderPage");

	}

}
