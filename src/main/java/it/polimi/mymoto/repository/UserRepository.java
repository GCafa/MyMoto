package it.polimi.mymoto.repository;

import it.polimi.mymoto.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    /**
     * @NonNull annotation is used to avoid null values, instead an empty list is returned
     *
     * @return all users
     */
    @NonNull
    List<User> findAll();
}
