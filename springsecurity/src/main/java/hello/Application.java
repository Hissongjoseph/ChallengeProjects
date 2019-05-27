package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}
}

/*
@SpringBootApplication
	@Configuration- tags the class as a source of bean definitions for the application context

	@EnableAutoConfiguration- Tells spring to start adding beans based on classpath settings,
		or other beans, and various property settings

	@ComponentScan- tells spring to look for other components, configurations, and services in the hello
		package, allowing it find the controllers we had created.
 */