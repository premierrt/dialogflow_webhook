package dialogflow.intentprocessing;

import org.json.JSONException;
import org.json.JSONObject;

import dialogflow.simple_post.FullfillmentResponseDTO;
import dialogflow.simple_post.IntentServiceProcessorImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FallbackIntentProcessor implements IntenetProcessor {

	@Override
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) {
		FullfillmentResponseDTO respone= new FullfillmentResponseDTO();
		log.info(IntentServiceProcessorImpl.class + " ===================== "+jsonObject.toString() );
		
		
		
		try {
			JSONObject queryResult = jsonObject.getJSONObject("queryResult");
			
			respone.setFulfillmentText( "Fallback z backendu - nie ma takiego intentu!" );
			
		} catch (JSONException e) {
			throw new RuntimeException("Json się nie parsuje", e );
		}
		
		return respone;
	
	}

}
