package AlaaElmeleh.U2W2D3.repositories;
import AlaaElmeleh.U2W2D3.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Author,Long> {
    Optional<Author> findById(long id);
}
