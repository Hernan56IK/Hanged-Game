package com.example.hangedgame.model;

public class Word {
    private String Secret;

    public Word(String Secret){
        this.Secret=Secret;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }
}
