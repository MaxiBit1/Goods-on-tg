package com.maxibit1.tgGodds.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "user_tg", schema = "tg_goods")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Size(max = 255)
    private String name;
    @Email
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
