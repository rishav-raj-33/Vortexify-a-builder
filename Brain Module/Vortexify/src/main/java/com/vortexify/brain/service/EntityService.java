package com.vortexify.brain.service;

import java.util.List;

import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;


public interface EntityService {

	boolean storeInfo(Deployment deployment);
	boolean deleteInfo(Request stopRequest);
	boolean updateInfo(Deployment deployment, Request request);
	List<DeploymentSuccessResponse> getDeploymentInfo(Long userId);
    DeploymentSuccessResponse getDeployInfo(Request request);	
	
}
