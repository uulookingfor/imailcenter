package com.uulookingfor.imailcenter.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.uulookingfor.imailcenter.base.domain.MailConstants;
import com.uulookingfor.imailcenter.base.domain.MailContext;
import com.uulookingfor.imailcenter.base.exception.MailException;

/**
 * @author suxiong.sx 
 */
public class Main implements MailConstants, MailContext{
	
	public static void main(String[] args) throws MailException{

		mailCenter.init();
		
		mailContent.init();
		
		vmMailBodyBuilder.init();
		
		Map<String, String> model = new HashMap<String, String>();
		
		model.put("head1", "This is head1");
		model.put("head2", "This is head2");
		model.put("par", "This para");
		
		String body = vmMailBodyBuilder.build(
				vmMailBodyBuilder.classLoaderFilePath("example.vm"), model);
		
		mailContent.putTitleToContent("This is title of mail");
		mailContent.putBodyToContent(body);
		
		mailCenter.send(mailContent, authenticatorName, Arrays.asList("it006008@163.com"));
		
		System.out.println("done");
		
	}
}
