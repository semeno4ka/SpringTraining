package com.cydeo.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(mapperUtil.convert(productDTO, new Product()));
    }

    @Override
    public List<ProductDTO> retrieveProductList() {
        return productRepository.findAll().stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(ProductDTO product) {
     Optional<Product> productEntity=productRepository.findById(product.getId());
     Product entityProduct=mapperUtil.convert(product,new Product());
     entityProduct.setId(productEntity.get().getId());
     productRepository.save(entityProduct);
    }

    @Override
    public void assignCategoryAndPrice(List<ProductRequest> categoryList, BigDecimal price) {

    }

    @Override
    public ProductDTO getProductByName(String productName) {
        return null;
    }

    @Override
    public List<ProductDTO> getTop3products() {
        return null;
    }

    @Override
    public List<ProductDTO> getProductByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<ProductDTO> getProductByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return null;
    }

    @Override
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        return null;
    }
}
