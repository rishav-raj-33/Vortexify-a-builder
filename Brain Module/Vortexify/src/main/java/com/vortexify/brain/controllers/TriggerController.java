package com.vortexify.brain.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.service.DeployService;

@RestController
@RequestMapping("/api/service")
public class TriggerController {
	
	@Autowired
	private DeployService service;

	
	@PostMapping("/deploy")
	public ResponseEntity<DeploymentSuccessResponse> deploy(@RequestBody Request request) throws DeploymentFailedException, IOException, InterruptedException{
		return new ResponseEntity<>(service.deploy(request),HttpStatus.CREATED);	
	}
	
	
	@PostMapping("/stop")
	public ResponseEntity<DeploymentSuccessResponse> stop(@RequestBody Request request) throws DeploymentFailedException, IOException, InterruptedException{
		return new ResponseEntity<>(service.stop(request),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/remove")
	public ResponseEntity<Boolean> remove(@RequestBody Request request) throws DeploymentFailedException, IOException, InterruptedException{
		service.remove(request);
		return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}
