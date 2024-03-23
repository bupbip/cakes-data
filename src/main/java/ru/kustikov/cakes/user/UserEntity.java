package ru.kustikov.cakes.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.filling.FillingEntity;
import ru.kustikov.cakes.producttype.ProductTypeEntity;
import ru.kustikov.cakes.socialnetwork.SocialNetworkEntity;

import java.sql.Timestamp;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "username")
    private String username;

    @Column(name = "description")
    private String description;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "image", columnDefinition="TEXT")
    private String image;

//    @OneToMany(targetEntity = AddressEntity.class, fetch = FetchType.EAGER)
//    private List<AddressEntity> addresses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonManagedReference
    private List<SocialNetworkEntity> socialNetworks;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductTypeEntity> productTypes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonManagedReference
    private List<FillingEntity> fillings;

//    @ManyToMany(targetEntity = OrderEntity.class, fetch = FetchType.EAGER)
//    private List<OrderEntity> orders;

    @Column(name = "last_activity")
    private Timestamp lastActivity;

//    @OneToMany
//    private List<ConsumableEntity> consumables;

//    @OneToMany
//    private List<ProductEntity> products;
}
