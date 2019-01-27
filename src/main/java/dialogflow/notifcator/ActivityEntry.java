package dialogflow.notifcator;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class ActivityEntry {

	private Long id;
	
	private Long userID;
	
	private String name;
	
	private String activity;
	
	private String Amount;
	
	private Timestamp timestamp;
}