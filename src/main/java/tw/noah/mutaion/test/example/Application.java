package tw.noah.mutaion.test.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	@Autowired
	MainApp app;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		MainApp app = ctx.getBean(MainApp.class);
		app.run();
	}
}
