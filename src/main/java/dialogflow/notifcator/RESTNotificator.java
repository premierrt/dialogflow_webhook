package dialogflow.notifcator;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="notification.type", havingValue="REST")
public class RESTNotificator implements Notifier {

	@Override
	public void send() {
		// TODO Auto-generated method stub

	}

}
