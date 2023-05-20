package com.kunjproject.newspringbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.kunjproject.newspringbootproject.Dto.SubDto;
import com.kunjproject.newspringbootproject.dao.SubUserRepository;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.entities.User;

@Service
public class SubCategoryService implements SubCategoryServiceIMP {
	@Autowired
	SubUserRepository subRepo;

	@Override
	public String AddSubProduct(SubDto sdto) {
		// TODO Auto-generated method stub
		int count = subRepo.checkDuplicate(sdto.getSubCategoryName().toLowerCase(),
				String.valueOf(sdto.getSubCategoryId()));
		System.out.println(count);

		if (count > 0) {
			return "DATA ALREDY EXIST";

		} else {

			SubCategoryProduct subcat = new SubCategoryProduct();

			subcat.setActive(sdto.getActive());
			subcat.setSubCategoryId(sdto.getSubCategoryId());
			subcat.setCategoryName(sdto.getCategoryName());
			subcat.setSubCategoryName(sdto.getSubCategoryName());
			subcat.setDiscription(sdto.getDiscription());

			subRepo.save(subcat);
			return "DATA SAVED";

		}
	}

//@Override
//public List<SubCategoryProduct> loadAll() {
//	// TODO Auto-generated method stub
//	 
//	 return  subRepo.findAll();
//	
//}

	@Override
	public List<SubCategoryProduct> loadAll() {
		// TODO Auto-generated method stub

		List<SubCategoryProduct> list = subRepo.loadAll();
		{

			list.forEach(e -> {
			});
			return list;
		}

	}

	@Override
	public Optional<SubCategoryProduct> edit(int subCategoryId) {

		// TODO Auto-generated method stub
		return subRepo.findById(subCategoryId);
	}

	@Override
	@DeleteMapping
	public String delId(int subCategoryId) {

		// TODO Auto-generated method stub
		SubCategoryProduct subcat = new SubCategoryProduct();
		Optional<SubCategoryProduct> subid = subRepo.findById(subCategoryId);
		System.out.println("id " + subCategoryId);
		subcat = subid.get();
		subcat.setActive(9);

		subRepo.save(subcat);
		return "DELETED";

	}

	public List<Object[]> subDrop() {
		// TODO Auto-generated method stub
		return subRepo.subDrop();
	}

}
