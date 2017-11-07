package com.amazon.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazon.dao.ProductDAO;
import com.amazon.exception.InvalidInfoException;
import com.amazon.model.Product;

@Controller
public class AdminController {

	private ProductDAO productDAO;

	@Autowired
	public AdminController(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	public String homeTemplate() {
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductInDatabase(HttpServletRequest req, HttpServletResponse res) {

		Product product = new Product();
		try {

			product.setProductName(req.getParameter("productName"));
			product.setDescription(req.getParameter("description"));
			product.setPrice(Double.parseDouble(req.getParameter("price")));
			product.setPublishDate(LocalDate.now());
			product.setQuantaty(Integer.parseInt(req.getParameter("quantity")));
			product.setPoster(req.getParameter("poster").toString());
			product.setCategoriesID(Integer.parseInt(req.getParameter("categoryId")));
			System.out.println(product);
			
			this.productDAO.addProduct(product);
			
		} catch (InvalidInfoException e) {
			req.setAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
			return "/addProduct";
		} catch (SQLException e) {
			System.out.println("ERRRORRR");
			e.printStackTrace();
			req.setAttribute("errorMessage", "There is a problem with the database");
			return "/error";
		}

		System.out.println("Product id is: " + product.getProductName());
		return "redirect: /index";

	}


}
