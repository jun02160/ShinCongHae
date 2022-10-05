package shinbaghae.shinkong.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenCardRepository extends JpaRepository<GreenCard, Long> {
}
