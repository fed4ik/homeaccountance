package com.fedsav.homeaccountance.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@RestController
public class HealthController {
    private Set<User> users = new HashSet<>();

    @GetMapping("/health")
    String getHealthStatus(){
        return "Ok";
    }

    @GetMapping("/users")
    Set<User> getUserList() {
        return users;
    }

    @GetMapping("/user/{userId}")
    User getUserList(@PathVariable UUID userId) {

        return users.stream()
                .filter(user -> userId.equals(user.getId()))
                .findAny().get();
    }

    @PostMapping("/user")
    UUID getUserList(@RequestBody User user) {

        user.setId(UUID.randomUUID());
        users.add(user);

        return user.getId();
    }

    @PutMapping("/editUser")
    UUID modifyUser(@RequestBody User user) {

        users.remove(user);
        users.add(user);

        return user.getId();
    }

    @DeleteMapping("/deleteUser")
    void deleteUser(@RequestBody User user) {

        users.remove(user);
    }

}
class User {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}