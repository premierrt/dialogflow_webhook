package dialogflow;

import org.junit.Before;
import org.junit.Test;

import dialogflow.intentprocessing.ToiletActivityHistory;

public class ToiletActivityHistoryTest {

	
	private static final String jsonString ="{\n" + 
			"  \"responseId\": \"ac1fd1f4-ac13-4399-871e-b061dd1c2e02\",\n" + 
			"  \"queryResult\": {\n" + 
			"    \"queryText\": \"3 days\",\n" + 
			"    \"parameters\": {\n" + 
			"      \"duration\": {\n" + 
			"        \"amount\": 3,\n" + 
			"        \"unit\": \"day\"\n" + 
			"      }\n" + 
			"    },\n" + 
			"    \"allRequiredParamsPresent\": true,\n" + 
			"    \"fulfillmentText\": \"Since 3 day you : 1 poo, 2 piss < Tu będzie odpowiedz z backendu. > Do you want to do anything else?\",\n" + 
			"    \"fulfillmentMessages\": [\n" + 
			"      {\n" + 
			"        \"text\": {\n" + 
			"          \"text\": [\n" + 
			"            \"Since 3 day you : 1 poo, 2 piss < Tu będzie odpowiedz z backendu. > Do you want to do anything else?\"\n" + 
			"          ]\n" + 
			"        }\n" + 
			"      }\n" + 
			"    ],\n" + 
			"    \"intent\": {\n" + 
			"      \"name\": \"projects/pysior/agent/intents/1890557d-b69b-40e6-bd21-f32982175c55\",\n" + 
			"      \"displayName\": \"check_history\"\n" + 
			"    },\n" + 
			"    \"intentDetectionConfidence\": 1,\n" + 
			"    \"languageCode\": \"en\"\n" + 
			"  },\n" + 
			"  \"originalDetectIntentRequest\": {\n" + 
			"    \"payload\": {}\n" + 
			"  },\n" + 
			"  \"session\": \"projects/pysior/agent/sessions/a4dd63e1-caec-f42a-3a5c-2e99f3e3632a\"\n" + 
			"}";
	
	
	private ToiletActivityHistory toiletActivityHistory;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
//
		}

}
