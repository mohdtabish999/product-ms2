package com.product.ms2.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.ms2.dto.ProductDto;
import com.product.ms2.model.Product;
import com.product.ms2.repository.ProductRepository;
import com.product.ms2.util.ProductUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository ProductRepository;

	@Override
	public List<ProductDto> getProducts() {
		
		return ProductRepository.findAll()
				.stream()
				.map(ProductUtil::transformProductToProductDto)
				.collect(Collectors.toList());
		/*
		 * return ProductRepository.findAll() .stream() .map(p -> new
		 * ProductDto(p.getId(),p.getName(), p.getPrice(),p.getImageUrl()))
		 * .collect(Collectors.toList());
		 */
	}

	@Override
	public ProductDto save(ProductDto productDto) {
		Product product = ProductRepository.saveAndFlush(ProductUtil.transformProductDtoToProduct(productDto));
		return ProductUtil.transformProductToProductDto(product);
	}

	@Override
	public ProductDto getProduct(String productId) {
		return ProductUtil.transformProductToProductDto(ProductRepository.findById(Long.parseLong(productId)).get());
	}

	@Override
	public void deleteProduct(String productId) {
		ProductRepository.deleteById(Long.parseLong(productId));
	}

}
