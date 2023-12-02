package ru.kustikov.cakes.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.address.AddressEntity;
import ru.kustikov.cakes.order.OrderEntity;
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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(targetEntity = AddressEntity.class, fetch = FetchType.EAGER)
    private List<AddressEntity> addresses;

    @OneToMany(targetEntity = SocialNetworkEntity.class, fetch = FetchType.EAGER)
    private List<SocialNetworkEntity> socialNetworks;

    @ManyToMany(targetEntity = OrderEntity.class, fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    @Column(name = "last_activity")
    private Timestamp lastActivity;
}
