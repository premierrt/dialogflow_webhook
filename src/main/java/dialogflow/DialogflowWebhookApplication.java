package dialogflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DialogflowWebhookApplication {

	//https://stackoverflow.com/questions/34172888/difference-between-bean-and-autowired
		
	public static void main(String[] args) {
		SpringApplication.run(DialogflowWebhookApplication.class, args);
	}

}

