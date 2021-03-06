package dialogflow;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


import dialogflow.intentprocessing.IntenetProcessor;
import dialogflow.intentprocessing.ToiletIntentProcessor;
import dialogflow.notifcator.RestMongoNotificator;
import dialogflow.simple_post.IntentProcessingException;
import dialogflow.simple_post.IntentServiceProcessorImpl;

@RunWith(MockitoJUnitRunner.class)
public class IntentServiceTest {

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
	
	private final static String responseText = "Done! Saved your toilet raport. pee amount a lot of przerobiony w backendzie";
	private JSONObject json ;
	private JSONObject jsonNotOK;
	private final static String intentName="projects/jokes-df111/agent/intents/19455d90-8a5b-40cb-8403-69ee0c1e143c";
	private final static String intentFallbackText="Fallback z backendu - nie ma takiego intentu!";
	
	
	@Mock
	private HashMap<String,IntenetProcessor> intentMapCacheMock;
  
	
	@Mock
	private RestMongoNotificator restMongoNotificatorMock;
	
	@InjectMocks
	private IntentServiceProcessorImpl intentServiceProcessorImpl;


	
	@Before
	public void setUp() throws Exception {
		
	//	intentServiceProcessorImpl = new IntentServiceProcessorImpl(intentMapCacheMock);
		 json = new JSONObject(jsonString.toString());
	}
	

	@Test
	public void test() throws IntentProcessingException {
		//mocikto
		//http://www.vogella.com/tutorials/Mockito/article.html
			when (intentMapCacheMock.get(anyString())).thenReturn(new ToiletIntentProcessor());	
			doNothing().when(restMongoNotificatorMock).sendJson(anyString());

			assertThat(intentServiceProcessorImpl.processIntent(json).getFulfillmentText(), is(responseText));
	
	}
	
	@Test
	public void testGetIntentFromJson() throws JSONException {
		assertThat(intentServiceProcessorImpl.getIntentFromJson(json) , is(intentName));
	}
	
	@Test
	public void testNoIntent() throws IntentProcessingException{
		doNothing().when(restMongoNotificatorMock).sendJson(anyString());

		assertThat(intentServiceProcessorImpl.processIntent(json).getFulfillmentText(), is(intentFallbackText));

	}
	
}
