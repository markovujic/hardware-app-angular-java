package hr.tvz.vujic.hardwareapp.security.repository;


import hr.tvz.vujic.hardwareapp.security.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
