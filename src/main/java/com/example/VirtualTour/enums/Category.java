package com.example.VirtualTour.enums;

public enum Category {
    SME("SME"),
    ACADEME("Academe"),
    LGU("LGU"),
    STUDENT("Student"),
    GENERAL_PUBLIC("General Public"),
    PWD("PWD"),
    RNV_JCM("RNV&JCM");

    private String label;

    private Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}