package waa.labs.lab2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import waa.labs.lab2.domain.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
}
