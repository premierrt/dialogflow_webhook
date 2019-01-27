package dialogflow.intentprocessing;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dialogflow.notifcator.Notifier;
import dialogflow.notifcator.RESTNotificator;
import dialogflow.simple_post.FullfillmentResponseDTO;
import dialogflow.simple_post.IntentServiceProcessorImpl;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class ToiletActivityRaport implements IntenetProcessor {
	
	//do zmiany do konstuktora
	
	
	Notifier rESTNotificator;

	@Autowired
	public ToiletActivityRaport(@Qualifier("rESTNotificator") Notifier rESTNotificator) {
		super();
		this.rESTNotificator = rESTNotificator;
	}


	@Override
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) {
		String toiletActivity = null;
		String amount = null;
		String fullFillmentResponseText= null;
		
		FullfillmentResponseDTO respone= new FullfillmentResponseDTO();
		log.info(IntentServiceProcessorImpl.class + " ===================== "+jsonObject.toString() );
		
		
		
		try {
			JSONObject queryResult = jsonObject.getJSONObject("queryResult");
			if (queryResult.getBoolean("allRequiredParamsPresent")){
				JSONObject params =queryResult.getJSONObject("parameters");
				amount= params.getString("amount");
				toiletActivity=params.getString("toilet_activity");
				sendNotification(toiletActivity, amount);
				fullFillmentResponseText=queryResult.getString("fulfillmentText").
						concat(" przerobiony w backendzie.zapialem "+toiletActivity + " "+amount);
				
				
			}
			else{
				fullFillmentResponseText="Nic nie zapisałem w backend, bo brakowalo parametrow";
			}
				
			respone.setFulfillmentText(fullFillmentResponseText  );
			
		} catch (JSONException e) {
			throw new RuntimeException("Json się nie parsuje", e );
		}
		
		return respone;
	}

	
	public void sendNotification(String activity,  String amount){
		log.info("+++++++++++++++zapisuje do bazy parametry id + "  +activity + " " + amount);
		log.info("Wywolania asynchroniczne. "
			      + Thread.currentThread().getName());
		HashMap<String, String> map = new HashMap<>();
		map.put("activity", activity);
		map.put("amount", amount);
		rESTNotificator.send(map);
		
	}
}


