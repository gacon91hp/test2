package com.example.test2.repository;

import com.example.test2.DTO.RequesProductDTO;
import com.example.test2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(nativeQuery = true, name = "findType")
    List<RequesProductDTO> findType(int type);

    @Query(nativeQuery = true, name = "findAll")
    List<RequesProductDTO> findProductAll();

    @Query(nativeQuery = true, name = "findId")
    List<RequesProductDTO> findId(int type);
}
