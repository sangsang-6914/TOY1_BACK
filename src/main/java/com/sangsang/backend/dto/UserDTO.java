package com.sangsang.backend.dto;

import com.sangsang.backend.common.Gender;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String oid;

    private String id;

    private String name;

    private int age;

    private String password;

    private Gender gender;
}
