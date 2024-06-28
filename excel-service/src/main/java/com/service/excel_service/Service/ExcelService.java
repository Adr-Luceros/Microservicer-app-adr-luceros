package com.service.excel_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.excel_service.Entity.Personal;
import com.service.excel_service.FeignClient.PersonalFeign;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExcelService {

	@Autowired
	PersonalFeign personalFeign;
	
	public List<Personal> getAllPersonal(){
		return personalFeign.getAllPersonal();
	}
}
