package com.kunjproject.newspringbootproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kunjproject.newspringbootproject.Dto.SubDto;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.excel.SubCategoryExcel;
import com.kunjproject.newspringbootproject.service.SubCategoryService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService subcatservice;
	
	@RequestMapping("/subcategorymaster")
	public String SubCategoryMaster() {
		return "sub_category_master";
	}

	@ResponseBody
	@PostMapping("/insertSubProduct")
	public String AddSubProduct(@ModelAttribute SubDto sdto) {
		String id = subcatservice.AddSubProduct(sdto);
		return id;
	}

	@GetMapping("/loadAll")
	public @ResponseBody List<SubCategoryProduct> loadAll() {
		List<SubCategoryProduct> ss = subcatservice.loadAll();
		System.out.println(ss);
		return ss;
	}
	
	@GetMapping("/subList")
	public @ResponseBody List<Object[]>subDrop(){
		List<Object[]> s=subcatservice.subDrop();
		return s;
	}

	@GetMapping("/editById/{subCategoryId}")
	@ResponseBody
	public Optional<SubCategoryProduct> edit(@PathVariable("subCategoryId") int subCategoryId) {
		System.out.println(subCategoryId);
		return subcatservice.edit(subCategoryId);
	}

	@ResponseBody
	@DeleteMapping("/delete/{subCategoryId}")

	public String delId(@PathVariable("subCategoryId") int subCategoryId) {
		subcatservice.delId(subCategoryId);
		return "deleted";
	}

	@GetMapping("/SubCategoryExcel")
	public void SubCategoryExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=SubCategoryProduct" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<SubCategoryProduct> subCat = subcatservice.loadAll();
		// ExcelGenerator generator = new ExcelGenerator(user);
		SubCategoryExcel expo = new SubCategoryExcel(subCat);
		expo.generateExcelFile(response);

	}

}
