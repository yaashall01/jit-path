package com.jobintech.jitpath.enums;

public enum CurriculumStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String curriculumStatus;

    CurriculumStatus(String curriculumStatus) {
        this.curriculumStatus = curriculumStatus;
    }

    public String getCurriculumStatus() {
        return curriculumStatus;
    }

    @Override
    public String toString() {
        return "Status{" +
                "pathStatus='" + curriculumStatus + '\'' +
                '}';
    }

}
