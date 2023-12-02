package ru.kustikov.cakes.socialnetwork;

import lombok.Data;

@Data
public class SocialNetworkRecord {
    private Long socialNetworkId;

    private SocialNetworkType type;

    private String url;
}
