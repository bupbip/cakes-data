package ru.kustikov.cakes.user;

import lombok.Data;
import ru.kustikov.cakes.socialnetwork.SocialNetworkEntity;

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

//    private List<AddressEntity> addresses;

    private List<SocialNetworkEntity> socialNetworks;

    private Timestamp lastActivity;
}
