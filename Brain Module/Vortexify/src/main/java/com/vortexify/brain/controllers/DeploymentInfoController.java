package com.vortexify.brain.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.DeploymentSuccessResponse;
import com.vortexify.brain.service.DeployService;
import com.vortexify.brain.service.EntityService;

@RestController
@RequestMapping("/api/user")
public class DeploymentInfoController {
 
	@Autowired
	private EntityService service;
	
	@Autowired
	private DeployService deployServive;
	
	@GetMapping("/{userId")
	public ResponseEntity<List<DeploymentSuccessResponse>> getAll(@PathVariable Long userId){
		return new ResponseEntity<>(service.getDeploymentInfo(userId),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{liveLink}")
	public ResponseEntity<DeploymentSuccessResponse> getDeployment(@PathVariable String liveLink){
		return new ResponseEntity<>(service.getDeploymentInfo(liveLink),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> removeUser(@PathVariable Long userId) throws DeploymentFailedException, IOException, InterruptedException{
		return new ResponseEntity<>(deployServive.removeUser(userId),HttpStatus.ACCEPTED);
	}
	
	
}
