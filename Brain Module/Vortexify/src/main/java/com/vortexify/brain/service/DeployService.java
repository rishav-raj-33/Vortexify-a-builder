package com.vortexify.brain.service;

import java.io.IOException;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.DeployRequest;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.payloads.StopRequest;

public interface DeployService {
	
	
	DeploymentSuccessResponse deploy(DeployRequest request) throws DeploymentFailedException, IOException, InterruptedException;

	
	public DeploymentSuccessResponse stop(StopRequest request) throws DeploymentFailedException, IOException,InterruptedException;
}
