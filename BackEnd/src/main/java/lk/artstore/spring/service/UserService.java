package lk.artstore.spring.service;

public interface UserService {
    boolean canAuthenticate(String username, String password);
}
