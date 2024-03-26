package com.miniproject.racingcar;

import com.miniproject.racingcar.controller.GameManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RacingcarApplication {

	public static void main(String[] args) {
		try {
			GameManager.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//		SpringApplication.run(RacingcarApplication.class, args);
	}

}
