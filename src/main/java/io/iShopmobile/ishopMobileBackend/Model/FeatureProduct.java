package io.iShopmobile.ishopMobileBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class FeatureProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String productDescription;
    private String price;
    private long defaultQuantity;
    private String shippingCost;
    private long StockLevel;

    private String imageUrl;

    @OneToMany(targetEntity = Size.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private List<Size> sizes;
}
