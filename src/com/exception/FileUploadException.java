package com.exception;

public class FileUploadException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public FileUploadException(String message) {
		super();
		this.message = message;

	

}
}
