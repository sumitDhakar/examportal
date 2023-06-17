package my.team.blocking.Reopcitry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import my.team.blocking.entity.User;

public interface UserReopcitry extends JpaRepository<User, Integer> {
Optional<User> findByUserEmail(String userEmail);
}
