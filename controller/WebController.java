package com.kunjproject.newspringbootproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import com.kunjproject.newspringbootproject.Dto.Dto;
import com.kunjproject.newspringbootproject.entities.User;
import com.kunjproject.newspringbootproject.excel.ExportExcel;
import com.kunjproject.newspringbootproject.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WebController {
	@Autowired
	ProductService productService;

	@CrossOrigin
	@RequestMapping("/categorymaster")
	public String CategoryMaster() {
		return "category_master";
	}

	@ResponseBody
	@PostMapping("/insertProduct")
	public String addProduct(@ModelAttribute Dto dt) {
		String id = productService.addProduct(dt);
		return id;
	}

	@GetMapping("/listAll")
	public @ResponseBody List<User> ListAll() {
		List<User> ss = productService.ListAll();
		System.out.println(ss);
		return ss;
	}

//EDIT
	@GetMapping("/getById/{categoryId}")
	@ResponseBody
	public Optional<User> ById(@PathVariable("categoryId") int categoryId) {
		System.out.println(categoryId);
		return productService.ById(categoryId);
	}

//DELETE
	@ResponseBody
	@PostMapping("/delById/{categoryId}")
	public String delById(@PathVariable("categoryId") int categoryId) {
		productService.delById(categoryId);
		return "deleted";
	}

	@GetMapping("/export-to-excel")
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=CategoryProduct" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<User> user = productService.ListAll();
		// ExcelGenerator generator = new ExcelGenerator(user);
		ExportExcel expo = new ExportExcel(user);
		expo.generateExcelFile(response);
	}

}
