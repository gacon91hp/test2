package com.example.test2.controller;

import com.example.test2.DTO.RequesProductDTO;
import com.example.test2.model.Product;
import com.example.test2.service.ThinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThinkController {
    @Autowired
    private ThinkService thinkService;

    @PostMapping("save")
    public String saveProduct(@RequestBody Product product,
                              @RequestParam int type){
        return thinkService.createProductType(type,product);
    }

    @GetMapping("findType")
    public List<RequesProductDTO> findType(@RequestParam int type){
        return thinkService.findType(type);
    }

    @GetMapping("findAll")
    public List<RequesProductDTO> findAll(){
        return thinkService.findByAll();
    }

    @GetMapping("findId")
    public List<RequesProductDTO> findId(@RequestParam int type){
        return thinkService.findId(type);
    }
}
