package com.uulookingfor.imailcenter.base.impl;

import com.uulookingfor.imailcenter.base.MailContent;

/**
 * @author suxiong.sx
 */
public class DefaultMailContent implements MailContent{

	private String title = "";
	
	private String body = "";
	
	
	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public void putTitleToContent(String title) {
		this.title = title;
	}

	public void putBodyToContent(String body) {
		this.body = body;
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		sb.append("title:" + title + ",");
		sb.append("body:" + body + ",");
		sb.append("]");
		
		return sb.toString();
		
	}

	public void init() {
		
	}

	
	
}
