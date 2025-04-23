package com.vortexify.brain.config;

public class AppConstants {
	
	
	public static enum DEPLOYMENTSTATUS{
	    START,
	    SUCCESS,
	    FAILED,
	    STOP
	};
	
	public static final String HOSTNAME="192.168.18.128";
	public static final String USER_NAME="dev";
	public static final String PASSWORD="root";
	public static final String CLONE_DIR="D:\\Learning space\\Projects\\Vortexify-Parent\\Branch-Brain Module\\Heart Module\\python scripts\\Resource\\Clone\\";
	public static final String TAR_DIR="D:\\Learning space\\Projects\\Vortexify-Parent\\Branch-Brain Module\\Heart Module\\python scripts\\Resource\\Docker-Images\\";
	public static final String SCRIPT_DIR="D:\\Learning space\\Projects\\Vortexify-Parent\\Branch-Brain Module\\Heart Module\\python scripts\\";
	public static final String CLONE_SCRIPT="clone.py";
	public static final String BUILD_DOCKER_SCRIPT="buildDocker.py";
	public static final String DEPLOY_SCRIPT="deploy.py";
	public static final String STOP_SCRIPT="stopContainer.py";
	public static final String REMOVE_DEPLOY_SCRIPT="removeDeploy.py";
	public static final String REMOVE_IMAGE_LOCALLY="removeImage.py";
	public static final String START_SCRIPT="start.py";
	

	
	
	
}
