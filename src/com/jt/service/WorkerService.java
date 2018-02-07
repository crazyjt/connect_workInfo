package com.jt.service;

import com.jt.domain.Worker;
import com.jt.exception.WorkerException;
import com.jt.exception.WorkerExistException;

public interface WorkerService {
	public void register(Worker worker) throws Exception;
	public Worker login(Worker worker) throws WorkerException;
	public boolean registerCheck(String id) throws WorkerExistException;
}
