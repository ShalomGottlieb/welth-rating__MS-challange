package targil.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targil.api.bean.Rich;

@Repository
public interface RichRepo extends JpaRepository<Rich, Integer> {
}
