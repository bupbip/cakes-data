package ru.kustikov.cakes.order;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.kustikov.cakes.productorder.ProductOrderRecord;
import ru.kustikov.cakes.user.UserRecord;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderId")
public class OrderRecord {
    private Long orderId;

    private String status;

    private Integer preferPrice;

    private Integer spentPrice;

    private Integer resultPrice;

    private String comment;

    @JsonManagedReference
    private UserRecord customer;

    @JsonManagedReference
    private UserRecord confectioner;

    private LocalDateTime createdDate;

    private LocalDateTime completeDate;

    private String deliveryType;

    private String address;

    private List<ProductOrderRecord> products;
}
