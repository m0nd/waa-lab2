package waa.labs.lab2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import waa.labs.lab2.domain.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select u from User u where u.posts.size > 1")
    List<User> findHavingMultiplePosts();
}
