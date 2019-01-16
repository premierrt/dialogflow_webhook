package dialogflow;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {

	//nazwa bean to będzie intentMapCache - mozna to pozniej autowired
	//mozna zrobic klase ktora obuduje tą hashamape
	@Bean
	public HashMap<String, String> intentMapCache(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("intent1", "klasa_stategy_1");
		return map;
	}
}
