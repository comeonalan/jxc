package com.gyl.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public List<Vender> getVendersByName(String name){
		return venderDao.findByNameIgnoreCaseContaining(name);
	}
	
	public Vender modifyVenderInfo(Vender vender) {
		Vender returnVender = venderDao.getOne(vender.getId());
		returnVender.setName(vender.getName());
		returnVender.setAddress(vender.getAddress());
		returnVender.setTelephone(vender.getTelephone());
		return venderDao.save(returnVender);

	}
	
	public void deleteVenderById(int id) {
		venderDao.deleteById(id);
	}
	
	public void deleteVendersByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Integer> idSet = new HashSet<Integer>();
		for(String x : reIds) {
			idSet.add(Integer.parseInt(x));
		}
		venderDao.deleteVendersByIds(idSet);
	}
}
