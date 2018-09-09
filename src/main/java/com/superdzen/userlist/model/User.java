package com.superdzen.userlist.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotNull(message = "Поле не может быть пустым")
    @Size(min = 1, message = "Поле не может быть пустым")
    private String firstName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
