package dialogflow;

public class CheckHistoryIntentTest {

	private static final String jsonObject ="{\n" + 
			"\n" + 
			"  \"responseId\": \"870978e8-1f92-4913-ad45-e814b9180c25\",\n" + 
			"\n" + 
			"  \"queryResult\": {\n" + 
			"\n" + 
			"    \"queryText\": \"5 days\",\n" + 
			"\n" + 
			"    \"parameters\": {\n" + 
			"\n" + 
			"      \"duration\": {\n" + 
			"\n" + 
			"        \"amount\": 5,\n" + 
			"\n" + 
			"        \"unit\": \"day\"\n" + 
			"\n" + 
			"      }\n" + 
			"\n" + 
			"    },\n" + 
			"\n" + 
			"    \"allRequiredParamsPresent\": true,\n" + 
			"\n" + 
			"    \"fulfillmentText\": \"Since 5 day you : 1 poo, 2 piss < Tu będzie odpowiedz z backendu. >\",\n" + 
			"\n" + 
			"    \"fulfillmentMessages\": [\n" + 
			"\n" + 
			"      {\n" + 
			"\n" + 
			"        \"text\": {\n" + 
			"\n" + 
			"          \"text\": [\n" + 
			"\n" + 
			"            \"Since 5 day you : 1 poo, 2 piss < Tu będzie odpowiedz z backendu. >\"\n" + 
			"\n" + 
			"          ]\n" + 
			"\n" + 
			"        }\n" + 
			"\n" + 
			"      }\n" + 
			"\n" + 
			"    ],\n" + 
			"\n" + 
			"    \"outputContexts\": [\n" + 
			"\n" + 
			"      {\n" + 
			"\n" + 
			"        \"name\": \"projects/pysior/agent/sessions/86f41e6e-c695-2e57-1fc8-0eb9343608cc/contexts/check_history_context\",\n" + 
			"\n" + 
			"        \"lifespanCount\": 5,\n" + 
			"\n" + 
			"        \"parameters\": {\n" + 
			"\n" + 
			"          \"duration\": {\n" + 
			"\n" + 
			"            \"amount\": 5,\n" + 
			"\n" + 
			"            \"unit\": \"day\"\n" + 
			"\n" + 
			"          },\n" + 
			"\n" + 
			"          \"duration.original\": \"5 days\"\n" + 
			"\n" + 
			"        }\n" + 
			"\n" + 
			"      }\n" + 
			"\n" + 
			"    ],\n" + 
			"\n" + 
			"    \"intent\": {\n" + 
			"\n" + 
			"      \"name\": \"projects/pysior/agent/intents/1890557d-b69b-40e6-bd21-f32982175c55\",\n" + 
			"\n" + 
			"      \"displayName\": \"check_history\"\n" + 
			"\n" + 
			"    },\n" + 
			"\n" + 
			"    \"intentDetectionConfidence\": 1,\n" + 
			"\n" + 
			"    \"languageCode\": \"en\"\n" + 
			"\n" + 
			"  }\n" + 
			"\n" + 
			"}";
	
			
	
}
