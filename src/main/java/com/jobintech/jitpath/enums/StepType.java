package com.jobintech.jitpath.enums;

public enum StepType {

    COURSE("Course"),
    PROJECT("Project");

    private final String type;

    StepType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "StepType{" +
                "type='" + type + '\'' +
                '}';
    }
}
