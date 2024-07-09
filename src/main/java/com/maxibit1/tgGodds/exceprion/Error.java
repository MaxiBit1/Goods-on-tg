package com.maxibit1.tgGodds.exceprion;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

    private HttpStatus httpStatus;
    private String titleError;
    private String description;
    private LocalDateTime localDateTime;
}
