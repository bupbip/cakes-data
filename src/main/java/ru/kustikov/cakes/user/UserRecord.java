package ru.kustikov.cakes.user;

import lombok.Data;
import ru.kustikov.cakes.consumable.ConsumableRecord;
import ru.kustikov.cakes.feedback.FeedbackRecord;
import ru.kustikov.cakes.filling.FillingRecord;
import ru.kustikov.cakes.producttype.ProductTypeRecord;
import ru.kustikov.cakes.socialnetwork.SocialNetworkEntity;
import ru.kustikov.cakes.subscriptions.SubscriptionsRecord;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UserRecord {
    private Long userId;

    private String email;

    private String phone;

    private String username;

    private String description;

    private String password;

    private String role;

    private String image;

    private List<SocialNetworkEntity> socialNetworks;

    private List<ProductTypeRecord> productTypes;

    private List<FillingRecord> fillings;

    private List<ConsumableRecord> consumables;

    private Timestamp lastActivity;

    private SubscriptionsRecord subscriptions;

    private List<FeedbackRecord> feedbacksTo;
}
