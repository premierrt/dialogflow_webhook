package dialogflow.intentprocessing;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dialogflow.notifcator.ActivityEntry;
import dialogflow.notifcator.Connector;
import dialogflow.notifcator.Notifier;
import dialogflow.notifcator.RestConnector;
import dialogflow.simple_post.FullfillmentResponseDTO;


@Component("toiletActivityHistory")
public class ToiletActivityHistory extends RestConnector implements IntenetProcessor {
//
//	@Autowired
//	Connector restConnector;
	
	@Override
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) {
		String fullFillmentResponseText= null;
		FullfillmentResponseDTO respone= new FullfillmentResponseDTO();


		// TODO Auto-generated method stub
//			//todo znajdz entity z czasem do selecta. dopisac selecta po czasie.
		//	List <ActivityEntry> lista=  restConnector.getHistory();
		List <ActivityEntry> lista=super.getHistory();
			respone.setFulfillmentText(lista.toString());
			
			return respone;
		
		}

}
