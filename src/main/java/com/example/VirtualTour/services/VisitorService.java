package com.example.VirtualTour.services;

import com.example.VirtualTour.entities.Visitor;
import com.example.VirtualTour.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public List<Visitor> findAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
}
