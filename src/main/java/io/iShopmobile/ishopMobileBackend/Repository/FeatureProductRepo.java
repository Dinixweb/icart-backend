package io.iShopmobile.ishopMobileBackend.Repository;

import io.iShopmobile.ishopMobileBackend.Model.FeatureProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureProductRepo extends JpaRepository<FeatureProduct, Long> {
}
