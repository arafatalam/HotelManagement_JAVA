package nbcc.hotelmanagement.services;

import nbcc.hotelmanagement.entities.User;

public interface LoginService {


    boolean register(User user);

    boolean login(User user);

    void logout();

    boolean isLoggedIn();

    boolean isLoggedOut();
}
