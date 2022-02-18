package io.iShopmobile.ishopMobileBackend.Repository;

import io.iShopmobile.ishopMobileBackend.Model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<Size, Long> {
}
