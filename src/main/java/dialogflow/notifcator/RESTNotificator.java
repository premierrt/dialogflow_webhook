package dialogflow.notifcator;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@ConditionalOnProperty(name="notification.type", havingValue="REST")
@Slf4j
public class RESTNotificator implements Notifier {

	@Value("${rest_crud_url}")
	private String url;
	@Override
	@Async
	public void send(HashMap<?, ?> parameters) {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity= new HttpEntity<>(parameters);
		restTemplate.postForEntity(url, httpEntity, null);
		log.info("============ RestTemplate ======= "+httpEntity.toString());
		
	}
}
