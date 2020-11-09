package com.example.VirtualTour.enums;

public enum Institution {
    SME("SME"),
    ACADEME("Academe"),
    LGU("LGU"),
    STUDENT("Student"),
    GENERAL_PUBLIC("General Public"),
    PWD("PWD"),
    RNV_JCM("RNV&JCM");

    private String label;

    private Institution(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}