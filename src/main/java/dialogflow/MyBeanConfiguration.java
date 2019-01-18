package dialogflow;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dialogflow.intentprocessing.ToiletIntentProcessor;
import dialogflow.simple_post.IntentServiceProcessorImpl;

@Configuration
public class MyBeanConfiguration {

	//każdą implementacje trzeba bedzie wstrzykiwać tutaj?
	@Autowired
	ToiletIntentProcessor toiletIntentProcessor;
	
	
	//nazwa bean to będzie intentMapCache - mozna to pozniej autowired
	//mozna zrobic klase ktora obuduje tą hashamape
	@Bean
	public HashMap<String, ToiletIntentProcessor> intentMapCache(){
		HashMap<String, ToiletIntentProcessor> map = new HashMap<String, ToiletIntentProcessor>();
		map.put("projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c", toiletIntentProcessor);
		return map;
	}
}
