package com.example.rentparking.entity.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SocialUser {
    private String id;
    private String authToken;
    private String email;
    private String  firstName;
    private String  idToken;
    private String lastName;
    private String  name;
    private String  photoUrl;
    private String  provider;
}
