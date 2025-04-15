package com.vortexify.brain.payloads;

public class DeploymentFailedResponse {
	
	String msg;
	boolean success;
	
	public DeploymentFailedResponse(String msg, boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	

}
