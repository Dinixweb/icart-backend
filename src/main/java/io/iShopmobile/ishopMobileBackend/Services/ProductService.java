package io.iShopmobile.ishopMobileBackend.Services;

import io.iShopmobile.ishopMobileBackend.Model.FeatureProduct;
import io.iShopmobile.ishopMobileBackend.Model.Products;
import io.iShopmobile.ishopMobileBackend.Repository.FeatureProductRepo;
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
    private final FeatureProductRepo featureProductRepo;

    public ProductService(ProductRepository productRepository, SizesRepository sizesRepository, FeatureProductRepo featureProductRepo) {
        this.productRepository = productRepository;
        this.sizesRepository = sizesRepository;
        this.featureProductRepo = featureProductRepo;
    }

    public List<Products> getProduct(){
        return productRepository.findAll().stream()
                .sorted(Comparator.comparing(e->e.getProductName())).collect(Collectors.toList());
    }
    public void saveProduct(List<Products> products){
        productRepository.saveAll(products);

    }

    //  Feature products
    public List<FeatureProduct> getProductFeatured(){
        return featureProductRepo.findAll().stream()
                .sorted(Comparator.comparing(e->e.getProductName())).collect(Collectors.toList());
    }

    public void saveProductFeatured(List<FeatureProduct> featureProducts){
        featureProductRepo.saveAll(featureProducts);
    }
}
