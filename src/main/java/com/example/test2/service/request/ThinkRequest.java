package com.example.test2.service.request;

import com.example.test2.DTO.RequesProductDTO;
import com.example.test2.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ThinkRequest {
    String createProduct(int type,Product product);
    List<RequesProductDTO> getDescription();
}
