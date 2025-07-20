package com.vortexify.brain.service;

import java.io.IOException;

public interface FileService {

	boolean deleteLocalFiles(String name);
	
	 boolean deleteFolder(String folderPath) throws IOException;
	
	
}
