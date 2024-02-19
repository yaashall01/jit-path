package com.jobintech.jitpath.enums;

public enum TaskStatus {

    TODO("TODO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private final String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String value() {
        return this.name();
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
