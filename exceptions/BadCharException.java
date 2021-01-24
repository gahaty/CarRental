package exceptions;

public class BadCharException extends Exception {

	private static final long serialVersionUID = -3626629523081999483L;

	public BadCharException() {
		super();
	}

	@Override
	public String getMessage() {
		return "Hibás adatbevitel!";
	}
}