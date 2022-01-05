package springboot.api.tutorial.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.tutorial.model.Product;
import springboot.api.tutorial.repository.ProductRepository;
import springboot.api.tutorial.service.CrudService;

@RestController
@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9090")
public class ProductController {

    @Autowired
    private CrudService crudService;
    
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    
    @GetMapping("/productList")
    public ResponseEntity<List<Product>> getProductList() {
        return new ResponseEntity<List<Product>>(crudService.getProductList(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return new ResponseEntity<Product>(crudService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/product/save")
    public ResponseEntity<Void> saveOrUpdateProduct(@RequestBody Product product) {
        crudService.saveOrUpdateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        crudService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
