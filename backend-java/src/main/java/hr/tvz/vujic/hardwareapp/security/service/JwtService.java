package hr.tvz.vujic.hardwareapp.security.service;

import hr.tvz.vujic.hardwareapp.security.login.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
