package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.entity.Product;
import com.actualtraining.samplerestjpa.model.ErrorDesc;
import com.actualtraining.samplerestjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findProductById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorDesc(111, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.created(null).body(productService.saveOrUpdate(product));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorDesc(112, e.getMessage()));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
        try {
            product.setId(id);
            return ResponseEntity.ok(productService.saveOrUpdate(product));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorDesc(113, e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        try {
            productService.delete(id);
            return ResponseEntity.ok().body("Product with id " + id + " deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorDesc(114, e.getMessage()));
        }
    }
}
