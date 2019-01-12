package dialogflow.simple_post;

import org.json.JSONObject;

public interface IntentServiceProcessor {

	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) throws IntentProcessingException ;
	
}
