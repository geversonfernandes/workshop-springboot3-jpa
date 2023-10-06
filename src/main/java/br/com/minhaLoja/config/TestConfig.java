package br.com.minhaLoja.config;

import br.com.minhaLoja.entities.Category;
import br.com.minhaLoja.entities.Order;
import br.com.minhaLoja.entities.Product;
import br.com.minhaLoja.entities.User;
import br.com.minhaLoja.entities.enums.OrderStatus;
import br.com.minhaLoja.repositories.CategoryRepository;
import br.com.minhaLoja.repositories.OrderRepository;
import br.com.minhaLoja.repositories.ProductRepository;
import br.com.minhaLoja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of Rings", "testando produto 1", 90.5, "");
        Product p2 = new Product(null, "SmartTV", "testando produto 2", 2190.5, "");
        Product p3 = new Product(null, "Macbook Pro", "testando produto 3", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "testando produto 4", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "testando produto 5", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll((Arrays.asList(p1, p2, p3, p4, p5)));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "998989898", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "999991111", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        System.out.println(u2);

    }
}
