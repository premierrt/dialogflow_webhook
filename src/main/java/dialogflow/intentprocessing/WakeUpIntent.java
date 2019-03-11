package dialogflow.intentprocessing;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dialogflow.simple_post.FullfillmentResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class WakeUpIntent implements IntenetProcessor {
	
	@Autowired
	private RestTemplate rt;
	
	@Value("{rest_crud_init_url}")
	private String initUrl;

	@Override
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) {
		FullfillmentResponseDTO dto = new FullfillmentResponseDTO();
		dto.setFulfillmentText("waken up...");
		log.info("Waking up intent ..............................");
		wakeUpOtherServices();
		return dto;
	}

	@Async
	private void wakeUpOtherServices() {
		RestTemplate rt = new RestTemplate();
		rt.getForObject(initUrl, null);
	}
	
}
