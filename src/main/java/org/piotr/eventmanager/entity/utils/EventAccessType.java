package org.piotr.eventmanager.entity.utils;


public enum EventAccessType {
    PUBLIC("public"),
    PRIVATE("private");

    private String accessType;

    EventAccessType(String accessType) {
        this.accessType = accessType;
    }

}
