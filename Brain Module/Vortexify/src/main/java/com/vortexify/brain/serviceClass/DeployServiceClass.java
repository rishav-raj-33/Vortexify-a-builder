package com.vortexify.brain.serviceClass;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.service.DeployService;
import com.vortexify.brain.service.EntityService;
import com.vortexify.brain.service.TriggerService;


@Service
public class DeployServiceClass implements DeployService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TriggerService triggerService;
	@Autowired
	private EntityService entityService;
	
	private Logger log=LoggerFactory.getLogger(DeployServiceClass.class);
	
	
	
	public DeploymentSuccessResponse deploy(Request request) throws DeploymentFailedException, IOException, InterruptedException {
		
		if (!isPublic(request.getUrl())) throw new DeploymentFailedException("Git Hub Repo may be Private or Can't be Accessed");
		
		triggerService.cloneRepo(request.getUrl());
		triggerService.buildDockerImage("?");  //path needs to be passed
		triggerService.copyImage("?");  //hostName needs to be passed
		triggerService.deployDockerImage("?",request.getUserId());  //hostName and userId needs to be passed
		DeploymentSuccessResponse response=entityService.getDeployInfo(request);
		return response;
	}
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------
	
	private boolean isPublic(String url) {
		ResponseEntity<String> response;
		
		
		try {
			response = restTemplate.getForEntity(url, String.class);
			
		} catch(Exception e) {
			log.error("Exception Occur During Accessing Git Hub Repo", e);
			return false;
			
		}

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            if (responseBody != null && responseBody.contains("\"private\":true")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
	}






	@Override
	public DeploymentSuccessResponse stop(Request request)
			throws DeploymentFailedException, IOException, InterruptedException {
		
		//need DeploymentService to get the ContainerID here.
		
		
		triggerService.stopContainer("?", "?");  //hostName //containerId need to be passed
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	
	
	
	
	
	
	
	
	
}
