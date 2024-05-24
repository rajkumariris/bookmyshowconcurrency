package Repositories;

import Models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long userId);

    @Override
    List<User> findAllById(Iterable<Long> longs);
    //this is will be internally select * from users where id in (1,2,3,4,5


    //if method giving error give optional
    Optional<User> findByEmailId(String email);
}
