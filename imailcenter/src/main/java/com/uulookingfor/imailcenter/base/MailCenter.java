package com.uulookingfor.imailcenter.base;

import java.util.List;

import com.uulookingfor.imailcenter.base.exception.MailException;

/**
 * @author suxiong.sx
 */
public interface MailCenter {
	
	void init();
	
	boolean send(MailContent mContent, String whoSend, List<String> whoRecv) throws MailException;
	
}