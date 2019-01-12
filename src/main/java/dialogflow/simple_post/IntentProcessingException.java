package dialogflow.simple_post;

public class IntentProcessingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 132341212L;

	public IntentProcessingException(String errorMessage){
		super(errorMessage);
	}
	
	public IntentProcessingException(String errorMessage, Throwable e){
		super(errorMessage, e);
	}
	
}
