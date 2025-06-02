package org.example.aplikacjazaliczeniowa.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
User findByNameAndPassword(String name, String password);
}
