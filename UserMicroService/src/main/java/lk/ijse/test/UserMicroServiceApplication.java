package lk.ijse.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserMicroServiceApplication.class, args);
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
