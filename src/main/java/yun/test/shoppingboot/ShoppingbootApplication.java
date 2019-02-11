package yun.test.shoppingboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import javax.sql.DataSource;

@SpringBootApplication
public class ShoppingbootApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}

