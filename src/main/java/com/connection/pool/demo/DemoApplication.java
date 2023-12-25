package com.connection.pool.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class,
				JdbcTemplateAutoConfiguration.class
		}
)
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App Started!!");

		List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from user");

		for (Map<String, Object> user: users) {
			System.out.println("id: "+ user.get("id") + " name: "+ user.get("name"));
		}

		System.out.println("App Stoped!!");
	}
}
