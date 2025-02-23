package com.jbd.todo.enums;

public enum Status {

	NEW("New"),
    IN_PROGRES("In_Progress"),
    COMPLETED("Completed");
	
	private final String value;

	private Status(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
