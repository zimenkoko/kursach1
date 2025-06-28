package com.pharmacy.warehouse.repository;

import com.pharmacy.warehouse.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test") // если есть отдельный application-test.yml — можно использовать
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("pass");
        user.setRole("ADMIN");

        userRepository.save(user);

        Optional<User> result = userRepository.findByUsername("admin");
        assertTrue(result.isPresent());
        assertEquals("admin", result.get().getUsername());
    }
}
