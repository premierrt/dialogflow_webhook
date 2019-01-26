package dialogflow.notifcator;

<<<<<<< HEAD
import java.util.HashMap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnProperty(name="notification.type", havingValue="AMQP")
public class AMQPNotificator implements Notifier{@Override
	public void send(HashMap<?, ?> parameters) {
		// TODO Auto-generated method stub
		
	}


=======
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
>>>>>>> branch 'notificator' of https://github.com/premierrt/dialogflow_webhook.git

}
