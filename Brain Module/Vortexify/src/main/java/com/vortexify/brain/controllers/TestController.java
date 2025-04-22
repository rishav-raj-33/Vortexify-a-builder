package com.vortexify.brain.controllers;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexify.brain.exception.DeploymentFailedException;
import com.vortexify.brain.payloads.Request;
import com.vortexify.brain.service.TriggerService;


@RestController
@RequestMapping("api/test")
public class TestController {

	@Autowired
	private TriggerService triggerService;
	
	
	
	@GetMapping("/clone/")
	public ResponseEntity<Boolean> testClone(@RequestBody Request url) throws DeploymentFailedException, IOException, InterruptedException{
		 boolean success=this.triggerService.cloneRepo(url.getUrl());
		 return new ResponseEntity<>(success,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/build/{name}")
	public ResponseEntity<Boolean> buildImageTest(@PathVariable String name) throws DeploymentFailedException, IOException, InterruptedException{
		boolean sucess=this.triggerService.buildDockerImage(name);
		return new ResponseEntity<>(sucess,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/deploy/{name}")
	public ResponseEntity<Boolean> deployTest(@PathVariable String name) throws DeploymentFailedException, IOException, InterruptedException{
		boolean sucess=this.triggerService.deployDockerImage(name, 1L);
		return new ResponseEntity<>(sucess,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/stop/{containerId}")
	public ResponseEntity<Boolean> stopContainerTest(@PathVariable String containerId) throws DeploymentFailedException, IOException, InterruptedException{
		boolean sucess=this.triggerService.stopContainer(containerId);
		return new ResponseEntity<>(sucess,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/stop/{containerId}/{imageId}")
	public ResponseEntity<Boolean> removeTest(@PathVariable String containerId,@PathVariable String imageId) throws DeploymentFailedException, IOException, InterruptedException{
		boolean sucess=this.triggerService.removeImage(imageId, containerId);
		return new ResponseEntity<>(sucess,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}

