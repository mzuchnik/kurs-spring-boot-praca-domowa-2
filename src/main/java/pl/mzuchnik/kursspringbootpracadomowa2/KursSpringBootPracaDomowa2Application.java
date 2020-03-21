package pl.mzuchnik.kursspringbootpracadomowa2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mzuchnik.kursspringbootpracadomowa2.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class KursSpringBootPracaDomowa2Application {

    public static void main(String[] args) {
        SpringApplication.run(KursSpringBootPracaDomowa2Application.class, args);
    }

    @Bean
    public List<Product> getDefaultProductList()
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", new BigDecimal(new Random().nextDouble() * 250 + 50)));
        products.add(new Product("Product2", new BigDecimal(new Random().nextDouble() * 250 + 50)));
        products.add(new Product("Product3", new BigDecimal(new Random().nextDouble() * 250 + 50)));
        products.add(new Product("Product4", new BigDecimal(new Random().nextDouble() * 250 + 50)));
        products.add(new Product("Product5", new BigDecimal(new Random().nextDouble() * 250 + 50)));
        return products;
    }

}
