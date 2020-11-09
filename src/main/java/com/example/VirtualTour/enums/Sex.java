package com.example.VirtualTour.enums;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String label;

    private Sex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
