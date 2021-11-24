package com.sangsang.backend.jpa.entity;

import com.sangsang.backend.common.Gender;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bdt_user")
@Getter
@Setter
@EqualsAndHashCode
public class UserEntity {

    @Id
    @Column(name="oid", length = 255)
    private String oid;

    @NotNull
    @Column(name="id", length = 50)
    private String id;

    @NotNull
    @Column(name="name", length = 50)
    private String name;

    @NotNull
    @Column(name="password", length = 255)
    private String password;

    @NotNull
    @Column(name="age")
    private int age;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name="gender", length = 1)
    private Gender gender;


}
