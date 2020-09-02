package com.psss.registro.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "authorities")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    String authority;
    @OneToMany(mappedBy = "userAuthority", fetch = FetchType.EAGER)
    List<User> users;

    public UserAuthority(String authority) {
        users = new ArrayList<>();
        this.authority = authority;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
