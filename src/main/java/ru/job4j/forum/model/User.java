package ru.job4j.forum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class User {

    private int id;

    private String username;

    private String password;
}
