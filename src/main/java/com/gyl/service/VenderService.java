package com.gyl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.VenderDao;
import com.gyl.entity.Vender;

@Service
public class VenderService {

	@Autowired 
	private VenderDao venderDao;
	
	public Vender addVender(Vender vender) {
		return venderDao.save(vender);
	}
}
