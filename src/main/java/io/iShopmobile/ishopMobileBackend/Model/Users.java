package io.iShopmobile.ishopMobileBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
