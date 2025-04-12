package com.vortexify.brain.exception;



import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vortexify.brain.payloads.DeploymentResponseFailed;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DeploymentFailedException.class)
	public ResponseEntity<DeploymentResponseFailed> deployFailed(DeploymentFailedException e){	
		return new ResponseEntity<>(new DeploymentResponseFailed("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<DeploymentResponseFailed> ioException(IOException e){	
		return new ResponseEntity<>(new DeploymentResponseFailed("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(InterruptedException.class)
	public ResponseEntity<DeploymentResponseFailed> interruptedException(InterruptedException e){	
		return new ResponseEntity<>(new DeploymentResponseFailed("Reason: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
