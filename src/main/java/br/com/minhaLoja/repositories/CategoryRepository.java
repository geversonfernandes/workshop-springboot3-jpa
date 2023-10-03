package br.com.minhaLoja.repositories;

import br.com.minhaLoja.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
