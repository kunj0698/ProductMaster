package com.kunjproject.newspringbootproject.service;

import java.util.List;
import java.util.Optional;

import com.kunjproject.newspringbootproject.Dto.SubDto;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.entities.User;

public interface SubCategoryServiceIMP {
	
	String AddSubProduct(SubDto sdto);
	
	public List<SubCategoryProduct> loadAll();


	Optional<SubCategoryProduct> edit(int SubCategoryId);

	String delId(int subCategoryId);
	List<Object[]>subDrop();
}
