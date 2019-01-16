package dialogflow;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DialogflowWebhookApplication implements CommandLineRunner{

	//https://stackoverflow.com/questions/34172888/difference-between-bean-and-autowired
	//http://zetcode.com/articles/springbootbean/
		

	
	public static void main(String[] args) {
		SpringApplication.run(DialogflowWebhookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

