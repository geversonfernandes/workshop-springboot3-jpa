package br.com.minhaLoja.repositories;

import br.com.minhaLoja.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
