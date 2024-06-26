package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public Emp getEmp() {
		Emp emp= new Emp();
		return emp;
	}

}
