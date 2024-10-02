package org.jsp.EventManagementSystem.responcestructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponceStructure<T> {

	private int status;
	private String message;
	private T body;
}
