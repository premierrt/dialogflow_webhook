package dialogflow.simple_post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//https://www.quora.com/Can-I-fetch-a-JSON-object-in-my-spring-controller-without-using-a-model-object
@Slf4j
@RestController
public class SimplePostAsStringController {

	@PostMapping
	public ResponseEntity<?> processDialogFlowPost(@RequestBody String json){
	
		log.info("--------- "+json );
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
