package dialogflow;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dialogflow.intentprocessing.IntenetProcessor;
import dialogflow.intentprocessing.ToiletActivityHistory;
import dialogflow.intentprocessing.ToiletActivityRaport;
import dialogflow.intentprocessing.ToiletIntentProcessor;
import dialogflow.simple_post.IntentServiceProcessorImpl;

@Configuration
public class MyBeanConfiguration {

	//każdą implementacje trzeba bedzie wstrzykiwać tutaj? --> wyciagnac przez reflection?
	@Autowired
	ToiletIntentProcessor toiletIntentProcessor;
	@Autowired
	ToiletActivityRaport toiletActivityRaport; //zmienic na interfejs, ale wtedy trzeba qualifier
	//https://www.baeldung.com/spring-autowire
	@Autowired
	@Qualifier("toiletActivityHistory")
	IntenetProcessor toiletActivityHistory;
	
	@Autowired
	@Qualifier("wakeUpIntent")
	IntenetProcessor wakeUpIntent;
	
	
	//nazwa bean to będzie intentMapCache - mozna to pozniej autowired
	//mozna zrobic klase ktora obuduje tą hashamape
	@Bean
	public HashMap<String, IntenetProcessor> intentMapCache(){
		HashMap<String, IntenetProcessor> map = new HashMap<String, IntenetProcessor>();
		map.put("projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c", toiletIntentProcessor);
		map.put("projects/pysior/agent/intents/cb8fae01-09fd-416e-8976-1d444b125d38", toiletActivityRaport);
		map.put("projects/pysior/agent/intents/1890557d-b69b-40e6-bd21-f32982175c55", toiletActivityHistory);
		map.put("projects/pysior-37fed/agent/intents/1890557d-b69b-40e6-bd21-f32982175c55",toiletActivityHistory);
		map.put("projects/pysior-37fed/agent/intents/cb8fae01-09fd-416e-8976-1d444b125d38", toiletActivityRaport);	
		map.put("projects/pysior-37fed/agent/intents/3ca05da5-e4c5-4892-a14e-66047f915189", wakeUpIntent);
		return map;
	}
}
