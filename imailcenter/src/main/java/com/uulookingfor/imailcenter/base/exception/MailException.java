package com.uulookingfor.imailcenter.base.exception;

/**
 * @author suxiong.sx
 */
public class MailException extends Exception{

	private static final long serialVersionUID = 8904492733013056741L;

	public MailException(){
		super();
	}
	
	public MailException(String message){
		super(message);
	}
	
	public MailException(String message, Throwable cause){
		super(message, cause);
	}
	
	public MailException(Throwable cause){
		super(cause);
	}
}
