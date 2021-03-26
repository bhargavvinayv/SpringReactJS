package com.Ekart.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Ekart.model.Product;

//@RepositoryRestResource(collectionResourceRel = "vinay", path = "vinay")
public interface Repository extends MongoRepository<Product, String> {
	@DeleteQuery
	Product deleteByPid(String id);

	void save(Optional<Product> product);

}
