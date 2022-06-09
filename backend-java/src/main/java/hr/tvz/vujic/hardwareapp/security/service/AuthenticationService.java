package hr.tvz.vujic.hardwareapp.security.service;

import hr.tvz.vujic.hardwareapp.security.login.LoginCommand;
import hr.tvz.vujic.hardwareapp.security.login.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
