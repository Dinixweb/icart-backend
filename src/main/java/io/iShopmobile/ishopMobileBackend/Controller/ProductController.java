package io.iShopmobile.ishopMobileBackend.Controller;

import io.iShopmobile.ishopMobileBackend.Model.Products;
import io.iShopmobile.ishopMobileBackend.Response.ProductResponse;
import io.iShopmobile.ishopMobileBackend.Services.ProductService;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    Logger logger;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/AllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProducts(){
        List<Products> products = productService.getProduct();
        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "/product/CreateProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse addProduct(@RequestBody List<Products> products){
        try {
            productService.saveProduct(products);
        }catch (Exception e){
            logger.error(String.valueOf(e));
        }
        return new ProductResponse("Successfully Added");
    }
}
