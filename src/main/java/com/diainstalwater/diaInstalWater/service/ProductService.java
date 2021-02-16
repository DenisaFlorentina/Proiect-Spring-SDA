package com.diainstalwater.diaInstalWater.service;


import com.diainstalwater.diaInstalWater.model.Product;
import com.diainstalwater.diaInstalWater.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct (Product product){
        return productRepository.saveAndFlush(product);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

       public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
