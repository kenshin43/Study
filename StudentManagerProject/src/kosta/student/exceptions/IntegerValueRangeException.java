package kosta.student.exceptions;

public class IntegerValueRangeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntegerValueRangeException() {
	}

	public IntegerValueRangeException(String message) {
		super(message);
	}
}
