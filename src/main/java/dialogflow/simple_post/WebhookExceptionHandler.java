
package dialogflow.simple_post;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebhookExceptionHandler {
//http://appsdeveloperblog.com/handle-exceptions-spring-boot/
	@ExceptionHandler(value={IntentProcessingException.class})
	public ResponseEntity<?> handleIntentProcessingException(IntentProcessingException ex, WebRequest req){
        return new ResponseEntity<>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
	}
}
