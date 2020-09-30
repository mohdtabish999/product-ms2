package com.product.ms2.dao;

import java.util.List;

import com.product.ms2.dto.ProductDto;

public interface ProductDao {
	
	List<ProductDto> getProducts();
	ProductDto save(ProductDto productDto);
	ProductDto getProduct(String productId);
	void deleteProduct(String productId);

}
