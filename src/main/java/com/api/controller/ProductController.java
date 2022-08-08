package com.api.controller;


import com.api.entity.Product;
import com.api.helper.Helper;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file ) {
        Boolean isCorrectFile=Helper.checkExcelFormat(file);

        if (isCorrectFile) {

            //true

            this.productService.save(file);

            return ResponseEntity.status(HttpStatus.OK).body( "File is uploaded and data is saved to db");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
    }
    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return this.productService.getAllProducts();
}
    }


