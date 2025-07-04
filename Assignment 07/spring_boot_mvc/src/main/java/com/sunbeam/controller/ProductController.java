package com.sunbeam.controller;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProducts(@RequestParam("categoryId") Long id, Model model) {
//        System.out.println("in list "+modelAttrMap);
        model.addAttribute("productList", productService.findAllProducts(id));
        return "products/list";

    }
}
