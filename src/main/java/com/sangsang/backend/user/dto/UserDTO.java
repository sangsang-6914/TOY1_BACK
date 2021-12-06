package com.sangsang.backend.user.dto;

import com.sangsang.backend.common.constant.Gender;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String oid;

    private String userId;

    private String name;

    private int age;

    private String password;

    private Gender gender;
}
