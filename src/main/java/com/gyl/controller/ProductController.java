package com.gyl.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyl.entity.Product;
import com.gyl.entity.Vender;
import com.gyl.formbean.ProductDTO;
import com.gyl.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
//	@ResponseBody
//	@RequestMapping(value="/{id}")
//	public Product getProduct(@PathVariable Long id) {
//		return productService.getProductById(id);
//	}
//	
	@ResponseBody
	@GetMapping(value="/getProductsByType")
	public Map<String, List<ProductDTO>> getProductsByType(@RequestParam(value="type",required=false) String type) {
		Map<String, List<ProductDTO>> map = new HashMap<String, List<ProductDTO>>();
		List<ProductDTO> products = productService.getProductsByType(type);
		map.put("products", products);
		return map;
	}
	
	//@PostMapping = @RequestMapping(method = RequestMethod.POST)
	//@RequestMapping(value="/addNewProduct", method=RequestMethod.POST)
	@ResponseBody
	@PostMapping(value="/addNewProduct")
	public String addNewVender(@RequestBody @Validated Product product,BindingResult result) {
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error:list) {
				System.out.print(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			    return error.getDefaultMessage();
			}
		}
		
	  try {
		  productService.addProduct(product);
	  }catch(Exception e) {
		  return "添加货物失败!"; 
	  }
	  return "添加货物成功!"; 
	}
}
