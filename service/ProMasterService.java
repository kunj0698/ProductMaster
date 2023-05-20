package com.kunjproject.newspringbootproject.service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.kunjproject.newspringbootproject.Dto.ProductDto;
import com.kunjproject.newspringbootproject.dao.ProductRepository;
import com.kunjproject.newspringbootproject.entities.ProductMaster;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.fileUpload.FileUploadUtil;

@Service

public class ProMasterService implements ProMasterServiceIMP {
	@Autowired
	ProductRepository proRepo;

	@Override
	public String AddProduct(ProductDto proDto, MultipartFile multipartFile) throws IOException {

		
			ProductMaster product = new ProductMaster();

			

			int count = proRepo.checkDuplicate(proDto.getProductName().toLowerCase(),
					String.valueOf(proDto.getProductId()));

			System.out.println(count);

			if (count > 0) {
				return "DATA EXIST";

			} else {
				product.setProductId(proDto.getProductId());

				// product.setProductId(Integer.parseInt(proDto.getProductId()));
				product.setActive(Integer.parseInt(proDto.getActive()));
				product.setCategoryName(Integer.parseInt(proDto.getCategoryName()));
				product.setProductName(proDto.getProductName());
				product.setSubCategoryName(Integer.parseInt(proDto.getSubCategoryName()));
				product.setDiscription(proDto.getDiscription());
				product.setWarrantyAndSupport(proDto.getWarrantyAndSupport());

				// product.setImageUpload(proDto.getImageUpload());

				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				System.out.println("FILE NAME" + fileName);
				product.setImageUpload(fileName);
				ProductMaster savepro = proRepo.save(product);
				String uploadDir = "src/main/resources/static/pictures/"; //
				System.out.println("path" + uploadDir);

				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
				System.out.println("FILE" + multipartFile);

				product.setManufactureDate(proDto.getManufactureDate());
				product.setPrice(Integer.parseInt(proDto.getPrice()));
				product.setProductSerialNo(Integer.parseInt(proDto.getProductSerialNo()));
				product.setProductColour(proDto.getProductColour());
				product.setProductCondition(proDto.getProductCondition());
				product.setDiscount(proDto.getDiscount());

				
			   
				product.setDateFrom(proDto.getDateFrom());

				product.setDateTo(proDto.getDateTo());
				
				
			//	product.setDateFrom(Date.valueOf(sdf1.format(sdf.parse(proDto.getDateFrom()))));
				//product.setDateTo(Date.valueOf(sdf1.format(sdf.parse(proDto.getDateTo()))));

				proRepo.save(product);
				return "DATA SAVED";
			}

		} 
	

	/*
	 * public List<ProductMaster> loadTable1() { // TODO Auto-generated method stub
	 * return proRepo.findAll(); }
	 */

	@Override
	public List<Object[]> loadTable1() { // TODO Auto-generated

		List<Object[]> l = proRepo.loadTable1();
		{

			l.forEach(e -> {
			});

			return l;
		}

	}

	public Optional<ProductMaster> editId(int productId) {
		// TODO Auto-generated method stub
		return proRepo.findById(productId);
	}

	public String ProdelId(int productId) {
		// TODO Auto-generated method stub
		ProductMaster proMast = new ProductMaster();
		Optional<ProductMaster> proid = proRepo.findById(productId);
		System.out.println("id " + productId);
		proMast = proid.get();
		proMast.setActive(9);

		proRepo.save(proMast);
		return "DELETED";
	}

	public List<Object[]> drop(int categoryId) {
		// TODO Auto-generated method stub
		return proRepo.drop(categoryId);
	}

	public List<Object[]> catDrop() {
		// TODO Auto-generated method stub
		return proRepo.catDrop();
	}

}
