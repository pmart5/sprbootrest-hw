package com.pmart5a.sprbootresthw.repository;

import com.pmart5a.sprbootresthw.enums.Authorities;
import com.pmart5a.sprbootresthw.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.pmart5a.sprbootresthw.enums.Authorities.*;

@Repository
public class UserRepository {

    public static final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("admin", new User("admin", "admin", List.of(READ, WRITE, DELETE)));
        users.put("vipUser", new User("vipUser", "vipUser", List.of(READ, WRITE)));
        users.put("user", new User("user", "user", List.of()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).getPassword().equals(password)) {
            return users.get(user).getAuthorizations();
        } else {
            return null;
        }
    }
}