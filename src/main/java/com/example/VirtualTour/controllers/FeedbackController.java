package com.example.VirtualTour.controllers;

import com.example.VirtualTour.entities.Feedback;
import com.example.VirtualTour.exceptions.InvalidRequestBodyException;
import com.example.VirtualTour.services.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(description = "Feedback Service")
@RestController
@RequestMapping("feedbacks")
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @ApiOperation( "find all visitors" )
    @GetMapping
    public ResponseEntity findAllFeedbacks() {
        return ResponseEntity.status(200).body(feedbackService.findAllFeedbacks());
    }

    @ApiOperation( "add visitors" )
    @PostMapping
    public ResponseEntity addFeedback(@RequestBody @Valid Feedback feedback, Errors errors) {
        if (errors.hasErrors())
            throw new InvalidRequestBodyException(getValidationErrors.apply(errors));
        return ResponseEntity.status(201)

                .contentType(MediaType.APPLICATION_JSON_UTF8)

                .body(feedbackService.addFeedback(feedback));
    }

    private Function<Errors,String> getValidationErrors = err ->
            err.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
}
