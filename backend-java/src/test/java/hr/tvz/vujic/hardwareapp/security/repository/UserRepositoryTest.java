package hr.tvz.vujic.hardwareapp.security.repository;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.security.login.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findAllUsers() {
        List<User> userList = userRepository.findAll();

        Assertions.assertNotNull(userList);
        Assertions.assertEquals(userList.size(), 2);
    }

    @Test
    void findByUsername() {
        Optional<User> user = userRepository.findByUsername("user");

        Assertions.assertNotNull(user);
        Assertions.assertTrue(user.isPresent());
    }
}