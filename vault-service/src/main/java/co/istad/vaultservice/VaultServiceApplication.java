package co.istad.vaultservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class VaultServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultServiceApplication.class, args);
    }

}
