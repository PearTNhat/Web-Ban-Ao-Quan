package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductDetailDao;
import ptithcm.dao.TypeDetailDao;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.Size;
import ptithcm.entity.TypeDetail;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductDetailDao productDetailDao;
	
	@Autowired
	TypeDetailDao typeDetailDao;

	@RequestMapping("/products/{typeId}")
	public String getProduct(@PathVariable("typeId") String typeId, ModelMap model) {
//		pst : products type
		List<Product> listProduct = productDao.getProductByType(typeId);
		model.addAttribute("typeId", typeId);
		model.addAttribute("pst", listProduct);

		return "page/listProduct";	
	}
	
	@RequestMapping("/products/{typeDetailId}/{productDetailId}")
	public String getProductDetail(@PathVariable("typeDetailId") String typeDetailId, 
	                               @PathVariable("productDetailId") Integer productDetailId, 
	                               ModelMap model) {
//	    ProductDetail productDetail = productDetailDao.getProductDetail(productDetailId);
	    TypeDetail typeDetail = typeDetailDao.getTypeDetail(typeDetailId);
	    List<Size> listSize = new ArrayList<>();
		/*
		 * for (ProductDetail p : productDetail.getProduct().getProductDetail()) { if
		 * (p.getProductDetailId().equals(productDetailId)) listSize.add(p.getSize()); }
		 */
	    
//	    model.addAttribute("productDetail", productDetail);
	    model.addAttribute("typeDetail", typeDetail);
	    model.addAttribute("listSize", listSize);
	    return "page/product/product-detail";
	}
}
