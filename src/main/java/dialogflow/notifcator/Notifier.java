package dialogflow.notifcator;

import java.util.HashMap;

/**
 * https://www.romaniancoder.com/spring-conditional-bean-configuration-load-beans-based-application-properties-file/
 * @author rafal
 *
 */

//to do - notyfikator jako osobny modul
public interface Notifier {
	//pewnie to bedzie jakis dto do wyslania - watosci entity
	public void send(HashMap<?, ?> parameters);
}
