package waa.labs.lab2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import waa.labs.lab2.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
