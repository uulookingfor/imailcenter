package com.uulookingfor.imailcenter.base;

/**
 * @author suxiong.sx
 */
public interface MailContent {
	
	void init();
	
	String getTitle();
	
	String getBody();
	
	void putTitleToContent(String title);
	
	void putBodyToContent(String body);
	
}
