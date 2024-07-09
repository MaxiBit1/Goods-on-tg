package com.maxibit1.tgGodds.user.exception;

public class NotFoundUser extends RuntimeException {

    public NotFoundUser(String errorText) {
        super(errorText);
    }
}
