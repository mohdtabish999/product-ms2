package com.product.ms2.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.ms2.dto.ProductDto;
import com.product.ms2.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productapi2/product")
@Api(description = "Service for Products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// @Log4j
public class ProductController {

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "Get List of Products")
	@RequestMapping(method = RequestMethod.GET)
	public List<ProductDto> getItems() {
		LOGGER.debug("Fetching all Products");
		return productService.getProducts();
	}

	@ApiOperation(value = "Add Product")
	@RequestMapping(method = RequestMethod.POST)
	public ProductDto save(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}

	@ApiOperation(value = "Get Product by id")
	@RequestMapping(path = "id/{productId}", method = RequestMethod.GET)
	public ProductDto getItem(@PathVariable String productId) {
		LOGGER.debug("Get request {}", productId);
		return productService.getProduct(productId);
	}

	@ApiOperation(value = "Delete Product by id")
	@RequestMapping(path = "id/{productId}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable String productId) {
		LOGGER.debug("deleting Product {}", productId);
		productService.deleteProduct(productId);
	}
}
