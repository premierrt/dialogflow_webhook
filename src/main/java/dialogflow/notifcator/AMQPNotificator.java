package dialogflow.notifcator;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnProperty(name="notification.type", havingValue="AMQP")
public class AMQPNotificator implements Notifier{

	@Override
	public void send() {
			// TODO Auto-generated method stub
		log.info("AMQP Notyfikator");
	}

}
