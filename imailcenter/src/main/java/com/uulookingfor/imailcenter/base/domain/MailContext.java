package com.uulookingfor.imailcenter.base.domain;

import com.uulookingfor.imailcenter.base.MailCenter;
import com.uulookingfor.imailcenter.base.MailContent;
import com.uulookingfor.imailcenter.base.builder.VmMailBodyBuilder;
import com.uulookingfor.imailcenter.base.impl.DefaultMailCenter;
import com.uulookingfor.imailcenter.base.impl.DefaultMailContent;

/**
 * @author suxiong.sx 
 */
public interface MailContext {
	
	public static final MailCenter mailCenter = new DefaultMailCenter();
	
	public static final MailContent mailContent = new DefaultMailContent();
	
	public static final VmMailBodyBuilder vmMailBodyBuilder = new VmMailBodyBuilder();
	
}
