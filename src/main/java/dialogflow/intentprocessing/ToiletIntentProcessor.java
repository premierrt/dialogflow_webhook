package dialogflow.intentprocessing;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import dialogflow.simple_post.FullfillmentResponseDTO;
import dialogflow.simple_post.IntentProcessingException;
import dialogflow.simple_post.IntentServiceProcessorImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ToiletIntentProcessor implements IntenetProcessor {

	@Override
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) {
		
		FullfillmentResponseDTO respone= new FullfillmentResponseDTO();
		log.info(IntentServiceProcessorImpl.class + " ===================== "+jsonObject.toString() );
		
		
		
		try {
			JSONObject queryResult = jsonObject.getJSONObject("queryResult");
			
			respone.setFulfillmentText( queryResult.getString("fulfillmentText").concat(" przerobiony w backendzie") );
			
		} catch (JSONException e) {
			throw new RuntimeException("Json się nie parsuje", e );
		}
		
		return respone;
	
		
}
		
}		