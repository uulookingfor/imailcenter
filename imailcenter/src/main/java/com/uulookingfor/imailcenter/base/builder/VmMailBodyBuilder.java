package com.uulookingfor.imailcenter.base.builder;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;

import com.uulookingfor.imailcenter.base.domain.MailConstants;

import lombok.NonNull;

public class VmMailBodyBuilder implements MailConstants{
	
	private static VelocityEngine velocityEngine = new VelocityEngine();
	
	private boolean inited = false;
	
	public String build(@NonNull String vmFilePath, @NonNull Map<String, String> model){
		
		StringWriter result = new StringWriter();
		VelocityContext velocityContext = new VelocityContext(model);
		
		try{
			velocityEngine.mergeTemplate(vmFilePath, charset, velocityContext, result);
		}catch (VelocityException ex) {
			throw ex;
		}catch (RuntimeException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new VelocityException(ex.toString());
		}
		
		return result.toString();
	}

	public String classLoaderFilePath(@NonNull String fileName){
		return VmMailBodyBuilder.class.getClassLoader().getResource(fileName).getPath();
	}
	
	
	public void init() {
		
		if(inited){
			return;
		}
		
		velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "");
		velocityEngine.init();
		
		inited = true;
	}
}
