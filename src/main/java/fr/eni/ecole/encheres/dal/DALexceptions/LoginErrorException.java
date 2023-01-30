package fr.eni.ecole.encheres.dal.DALexceptions;

public class LoginErrorException extends Exception {
	public LoginErrorException() {
	}

	public LoginErrorException(String message) {
		super(message);
	}

	public LoginErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginErrorException(Throwable cause) {
		super(cause);
	}
}
