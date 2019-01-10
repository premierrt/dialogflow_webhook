package dialogflow.simple_post;

import org.json.JSONException;
import org.json.JSONObject;
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

	@PostMapping("/webhook")
	/**
	 * https://dialogflow.com/docs/reference/api-v2/rest/Shared.Types/WebhookRequest
	 * https://dialogflow.com/docs/reference/api-v2/rest/Shared.Types/WebhookResponse
	 * https://www.testingexcellence.com/how-to-parse-json-in-java/
	 * @param json
	 * @return
	 */
	public ResponseEntity<?> processDialogFlowPost(@RequestBody String json){
	
		log.info("--------- "+json );
		try {
			JSONObject jsonObject = new JSONObject(json.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
