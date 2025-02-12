package com.Techforge.SheildSpring.DTO;

public class ErrorResponse {
	
	private String message;
	
	private int status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + "]";
	}
	
	

}
