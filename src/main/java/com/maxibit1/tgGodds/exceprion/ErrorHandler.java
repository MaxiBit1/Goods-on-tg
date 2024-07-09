package com.maxibit1.tgGodds.exceprion;

import com.maxibit1.tgGodds.user.exception.NotFoundUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFoundUser.class)
    public ResponseEntity<Error> notFoundUserException(NotFoundUser e) {
        log.error("Not found user Exception: " + e.getMessage());
        return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST,
                "Not found user",
                e.getMessage(),
                LocalDateTime.now()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Error> throwableException(Throwable e) {
        log.error("Throwable exception: " + e.getMessage());
        return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR,
                "Server error",
                e.getMessage(),
                LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
