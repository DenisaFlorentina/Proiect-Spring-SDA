package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Product;
import com.diainstalwater.diaInstalWater.service.ProductService;
import com.diainstalwater.diaInstalWater.service.WorkService;
import com.diainstalwater.diaInstalWater.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public String getProducts(Model model){
        List<Product> productList =productService.findAllProducts();
        model.addAttribute("products", productList);
        return "Product";
    }
    @PostMapping("/products/addNew")
    public String addNewProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }
    @RequestMapping(value = "/products/findById", method = RequestMethod.GET)
    @ResponseBody
    public Product findByIdProduct(Long id){
        return productService.getProductById(id);
    }
    @RequestMapping(value = "/products/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }
    @RequestMapping(value = "/products/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteProduct(Long id) {
      productService.deleteProductById(id);
        return "redirect:/products";
    }
}
