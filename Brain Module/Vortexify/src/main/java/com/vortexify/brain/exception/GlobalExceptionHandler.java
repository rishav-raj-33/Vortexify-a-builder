package com.vortexify.brain.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vortexify.brain.payloads.DeploymentResponseFailed;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DeploymentFailedException.class)
	public ResponseEntity<DeploymentResponseFailed> ioException(DeploymentFailedException e){	
		return new ResponseEntity<>(new DeploymentResponseFailed("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
