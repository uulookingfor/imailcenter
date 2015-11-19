package com.uulookingfor.imailcenter.base.impl;

import java.util.Collection;
import java.util.List;

import lombok.NonNull;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.uulookingfor.imailcenter.base.MailCenter;
import com.uulookingfor.imailcenter.base.MailContent;
import com.uulookingfor.imailcenter.base.domain.MailConstants;
import com.uulookingfor.imailcenter.base.exception.MailException;

/**
 * @author suxiong.sx
 */
public class DefaultMailCenter implements MailCenter, MailConstants{
	
	public boolean send(
			@NonNull MailContent mContent, 
			@NonNull String whoSend, 
			@NonNull List<String> whoRecv) throws MailException {
		
		HtmlEmail mail = initHtml();
		
		handleWhoRecv(whoRecv, mail);
		
		handleWhoSend(whoSend, mail);
		
		handleContent(mContent, mail);
		
		send(mail);
		
		return true;
	}

	public HtmlEmail initHtml() throws MailException {
		
		HtmlEmail htmlEmail = new HtmlEmail();
		
		htmlEmail.setHostName(mailHostName);
		htmlEmail.setSmtpPort(smtpPort);
		htmlEmail.setAuthenticator(new DefaultAuthenticator(authenticatorName, authenticatorPasswd));;
		htmlEmail.setSSLOnConnect(sslOnConnect);
		
		
		htmlEmail.setCharset(charset);
		
		return htmlEmail;
	}
	
	private void handleWhoRecv(List<String> whoRecv, HtmlEmail htmlEmail) throws MailException{
		
		for(String who : whoRecv){
			if(emptyStr(who)){
				continue;
			}
			
			try {
				htmlEmail.addTo(who);
			} catch (EmailException e) {
				throw new MailException("set param recv list exception, who:" + who, e);
			}
		}
		
		if(emptyCollection(htmlEmail.getToAddresses())){
			throw new MailException("who recv list empty:" + whoRecv);
		}
		
	}
	
	private void handleWhoSend(String whoSend, HtmlEmail htmlEmail) throws MailException{
		
		if(emptyStr(whoSend)){
			throw new MailException("who send empty");
		}
		
		try {
			htmlEmail.setFrom(whoSend);
		} catch (EmailException e) {
			throw new MailException("set send from exception, who:" + whoSend, e);
		}
	}
	
	private void handleContent(MailContent mContent, HtmlEmail htmlEmail) throws MailException{
		//title
		htmlEmail.setSubject(mContent.getTitle());  
		
		//body
		try {
			htmlEmail.setHtmlMsg(mContent.getBody());
		} catch (EmailException e) {
			throw new MailException("set htmlmsg exception", e);
		}
		
	}
	
	private void send(HtmlEmail htmlEmail)  throws MailException{
		try {
			htmlEmail.send();
		} catch (EmailException e) {
			throw new MailException("mail send exception", e);
		}
	}
	
	private static boolean emptyStr(String str){
		
		if(str == null){
			return true;
		}
		
		if("".equals(str)){
			return true;
		}
		
		if("".equals(str.trim())){
			return true;
		}
		
		return false;
	}
	
	private static boolean emptyCollection(Collection<?> col){
		
		if(col == null){
			return true;
		}
		
		if(col.size() == 0){
			return true;
		}
		
		return false;
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	

}
