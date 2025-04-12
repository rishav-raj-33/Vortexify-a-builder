package com.vortexify.brain.exception;

public class DeploymentFailedException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	String resouceName;
	int fieldValue;
	String fieldName;
	public DeploymentFailedException(String resouceName, String fieldName, int fieldValue) {
		super(String.format("%s not found with %s :%s",resouceName,fieldName,fieldValue));
		this.resouceName = resouceName;
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}
	
	
	

}
