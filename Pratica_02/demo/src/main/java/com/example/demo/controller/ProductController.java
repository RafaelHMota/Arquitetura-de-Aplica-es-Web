package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET: http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // POST: http://localhost:8080/api/products
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // GET: Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // PUT: Atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> product = productService.updateProduct(id, updatedProduct);
        return product.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: http://localhost:8080/api/products/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}


// Inserir Itens
//Invoke-RestMethod -Uri "http://localhost:8080/api/products" -Method Post -Headers @{"Content-Type"="application/json"} -Body '{"name": "Notebook"}'

// Buscar todos os produtos
// Invoke-RestMethod -Uri "http://localhost:8080/api/products" -Method Get

//Buscar um produto específico (ex: ID = 1)
//Invoke-RestMethod -Uri "http://localhost:8080/api/products/1" -Method Get

//Atualizar um produto existente (ex: ID = 1)
//Invoke-RestMethod -Uri "http://localhost:8080/api/products/1" -Method Put -Headers @{"Content-Type"="application/json"} -Body '{"name": "Notebook Gamer"}'

//Deletar um produto existente
//Invoke-RestMethod -Uri "http://localhost:8080/api/products/1" -Method Delete
