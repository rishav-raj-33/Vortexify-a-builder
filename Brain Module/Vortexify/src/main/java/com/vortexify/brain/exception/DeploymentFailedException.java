package com.vortexify.brain.exception;

public class DeploymentFailedException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	String errorMsg;
	
	public DeploymentFailedException(String errorMsg) {
		this.errorMsg=errorMsg;
	}
	
	
	

}
