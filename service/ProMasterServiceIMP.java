package com.kunjproject.newspringbootproject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.kunjproject.newspringbootproject.Dto.ProductDto;
import com.kunjproject.newspringbootproject.entities.ProductMaster;

public interface ProMasterServiceIMP {
	String AddProduct(ProductDto proDto, MultipartFile multipartFile) throws IOException;
	 List<Object[]> loadTable1();
	 Optional<ProductMaster> editId(int productId);
	 String ProdelId(int subCategoryId);
	 List<Object[]>drop(int categoryId);
	 List<Object[]>catDrop();
	 
}
