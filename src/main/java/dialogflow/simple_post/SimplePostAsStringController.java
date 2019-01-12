package dialogflow.simple_post;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//https://www.quora.com/Can-I-fetch-a-JSON-object-in-my-spring-controller-without-using-a-model-object
@Slf4j
@RestController
public class SimplePostAsStringController {

	@Autowired
	IntentServiceProcessor intentServiceProcessor;
	
	@PostMapping("/webhook")
	/**
	 * https://dialogflow.com/docs/reference/api-v2/rest/Shared.Types/WebhookRequest
	 * https://dialogflow.com/docs/reference/api-v2/rest/Shared.Types/WebhookResponse
	 * https://www.testingexcellence.com/how-to-parse-json-in-java/
	 * @param json
	 * @return
	 */
	public ResponseEntity<?> processDialogFlowPost(@RequestBody String json) throws IntentProcessingException{
	//!!!poprawic obsluge bledow
		//https://www.toptal.com/java/spring-boot-rest-api-error-handling
		FullfillmentResponseDTO fullfillmentResponseDTO= new FullfillmentResponseDTO();
		log.info("--------- "+json );
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(json.toString());
				fullfillmentResponseDTO =intentServiceProcessor.processIntent(jsonObject);

			} catch (JSONException | IntentProcessingException e) {
					throw new IntentProcessingException("", e);
			}
		
		return ResponseEntity.status(HttpStatus.OK).body(fullfillmentResponseDTO);
		
	}
}
