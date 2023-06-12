package com.example.war.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String error) {
		super(error);
	}

}
