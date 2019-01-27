package dialogflow.notifcator;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component("restConector")
@ConditionalOnProperty(name="notification.type", havingValue="REST")
@Slf4j
public class RestConnector implements Notifier, Connector {

	@Value("${rest_crud_url}")
	private String url;
	/* (non-Javadoc)
	 * @see dialogflow.notifcator.Connector#send(java.util.HashMap)
	 */
	@Override
	@Async
	public void send(HashMap<?, ?> parameters) {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity= new HttpEntity<>(parameters);
		restTemplate.postForEntity(url, httpEntity, null);
		log.info("============ RestTemplate ======= "+httpEntity.toString());
		
	}
	/* (non-Javadoc)
	 * @see dialogflow.notifcator.Connector#getHistory()
	 */
	@Override
	public List<ActivityEntry> getHistory(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ActivityEntry>> response= restTemplate.exchange(url,HttpMethod.GET, null, new ParameterizedTypeReference<List<ActivityEntry>>(){} );
		
		
		log.info("============ RestTemplate GetHistory ======= ");
		return response.getBody();
		
	}
}
