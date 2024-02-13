package ru.kustikov.cakes.feedback;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

//    public FeedbackRecord create(FeedbackRecord feedbackRecord) {
//        FeedbackEntity feedbackEntity = feedbackMapper.dtoToEntity(feedbackRecord);
//        FeedbackEntity savedFeedbackEntity = feedbackRepository.save(feedbackEntity);
//        return feedbackMapper.entityToDto(savedFeedbackEntity);
//    }

    public FeedbackRecord get(Long id) {
        FeedbackEntity feedbackEntity = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
        return feedbackMapper.entityToDto(feedbackEntity);
    }

//    public FeedbackRecord update(FeedbackRecord feedbackRecord) {
//        FeedbackEntity feedbackEntity = feedbackMapper.dtoToEntity(feedbackRecord);
//        FeedbackEntity savedFeedbackEntity = feedbackRepository.save(feedbackEntity);
//        return feedbackMapper.entityToDto(savedFeedbackEntity);
//    }

    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }
}
