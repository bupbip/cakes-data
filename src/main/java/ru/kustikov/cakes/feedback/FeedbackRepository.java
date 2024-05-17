package ru.kustikov.cakes.feedback;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kustikov.cakes.user.UserEntity;

import java.util.List;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Long> {
}
