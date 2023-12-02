package ru.kustikov.cakes.feedback;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kustikov.cakes.user.UserEntity;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @OneToOne
    @Column(name = "user_id_from")
    private UserEntity userFrom;

    @OneToOne
    @Column(name = "user_id_to")
    private UserEntity userTo;

    @Column(name = "rating")
    @Min(1)
    @Max(5)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_date")
    private Timestamp createdDate;
}
