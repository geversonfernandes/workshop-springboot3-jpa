package br.com.minhaLoja.repositories;

import br.com.minhaLoja.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
