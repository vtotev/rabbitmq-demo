package net.javaguides.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
