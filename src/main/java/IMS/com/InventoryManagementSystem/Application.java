package IMS.com.InventoryManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("IMS.com.InventoryManagementSystem.Repository")
//@ComponentScan(basePackages = {"IMS.com.InventoryManagementSystem", "other.package"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
