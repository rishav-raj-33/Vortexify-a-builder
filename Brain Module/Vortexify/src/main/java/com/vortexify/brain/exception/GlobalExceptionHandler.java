package com.vortexify.brain.exception;



import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vortexify.brain.payloads.DeploymentFailedResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DeploymentFailedException.class)
	public ResponseEntity<DeploymentFailedResponse> deployFailed(DeploymentFailedException e){	
		return new ResponseEntity<>(new DeploymentFailedResponse("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<DeploymentFailedResponse> ioException(IOException e){	
		return new ResponseEntity<>(new DeploymentFailedResponse("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(InterruptedException.class)
	public ResponseEntity<DeploymentFailedResponse> interruptedException(InterruptedException e){	
		return new ResponseEntity<>(new DeploymentFailedResponse("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
