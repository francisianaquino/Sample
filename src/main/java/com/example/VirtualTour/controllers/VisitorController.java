package com.example.VirtualTour.controllers;

import com.example.VirtualTour.entities.Visitor;
import com.example.VirtualTour.exceptions.InvalidRequestBodyException;
import com.example.VirtualTour.services.VisitorService;
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
@Api(description = "Visitor Service")
@RestController
@RequestMapping("visitors")
public class VisitorController {

    private VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @ApiOperation( "find all visitors" )
    @GetMapping
    public ResponseEntity findAllVisitors() {
        return ResponseEntity.status(200).body(visitorService.findAllVisitors());
    }

    @ApiOperation( "add visitors" )
    @PostMapping
    public ResponseEntity addVisitor(@RequestBody @Valid Visitor visitor, Errors errors) {
        if (errors.hasErrors())
            throw new InvalidRequestBodyException(getValidationErrors.apply(errors));
        return ResponseEntity.status(201)

                .contentType(MediaType.APPLICATION_JSON_UTF8)

                .body(visitorService.addVisitor(visitor));
    }

    private Function<Errors,String> getValidationErrors = err ->
            err.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
}
