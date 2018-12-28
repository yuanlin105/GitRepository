package com.twf.e.book.product.api.facade;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.twf.e.book.product.api.domain.Product;

@RequestMapping("/product")
public interface ProductFacade {

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct();
	
	@RequestMapping(value="get",method=RequestMethod.GET)
	public Product getProduct(@RequestParam("id")Integer id);
	
	@RequestMapping(value="get2",method=RequestMethod.GET)
	public Product getProduct2(Product obj);
	
	@RequestMapping(value="get3",method=RequestMethod.GET)
	public Product getProduct3(@RequestParam("id")Integer id,@RequestParam("name")String name);
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product obj);
}
