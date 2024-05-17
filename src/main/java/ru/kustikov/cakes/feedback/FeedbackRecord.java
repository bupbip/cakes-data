package ru.kustikov.cakes.feedback;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserRecord;

import java.sql.Timestamp;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "feedbackId")
public class FeedbackRecord {
    private Long feedbackId;

    @JsonBackReference
    private UserRecord userFrom;

    @JsonBackReference
    private UserRecord userTo;

    private Integer rating;

    private String comment;

    private Timestamp createdDate;
}
