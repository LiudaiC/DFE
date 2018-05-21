package com.lpc.stage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lpc.stage.dao.*")
public class LpcStageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LpcStageApplication.class, args);
	}
}
