package com.codenation.cifra.model;

public class CipherModel {

    private String message;
    private int changeFactor;

    public CipherModel(String message, int changeFactor) {
        this.message = message;
        this.changeFactor = changeFactor;
    }

    public String getMessage() {
        return message;
    }

    public int getChangeFactor() {
        return changeFactor;
    }

}
