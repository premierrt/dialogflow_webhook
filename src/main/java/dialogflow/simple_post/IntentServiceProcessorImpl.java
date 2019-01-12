package dialogflow.simple_post;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IntentServiceProcessorImpl implements IntentServiceProcessor {

	@Override
	/**
	 * https://www.testingexcellence.com/how-to-parse-json-in-java/
	 * do refaktory - obsluga bledow i zeby nie zwracal null-a. czy deklaracja objektow w metodzie na gorze?
	 * czy do serwisu nie powinien przekazac wejsciowego stringa i tam reszte przerobic?
	 * https://www.toptal.com/java/spring-boot-rest-api-error-handling
	 */
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) throws IntentProcessingException {
	
		FullfillmentResponseDTO respone= new FullfillmentResponseDTO();
		log.info(IntentServiceProcessorImpl.class + " ===================== "+jsonObject.toString() );
		try {
			JSONObject queryResult = jsonObject.getJSONObject("queryResult");
			
			respone.setFulfillmentText( queryResult.getString("fulfillmentText").concat(" przerobiony w backendzie") );
			
		} catch (JSONException e) {
			throw new IntentProcessingException("Json się nie parsuje", e );
		}
		
		return respone;
	}

}
