package com.gyl.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gyl.entity.Vender;
import com.gyl.service.VenderService;

@RequestMapping("/vender")
@RestController
public class VenderController {
	
	@Autowired
	private VenderService venderService;
	
	@ResponseBody
	@RequestMapping(value="/addNewVender", method=RequestMethod.POST)
	public String addNewVender(@RequestBody @Validated Vender vender,BindingResult result) {
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error:list) {
				System.out.print(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			    return error.getDefaultMessage();
			}
		}
		
	  try {
		  venderService.addVender(vender);
	  }catch(Exception e) {
		  System.out.println(e);
		  return "添加厂家失败!"; 
	  }
	  return "添加厂家成功!"; 
	}
	
	@GetMapping("/queryVendersByName")
	public Map<String, List<Vender>> queryVendersByName(@RequestParam(value="name") String name) {
		List<Vender> venders = venderService.getVendersByName(name);
		Map<String, List<Vender>> map = new HashMap<String, List<Vender>>();
		map.put("venders", venders);
		return map;
	}
	
	@PatchMapping("/modifyVender")
	public String modifyVender(@RequestBody Vender vender) {
	    try {
	    	venderService.modifyVenderInfo(vender);
	    }catch(Exception e) {
	    	System.out.println(e);
	    	return "更新厂家信息失败！";
	    }
	    return "更新厂家信息成功！";
	
	}
	
	@DeleteMapping("/deleteVenderById")
	public String deleteVenderById(int id) {
		 try {
			 venderService.deleteVenderById(id);
		    }catch(Exception e) {
		    	System.out.println(e);
		    	return "删除厂家失败！";
		    }
		    return "删除厂家成功！";
	}
	
//	@DeleteMapping("/deleteVendersByIds")
//	//@RequestParam默认必须传入参数，如果不加@RequestParam，则可以允许不传参数，那么程序会自动给ids赋值null
//	public String deleteVendersByIds(@RequestParam(value = "ids[]") int ids[]) {
//		try {
//			venderService.deleteVendersByIds(ids);
//		} catch (Exception e) {
//			System.out.println(e);
//			return "批量删除厂家失败！";
//		}
//		return "批量删除厂家成功！";
//	}
	
	@DeleteMapping("/deleteVendersByIds")
	public String deleteVendersByIds(String ids) {
		try {
		 	venderService.deleteVendersByIds(ids);
		} catch (Exception e) {
			System.out.println(e);
			return "批量删除厂家失败！";
		}
		return "批量删除厂家成功！";
	}

}
