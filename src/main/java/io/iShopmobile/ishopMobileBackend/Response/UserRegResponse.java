package io.iShopmobile.ishopMobileBackend.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegResponse {
    private Long userId;
    private String message;
}
