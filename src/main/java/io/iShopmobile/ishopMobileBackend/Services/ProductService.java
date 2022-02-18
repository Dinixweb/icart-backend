package io.iShopmobile.ishopMobileBackend.Services;

import io.iShopmobile.ishopMobileBackend.Model.Products;
import io.iShopmobile.ishopMobileBackend.Model.Size;
import io.iShopmobile.ishopMobileBackend.Repository.ProductRepository;
import io.iShopmobile.ishopMobileBackend.Repository.SizesRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private  final SizesRepository sizesRepository;

    public ProductService(ProductRepository productRepository, SizesRepository sizesRepository) {
        this.productRepository = productRepository;
        this.sizesRepository = sizesRepository;
    }

    public List<Products> getProduct(){
        return productRepository.findAll().stream()
                .sorted(Comparator.comparing(e->e.getProductName())).collect(Collectors.toList());
    }

    public void saveProduct(List<Products> products){
        productRepository.saveAll(products);
/*         products.stream().map(e->e.getSizes());
         System.out.println(products);*/
        //sizesRepository.saveAll(products);
    }
}
