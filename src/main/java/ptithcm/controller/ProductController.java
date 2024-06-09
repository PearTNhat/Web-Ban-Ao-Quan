package ptithcm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductDetailDao;
import ptithcm.dao.TypeDetailDao;
import ptithcm.entity.Account;
import ptithcm.entity.Product;
import ptithcm.entity.ProductColor;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;
import ptithcm.entity.Size;
import ptithcm.entity.TypeDetail;

@Transactional
@Controller
public class ProductController {
	@Autowired
	SessionFactory factory;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductDetailDao productDetailDao;
	
	@Autowired
	TypeDetailDao typeDetailDao;

	@RequestMapping("/products/{typeId}")
	public String getProduct(@PathVariable("typeId") String typeId, ModelMap model,HttpServletRequest request) {
//		pst : products type
		List<Product> hotProduct = productDao.getBestSaleProduct();
		int limit = 4;
		Integer page =request.getParameter("page")== null ? 1 :Integer.parseInt(request.getParameter("page"));
		Session session = factory.getCurrentSession();
		//total pages
		String hqlTotal = "SELECT count(*) FROM Product WHERE typeDetailId=:typeId ";
		Query queryTotal = session.createQuery(hqlTotal); 
		queryTotal.setParameter("typeId", typeId);
		Long total = (Long) queryTotal.uniqueResult();
		int pages =(int) Math.ceil((float)total/limit);
		int skip = (page - 1 ) * limit;
		// lấy ra kết quả cuối cùng sau khi tính toán phân trang
		String hql = "FROM Product WHERE typeDetailId=:typeId";
		Query query = session.createQuery(hql);
		query.setFirstResult(skip); 
		query.setMaxResults(limit); // Fetch the next 5 rows after skipping
		query.setParameter("typeId", typeId);
		//
		List<Product> listProduct = query.list();
		model.addAttribute("pst", listProduct);
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		model.addAttribute("limit",limit);
		model.addAttribute("typeId", typeId);;
		model.addAttribute("hotProduct",hotProduct);
		return "page/listProduct";	
	}
	
	@RequestMapping("/products/{typeDetailId}/{productColorId}")
	public String getProductDetail(@PathVariable("typeDetailId") String typeDetailId, 
	                               @PathVariable("productColorId") Integer productColorId, 
	                               ModelMap model) {
		ProductColor productColor = productDetailDao.findProductColorById(productColorId);
	    TypeDetail typeDetail = typeDetailDao.getTypeDetail(typeDetailId);
	    
	    Set<Size> listSize = new HashSet<>();
		for (ProductDetail productDetail : productColor.getProductDetail()) {
			listSize.add(productDetail.getSize());
		}
		
	    model.addAttribute("productColor", productColor);
	    model.addAttribute("typeDetail", typeDetail);
	    model.addAttribute("listSize", listSize);
	    return "page/product/product-detail";
	}
}
