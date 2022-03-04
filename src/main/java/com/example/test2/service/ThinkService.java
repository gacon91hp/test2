package com.example.test2.service;

import com.example.test2.DTO.RequesProductDTO;
import com.example.test2.constant.ProductConstant;
import com.example.test2.model.Product;
import com.example.test2.repository.ProductRepository;
import com.example.test2.service.request.BookOnTapRequest;
import com.example.test2.service.request.FurnitureRequest;
import com.example.test2.service.request.ThinkRequest;
import com.example.test2.service.request.VideoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThinkService {
    @Autowired
    private BookOnTapRequest bookOnTapRequest;
    @Autowired
    private VideoRequest videoRequest;
    @Autowired
    private FurnitureRequest furnitureRequest;
    @Autowired
    private ProductRepository productRepository;


    private  static final Map<Integer, ThinkRequest> _HANDLER = new HashMap<>();

    @PostConstruct
    private Map<Integer,ThinkRequest> getObject(){
        _HANDLER.put(ProductConstant._VIDEO,videoRequest);
        _HANDLER.put(ProductConstant._BOOKONTAP,bookOnTapRequest);
        _HANDLER.put(ProductConstant._FURNITURE,furnitureRequest);
        return _HANDLER;
    }

    public String createProductType(int type, Product product){
        return _HANDLER.get(type).createProduct(type,product);
    }

    public List<RequesProductDTO> findType(int type){
        return _HANDLER.get(type).getDescription();
    }

    public List<RequesProductDTO> findByAll(){
        return productRepository.findProductAll();
    }

    public List<RequesProductDTO> findId(int type){
        return productRepository.findId(type);
    }
}
