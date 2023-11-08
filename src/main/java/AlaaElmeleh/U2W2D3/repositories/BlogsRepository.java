package AlaaElmeleh.U2W2D3.repositories;
import AlaaElmeleh.U2W2D3.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogsRepository extends JpaRepository<Blog,Long> {
    Optional<Blog> findById(long id);
}
