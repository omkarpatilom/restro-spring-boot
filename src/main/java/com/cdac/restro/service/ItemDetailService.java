package com.cdac.restro.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.restro.beans.ItemDetails;
import com.cdac.restro.repo.ItemDetailsRepository;

@Service
public class ItemDetailService {
	@Autowired
	private ItemDetailsRepository repo;

	 public ItemDetails store(MultipartFile file) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    ItemDetails FileDB = new ItemDetails();
		    

		    return repo.save(FileDB);
		  }

}
