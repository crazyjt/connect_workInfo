package com.jt.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class WorkerException extends Exception {
	

	public WorkerException() {
		super();
	}
	
	public WorkerException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkerException(String msg) {
		super(msg);
		System.out.println("3333333");
	}
	
	public WorkerException(Throwable cause) {
		super(cause);
	}

}
