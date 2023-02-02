package fr.eni.ecole.encheres;

import java.util.ArrayList;

public class BusinessException extends Exception{
	private final ArrayList<String> exceptionMessages = new ArrayList<>();
	public BusinessException() {
	}

	public BusinessException(String message) {
		exceptionMessages.add(message);
	}
	public void addExceptionMessage(String message){
		exceptionMessages.add(message);
	}
	public ArrayList<String> getExceptionMessages(){
		return exceptionMessages;
	}
}
