package shop.co.uk.web;

public class ErrorResponse {
	private int errorCode;
	private String message;
	
	private ErrorResponse(){}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static ErrorResponse createError(String message, int errorCode) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(message);
		error.setErrorCode(errorCode);
		return error;
	}
}
