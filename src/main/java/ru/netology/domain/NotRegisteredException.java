package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("One of the player is not registered");
    }
}