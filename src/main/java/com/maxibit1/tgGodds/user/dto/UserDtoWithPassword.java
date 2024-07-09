package com.maxibit1.tgGodds.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoWithPassword {
    @Size(max = 255)
    private String name;
    @Email
    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String password;
}
