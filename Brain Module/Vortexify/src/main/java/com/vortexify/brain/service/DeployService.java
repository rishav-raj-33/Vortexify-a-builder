package com.vortexify.brain.service;

import java.io.IOException;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;


public interface DeployService {
	
	
	DeploymentSuccessResponse deploy(Request request) throws DeploymentFailedException, IOException, InterruptedException;

	
	 DeploymentSuccessResponse stop(Request request) throws DeploymentFailedException, IOException,InterruptedException;
	 DeploymentSuccessResponse start(Request request) throws DeploymentFailedException, IOException,InterruptedException;
	
	 void remove(Request request) throws DeploymentFailedException, IOException,InterruptedException;
	
	
	 boolean removeUser(Long userId)throws DeploymentFailedException, IOException, InterruptedException;
	 
}
