package dialogflow.notifcator;

import java.util.HashMap;
import java.util.List;

import org.springframework.scheduling.annotation.Async;

public interface Connector {


	List<ActivityEntry> getHistory();

}