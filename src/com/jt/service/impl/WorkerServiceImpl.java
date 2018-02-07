package com.jt.service.impl;

import com.jt.dao.WorkerDao;
import com.jt.dao.impl.WorkerDaoImpl;
import com.jt.domain.Worker;
import com.jt.exception.WorkerException;
import com.jt.exception.WorkerExistException;
import com.jt.service.WorkerService;

public class WorkerServiceImpl implements WorkerService {

	WorkerDao workDao = new WorkerDaoImpl();
	
	
	@Override
	public void register(Worker worker) throws Exception {
		workDao.addWorker(worker);
	}
	@Override
	public Worker login(Worker worker) throws WorkerException {
		Worker worker2 = null;
		try {
			worker2 = workDao.findWorker(worker);
			System.out.println("worker2: " + worker2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (worker2 == null) {
			String msg = "用户id或密码错误!";
			throw new WorkerException(msg);
		}
		return worker2;
	}
	@Override
	public boolean registerCheck(String id) throws WorkerExistException {
		boolean exist = false;
			try {
				exist = workDao.findWorkerById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (exist) {
				throw new WorkerExistException("该用户已注册!");
			}
		return exist;
	}

}
