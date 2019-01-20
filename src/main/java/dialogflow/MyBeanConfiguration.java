package dialogflow;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dialogflow.intentprocessing.IntenetProcessor;
import dialogflow.intentprocessing.ToiletActivityRaport;
import dialogflow.intentprocessing.ToiletIntentProcessor;
import dialogflow.simple_post.IntentServiceProcessorImpl;

@Configuration
public class MyBeanConfiguration {

	//każdą implementacje trzeba bedzie wstrzykiwać tutaj? --> wyciagnac przez reflection?
	@Autowired
	ToiletIntentProcessor toiletIntentProcessor;
	@Autowired
	ToiletActivityRaport toiletActivityRaport;
	
	
	
	//nazwa bean to będzie intentMapCache - mozna to pozniej autowired
	//mozna zrobic klase ktora obuduje tą hashamape
	@Bean
	public HashMap<String, IntenetProcessor> intentMapCache(){
		HashMap<String, IntenetProcessor> map = new HashMap<String, IntenetProcessor>();
		map.put("projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c", toiletIntentProcessor);
		map.put("projects/pysior/agent/intents/cb8fae01-09fd-416e-8976-1d444b125d38", toiletActivityRaport);
		return map;
	}
}
