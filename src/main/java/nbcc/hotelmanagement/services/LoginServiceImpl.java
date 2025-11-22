package nbcc.hotelmanagement.services;

import jakarta.servlet.http.HttpSession;
import nbcc.hotelmanagement.entities.User;
import nbcc.hotelmanagement.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String USER_ID_SESSION_KEY = "userId";
    private static final String USER_NAME_SESSION_KEY = "username";

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public LoginServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, HttpSession httpSession) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }


    @Override
    public boolean register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;

    }

    @Override
    public boolean login(User user) {

        if (user == null) {
            return false;
        }

        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser == null) {
            return false;
        }

        if(isValidPassowrd(user.getPassword(), dbUser.getPassword())){
            httpSession.setAttribute(USER_ID_SESSION_KEY, dbUser.getUserId());
            httpSession.setAttribute(USER_NAME_SESSION_KEY, dbUser.getUsername());

            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(USER_ID_SESSION_KEY);
        httpSession.removeAttribute(USER_NAME_SESSION_KEY);
    }

    @Override
    public boolean isLoggedIn() {

        return getUserId() != null;
    }

    @Override
    public boolean isLoggedOut() {

        return !isLoggedIn();

    }
    private Long getUserId() {
        return (Long) httpSession.getAttribute(USER_ID_SESSION_KEY);
    }

    private boolean isValidPassowrd(String plainTextPassword, String hashedPassowrd) {
        return passwordEncoder.matches(plainTextPassword, hashedPassowrd);
    }
}
