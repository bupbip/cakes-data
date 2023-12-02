package ru.kustikov.cakes.feedback;

import lombok.Data;
import ru.kustikov.cakes.user.UserEntity;

import java.sql.Timestamp;

@Data
public class FeedbackRecord {
    private Long feedbackId;

    private String userFrom;

    private UserEntity userTo;

    private Integer rating;

    private String comment;

    private Timestamp createdDate;
}
