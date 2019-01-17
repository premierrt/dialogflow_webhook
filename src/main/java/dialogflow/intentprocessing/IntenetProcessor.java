package dialogflow.intentprocessing;

import org.json.JSONObject;

import dialogflow.simple_post.FullfillmentResponseDTO;

public interface IntenetProcessor {

	public FullfillmentResponseDTO processIntent(JSONObject jsonObject);
}
