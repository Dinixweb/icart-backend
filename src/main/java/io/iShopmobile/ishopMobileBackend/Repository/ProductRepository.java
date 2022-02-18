package io.iShopmobile.ishopMobileBackend.Repository;

import io.iShopmobile.ishopMobileBackend.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
