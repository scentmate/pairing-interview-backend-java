package com.scentmate.movies;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
class MoviesApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MoviesApplication.class).run(args);
	}

}


