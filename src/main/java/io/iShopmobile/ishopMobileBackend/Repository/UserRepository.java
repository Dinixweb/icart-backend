package io.iShopmobile.ishopMobileBackend.Repository;

import io.iShopmobile.ishopMobileBackend.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    boolean getByEmail(String email);
    boolean getByPassword(String password);
    Users getUserByEmail(String userId);
}
