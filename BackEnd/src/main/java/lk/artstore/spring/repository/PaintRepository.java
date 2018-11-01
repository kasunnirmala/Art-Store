package lk.artstore.spring.repository;

import lk.artstore.spring.entity.Paint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintRepository extends JpaRepository<Paint,Integer> {
}
