package dialogflow.simple_post;

import java.util.HashMap;
import java.util.Optional;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dialogflow.intentprocessing.FallbackIntentProcessor;
import dialogflow.intentprocessing.IntenetProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IntentServiceProcessorImpl implements IntentServiceProcessor {

	//do klasy abstrakcyjnej??
	private HashMap<String,IntenetProcessor> intentMapCache;
	

	@Autowired
	public IntentServiceProcessorImpl(HashMap<String, IntenetProcessor> intentMapCache) {
		super();
		this.intentMapCache = intentMapCache;
	}



	@Override
	/**
	 * https://www.testingexcellence.com/how-to-parse-json-in-java/
	 * do refaktory - obsluga bledow i zeby nie zwracal null-a. czy deklaracja objektow w metodzie na gorze?
	 * czy do serwisu nie powinien przekazac wejsciowego stringa i tam reszte przerobic?
	 * https://www.toptal.com/java/spring-boot-rest-api-error-handling
	 */
	public FullfillmentResponseDTO processIntent(JSONObject jsonObject) throws IntentProcessingException {
		
		String intent=new String();
		try {
			intent = getIntentFromJson(jsonObject);
		} catch (JSONException e) {
			throw new IntentProcessingException("Json się nie parsuje", e );
		}
		//zwraca intentProcesor na podstawie konfiguracji - przeniesc do redis
		Optional<IntenetProcessor> intenetProcessor= Optional.ofNullable( intentMapCache.get(intent));
		
		//tu zwroci null pointera jesli nie bedzie obslugi jakiegos intenta --> dodaje optionala
		//https://x-team.com/blog/using-optional-to-transform-your-java-code/
		
		return 	(intenetProcessor.orElse(new FallbackIntentProcessor())).processIntent(jsonObject); //tutaj powinien byc ze spring bean. z contextu wczytany?

		
		
	}
	

	//do klasy abstrakcyjnej??
	//zmieniam na public, zeby junit widzial. private nie widzi:
	//ew. przeniesc do klasy z helperem
	public String getIntentFromJson(JSONObject jsonObject) throws JSONException{
		JSONObject intentJsonObject = jsonObject.getJSONObject("queryResult").getJSONObject("intent");
		
		return intentJsonObject.getString("name");
		
	}
	
	
	
	
	//do klasy abstrakcyjnej?? 
	private IntenetProcessor getIntentProcessor(String intentName) throws IntentProcessingException{
		return intentMapCache.entrySet().stream().filter(mapEntry -> intentName.equals(mapEntry.getKey())).findFirst().map(entry -> entry.getValue()).orElseThrow(() -> new IntentProcessingException("nie ma takiego intentu")); 
		
	}
	
	//https://stackoverflow.com/questions/14162788/combination-of-extend-abstract-class-and-implement-interface
	//przeniesc impelentacje do klasy abstrkcyjne
	private void chooseNotication(){
		
	}
	
	//https://stackoverflow.com/questions/14162788/combination-of-extend-abstract-class-and-implement-interface
	//przeniesc impelentacje do klasy abstrkcyjne
	private void chooseNotication(){
		
	}

}
