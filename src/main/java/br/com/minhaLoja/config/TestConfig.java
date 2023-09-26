package br.com.minhaLoja.config;

import br.com.minhaLoja.entities.User;
import br.com.minhaLoja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "998989898", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "999991111", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

        System.out.println(u2);

    }
}
