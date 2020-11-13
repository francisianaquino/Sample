package com.example.VirtualTour.services;

import com.example.VirtualTour.entities.Feedback;
import com.example.VirtualTour.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
