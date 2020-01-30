package com.example.ejerciciobe;

import com.example.ejerciciobe.Entity.Product;
import com.example.ejerciciobe.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciobeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjerciciobeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EjerciciobeApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ProductService productService) {
		return (args -> {
			LOGGER.info("Saving products...\n");
			productService.save(new Product("Camiseta Nike Boca Juniors Azul S", (double) 1959, 12));
			productService.save(new Product("Auriculares Inalámbrico Xiaomi Redmi Airdots Negro", (double) 3532, 5));
			productService.save(new Product("Celular Libre Motorola Motorola One Action", (double) 25999, 20));
			productService.save(new Product("Escalera Articulada 16 escalones Garden Life", (double) 59999, 5));
			productService.save(new Product("Guitarra Eléctrica DEAN DIB Negro", (double) 21390, 5));
			LOGGER.info("Products saved");
		});
	}
}
