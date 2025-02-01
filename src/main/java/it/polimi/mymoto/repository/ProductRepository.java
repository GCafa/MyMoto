package it.polimi.mymoto.repository;

import it.polimi.mymoto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
