package it.polimi.mymoto.repository;

import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @NonNull
    List<Product> findAllBySeller(@NonNull User seller);
}
