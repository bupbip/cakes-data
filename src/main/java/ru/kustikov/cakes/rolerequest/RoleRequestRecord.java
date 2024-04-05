package ru.kustikov.cakes.rolerequest;

import lombok.Data;
import ru.kustikov.cakes.user.UserRecord;

import java.sql.Timestamp;

@Data
public class RoleRequestRecord {
    private Long roleRequestId;

    private UserRecord user;

    private Timestamp requestDatetime;
}
