package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")

//Classe para poplular o database
public class TestConfig implements CommandLineRunner {

    //Que acessa os dados, e faz a injeção de depencência, o proprio spring associa a dependencia ao teste
    @Autowired
    private UserRepository userRepository;

    //Ao implementar a inteface comandoLineRunner,tudo que colocar dentro desse método vai ser
    //executado quando a aplição for iniciada
    @Override
    public void run(String... args) throws Exception {

        //Id null por que sera gerado pelo banco de dados
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Instanciação do banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));


    }
}
