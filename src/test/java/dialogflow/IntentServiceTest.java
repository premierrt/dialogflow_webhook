package dialogflow;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import dialogflow.simple_post.IntentProcessingException;
import dialogflow.simple_post.IntentServiceProcessorImpl;

public class IntentServiceTest {

	private IntentServiceProcessorImpl intentServiceProcessorImpl;
	private static final String jsonString= "{\n" + 
			"  \"responseId\": \"22462410-f4e3-477d-b3bd-c7064beabda6\",\n" + 
			"  \"queryResult\": {\n" + 
			"    \"queryText\": \"a lot of\",\n" + 
			"    \"parameters\": {\n" + 
			"      \"amount\": \"a lot of\",\n" + 
			"      \"toilet_activity\": \"pee\"\n" + 
			"    },\n" + 
			"    \"allRequiredParamsPresent\": true,\n" + 
			"    \"fulfillmentText\": \"Done! Saved your toilet raport. pee amount a lot of\",\n" + 
			"    \"fulfillmentMessages\": [{\n" + 
			"      \"text\": {\n" + 
			"        \"text\": [\"Done! Saved your toilet raport. pee amount a lot of\"]\n" + 
			"      }\n" + 
			"    }],\n" + 
			"    \"intent\": {\n" + 
			"      \"name\": \"projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c\",\n" + 
			"      \"displayName\": \"toiletReports\"\n" + 
			"    },\n" + 
			"    \"intentDetectionConfidence\": 1.0,\n" + 
			"    \"languageCode\": \"en\"\n" + 
			"  },\n" + 
			"  \"originalDetectIntentRequest\": {\n" + 
			"  },\n" + 
			"  \"session\": \"projects/jokes-df111/agent/sessions/2f07e702-cfb9-457e-1e57-5f2dd54037c2\"\n" + 
			"}";
	
	
	private static final String jsonStringNotOk="{\n" + 
			"  \"responseId\": \"22462410-f4e3-477d-b3bd-c7064beabda6\",\n" + 
			"  \"queryResult\": {\n" + 
			"    \"queryText\": \"a lot of\",\n" + 
			"    \"parameters\": {\n" + 
			"      \"amount\": \"a lot of\",\n" + 
			"      \"toilet_activity\": \"pee\"\n" + 
			"    },\n" + 
			"    \"allRequiredParamsPresent\": true,\n" + 
			"    \fulfillmentText\": \"Done! Saved your toilet raport. pee amount a lot of\",\n" + 
			"    \"fulfillmentMessages\": [{\n" + 
			"      \"text\": {\n" + 
			"        \"text\": [\"Done! Saved your toilet raport. pee amount a lot of\"]\n" + 
			"      }\n" + 
			"    }],\n" + 
			"    \"intent\": {\n" + 
			"      \"name\": \"projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c\",\n" + 
			"      \"displayName\": \"toiletReports\"\n" + 
			"    },\n" + 
			"    \"intentDetectionConfidence\": 1.0,\n" + 
			"    \"languageCode\": \"en\"\n" + 
			"  },\n" + 
			"  \"originalDetectIntentRequest\": {\n" + 
			"  },\n" + 
			"  \"session\": \"projects/jokes-df111/agent/sessions/2f07e702-cfb9-457e-1e57-5f2dd54037c2\"\n" + 
			"}";
	
	private String responseText = "Done! Saved your toilet raport. pee amount a lot of przerobiony w backendzie";
	private JSONObject json ;
	private JSONObject jsonNotOK;
	
	@Before
	public void setUp() throws Exception {
		intentServiceProcessorImpl = new IntentServiceProcessorImpl();
		 json = new JSONObject(jsonString.toString());
	}
	


	
}
