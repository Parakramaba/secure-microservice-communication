package com.pdv.iamservice.record.request;

public record AuthRequestRecord(String userName,
                                String password) {

    @Override
    public String toString() {
        return "AuthRequestRecord[userName=" + this.userName + "]";
    }
}
