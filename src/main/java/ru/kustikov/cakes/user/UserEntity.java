package ru.kustikov.cakes.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.consumable.ConsumableEntity;
import ru.kustikov.cakes.feedback.FeedbackEntity;
import ru.kustikov.cakes.filling.FillingEntity;
import ru.kustikov.cakes.order.OrderEntity;
import ru.kustikov.cakes.producttype.ProductTypeEntity;
import ru.kustikov.cakes.rolerequest.RoleRequestEntity;
import ru.kustikov.cakes.socialnetwork.SocialNetworkEntity;
import ru.kustikov.cakes.subscriptions.SubscriptionsEntity;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonManagedReference
    private List<SocialNetworkEntity> socialNetworks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ProductTypeEntity> productTypes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<FillingEntity> fillings;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<ConsumableEntity> consumables;

    @Column(name = "last_activity")
    private Timestamp lastActivity;

    @OneToOne
    private SubscriptionsEntity subscriptions;

    @OneToMany(mappedBy = "userFrom", fetch = FetchType.LAZY)
    private List<FeedbackEntity> feedbacksFrom;

    @OneToMany(mappedBy = "userTo", fetch = FetchType.LAZY)
    private List<FeedbackEntity> feedbacksTo;
}
