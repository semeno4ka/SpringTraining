package com.cydeo;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void createProduct(ProductDTO product);
    List<ProductDTO> retrieveProductList();
    void updateProduct(ProductDTO product);
    void assignCategoryAndPrice(List<ProductRequest> categoryList, BigDecimal price);
    ProductDTO getProductByName(String productName);
    List<ProductDTO> getTop3products();
    List<ProductDTO> getProductByPrice(BigDecimal price);
    List<ProductDTO> getProductByPriceAndQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> getProductByCategoryId(Long categoryId);

}
