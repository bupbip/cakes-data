package ru.kustikov.cakes.rolerequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.user.UserEntity;

import java.sql.Timestamp;

@Entity(name = "role_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_request_id")
    private Long roleRequestId;

    @OneToOne
    private UserEntity user;

    @Column(name = "request_datetime")
    private Timestamp requestDatetime;
}
