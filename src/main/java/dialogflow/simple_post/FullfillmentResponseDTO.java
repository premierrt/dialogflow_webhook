package dialogflow.simple_post;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//https://www.baeldung.com/jackson-ignore-properties-on-serialization
@Data
public class FullfillmentResponseDTO {

	
	private String fulfillmentText;
	
	@JsonIgnore
	private String input;
}
