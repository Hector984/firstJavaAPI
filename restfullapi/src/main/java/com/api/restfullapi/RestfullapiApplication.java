package com.api.restfullapi;

import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullapiApplication implements CommandLineRunner {

	// Autowired se utiliza cuando hacemos inyeccion de dependencias
	// por mdeio de propiedades
	@Autowired
	private PageService pageService;

	public static void main(String[] args) {

		SpringApplication.run(RestfullapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//var req = PageRequest.builder().title("Prueba").build();

		//var res = this.pageService.readByTitle("User2 Page");

		//var res = this.pageService.update(req,"User2 Page");

		//this.pageService.destroy("User2 Page");

		//var res = this.pageService.store(req);

		//System.out.println(res);
	}
}
