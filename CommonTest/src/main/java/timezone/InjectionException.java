package timezone;

public class InjectionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public InjectionException(String message) {
		super(message);
		this.message = message;
	}
}
