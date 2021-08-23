package com.mindtree.exception;

import java.util.Date;

public class ErrorMessage {

		private Date timeStamp;
		private String message;
		private String errorCode;
		private String details;
		
		public ErrorMessage() {
			super();
			
		}
		public ErrorMessage(Date timeStamp, String message, String errorCode, String details) {
			super();
			this.timeStamp = timeStamp;
			this.message = message;
			this.errorCode = errorCode;
			this.details = details;
		}
		public Date getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(Date timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		
		
		
}