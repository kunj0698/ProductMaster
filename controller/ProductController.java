package com.kunjproject.newspringbootproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.kunjproject.newspringbootproject.Dto.ProductDto;
import com.kunjproject.newspringbootproject.dao.ProductRepository;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.excel.ProductExcel;
import com.kunjproject.newspringbootproject.excel.SubCategoryExcel;
//import com.kunjproject.newspringbootproject.fileUpload.FileUploadUtil;
import com.kunjproject.newspringbootproject.service.ProMasterService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class ProductController {
	@Autowired
	ProMasterService proMasterService;

	@RequestMapping("/product")
	public String ProductMaster() {
		return "product_master";
	}

	@ResponseBody
	@PostMapping(path="/AddProduct")  
	/*public String AddProduct(@ModelAttribute ProductDto proDto, @RequestParam("image") MultipartFile multipartFile)*/
	public String AddProduct( @RequestPart("proDto")ProductDto proDto, @RequestPart("imageUpload") MultipartFile multipartFile) throws IOException{

	    String id=  proMasterService.AddProduct(proDto, multipartFile);
		System.out.println(proDto.getCategoryName());
		System.out.println(proDto.getProductName());
	//	return new RedirectView("/product", true);
	return id;
		
	}

		@GetMapping("/load")
		public @ResponseBody List<Object[]> loadTable1() {
			List<Object[]> ss = proMasterService.loadTable1();
			System.out.println(ss);
			return ss;
		}
		
		@GetMapping("/categoryList")
		public @ResponseBody List<Object[]>catDrop(){
			List<Object[]> c=proMasterService.catDrop();
			return c;
		}
		
		@GetMapping("/subDrop")
		public @ResponseBody List<Object[]> drop(@RequestParam("categoryId") int categoryId){
			System.out.println(categoryId);
			List<Object[]> d= proMasterService.drop(categoryId);
			return d;
			
		}
		

		@GetMapping("/getId/{productId}")
		@ResponseBody
		public Optional<com.kunjproject.newspringbootproject.entities.ProductMaster> editId(@PathVariable("productId") int productId) {
			System.out.println(productId);
			return proMasterService.editId(productId);
		}
	
		@ResponseBody
		@DeleteMapping("/Prodelete/{productId}")

		public String ProdelId(@PathVariable("productId") int productId) {
			proMasterService.ProdelId(productId);
			return "deleted";
		}
		
		@GetMapping("/ProductExcel")
		public void SubCategoryExcelFile(HttpServletResponse response) throws IOException {
			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=Product" + currentDateTime + ".xlsx";
			response.setHeader(headerKey, headerValue);

			List<Object[]> product = proMasterService.loadTable1();
			// ExcelGenerator generator = new ExcelGenerator(user);
			ProductExcel expo = new ProductExcel(product);
			expo.generateExcelFile(response);

		}
}
