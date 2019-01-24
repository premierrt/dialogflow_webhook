package dialogflow.notifcator;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@ConditionalOnProperty(name="notification.type", havingValue="REST")
@Slf4j
public class RESTNotificator implements Notifier {

	@Override
	@Async
	public void send() {
		// TODO Auto-generated method stub
		
		 try {
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        //
		    }
		log.info("Execute method asynchronously. "
			      + Thread.currentThread().getName());
	}
}
