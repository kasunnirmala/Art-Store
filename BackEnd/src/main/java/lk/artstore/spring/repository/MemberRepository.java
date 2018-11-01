package lk.artstore.spring.repository;

import lk.artstore.spring.entity.Member;
import lk.artstore.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, User> {
}
