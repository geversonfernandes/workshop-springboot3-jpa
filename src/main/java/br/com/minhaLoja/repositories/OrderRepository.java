package br.com.minhaLoja.repositories;

import br.com.minhaLoja.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
