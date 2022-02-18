package io.iShopmobile.ishopMobileBackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String home(){
        return "welcome to iShop";
    }
}
