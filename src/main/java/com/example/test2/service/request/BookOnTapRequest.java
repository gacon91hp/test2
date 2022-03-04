package com.example.test2.service.request;

import com.example.test2.DTO.RequesProductDTO;
import com.example.test2.constant.ProductConstant;
import com.example.test2.model.Category;
import com.example.test2.model.Product;
import com.example.test2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class BookOnTapRequest implements ThinkRequest{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createProduct(int type,Product product) {
        Category category = new Category();
        category.setId(type);
        product.setCategory(category);
        productRepository.save(product);
        return ProductConstant._SUCCESSFUL;
    }

    @Override
    public List<RequesProductDTO> getDescription() {
        return productRepository.findType(ProductConstant._BOOKONTAP);
    }
}
