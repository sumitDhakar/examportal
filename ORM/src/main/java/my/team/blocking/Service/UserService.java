package my.team.blocking.Service;

import java.util.Optional;

import my.team.blocking.entity.User;

public interface UserService {
Integer saveUser(User user);
Optional<User> getOneUser(Integer id);
}
