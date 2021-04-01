package com.Ekart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Ekart.dao.Repository;
import com.Ekart.model.Product;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

	@Autowired
	Repository repo;

	@GetMapping("index")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@GetMapping("products")

	public List<Product> products(Product product) {

		return repo.findAll();
	}

	@GetMapping("products/id")

	public Optional<Product> productsid(@PathVariable("id") String id) {

		return repo.findById(id);
	}

	@PutMapping(path = "setProducts")
	public void setProduct(@RequestBody Product product) {

		Product p1 = repo.findByTitle(product.getTitle());
		if (p1 == null) {
			repo.save(product);
		}

		System.out.println(product + "" + p1);

	}

	@PutMapping("updateProduct")
	public List<Product> updateProduct(@RequestBody Product product) {
		repo.save(product);

		return repo.findAll();
	}

	@RequestMapping("deleteProduct/{pid}")
	public List<Product> deleteProduct(@PathVariable("pid") String id) {
		System.out.println(id);
		repo.deleteByPid(id);

		return repo.findAll();

	}

}
