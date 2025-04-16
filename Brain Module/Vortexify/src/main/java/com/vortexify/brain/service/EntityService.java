package com.vortexify.brain.service;

import java.util.List;

import com.vortexify.brain.entity.Deployment;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.payloads.StopRequest;

public interface EntityService {

	boolean storeInfo(Deployment deployment);
	boolean deleteInfo(StopRequest stopRequest);
	boolean updateInfo(Deployment deployment, StopRequest request);
	List<DeploymentSuccessResponse> getDeploymentInfo(String userId);
    DeploymentSuccessResponse getDeployInfo(StopRequest request);	
	
}
