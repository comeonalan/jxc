package com.gyl.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gyl.entity.Vender;
import com.gyl.service.VenderService;

@RequestMapping("/vender")
@Controller
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
		  return "添加厂家失败!"; 
	  }
	  return "添加厂家成功!"; 
	}
	

}
