package dialogflow;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToiletActivityRaportTest {

	private static final String jsonObject ="{\n" + 
			"\"responseId\": \"8ea8fb2f-cd43-41a9-9df6-cbd3612ad1df\",\n" + 
			"\"queryResult\": {\n" + 
			"  \"queryText\": \"a lot of\",\n" + 
			"  \"parameters\": {\n" + 
			"    \"amount\": \"big\",\n" + 
			"    \"toilet_activity\": \"piss\"\n" + 
			"  },\n" + 
			"  \"allRequiredParamsPresent\": true,\n" + 
			"  \"fulfillmentText\": \"Good job! You did big piss. Do you want to share more info about you toilet activity?\",\n" + 
			"  \"fulfillmentMessages\": [{\n" + 
			"    \"text\": {\n" + 
			"      \"text\": [\"Good job! You did big piss. Do you want to share more info about you toilet activity?\"]\n" + 
			"    }\n" + 
			"  }],\n" + 
			"  \"outputContexts\": [{\n" + 
			"    \"name\": \"projects/pysior/agent/sessions/5e75f2f9-844c-28e3-88cf-afa504f8a8de/contexts/toilet-followup\",\n" + 
			"    \"lifespanCount\": 2,\n" + 
			"    \"parameters\": {\n" + 
			"      \"amount\": \"big\",\n" + 
			"      \"toilet_activity.original\": \"pissed\",\n" + 
			"      \"toilet_activity\": \"piss\",\n" + 
			"      \"amount.original\": \"a lot\"\n" + 
			"    }\n" + 
			"  }, {\n" + 
			"    \"name\": \"projects/pysior/agent/sessions/5e75f2f9-844c-28e3-88cf-afa504f8a8de/contexts/toilet-followup-2\",\n" + 
			"    \"lifespanCount\": 2,\n" + 
			"    \"parameters\": {\n" + 
			"      \"amount\": \"big\",\n" + 
			"      \"toilet_activity.original\": \"pissed\",\n" + 
			"      \"toilet_activity\": \"piss\",\n" + 
			"      \"amount.original\": \"a lot\"\n" + 
			"    }\n" + 
			"  }],\n" + 
			"\"intent\": {\n" + 
			"    \"name\": \"projects/pysior/agent/intents/cb8fae01-09fd-416e-8976-1d444b125d38\",\n" + 
			"    \"displayName\": \"toilet\"\n" + 
			"  },\n" + 
			"  \"intentDetectionConfidence\": 1.0,\n" + 
			"  \"languageCode\": \"en\"\n" + 
			"},\n" + 
			"\"originalDetectIntentRequest\": {\n" + 
			"  \"payload\": {\n" + 
			"  }\n" + 
			"},\n" + 
			"\"session\": \"projects/pysior/agent/sessions/5e75f2f9-844c-28e3-88cf-afa504f8a8de\"\n" + 
			"2019-01-20T17:19:32.258840+00:00 app[web.1]: }";
	
	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
