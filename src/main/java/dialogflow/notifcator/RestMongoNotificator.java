package dialogflow.notifcator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestMongoNotificator {

	@Value("${mongo_url}")
	private String mongoUrl;
	
	@Async
	public void sendJson(String  jsonObject) {
		RestTemplate rt = new RestTemplate();
		log.info("----------notyfikacja do rest mongo-----------");
		rt.postForLocation(mongoUrl, jsonObject);
	}
}
