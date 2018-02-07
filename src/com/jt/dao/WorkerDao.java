package com.jt.dao;

import com.jt.domain.Worker;


public interface WorkerDao {
	/**
	 * 添加员工信息
	 * @param worker
	 * @throws Exception
	 */
	public void addWorker(Worker worker) throws Exception;
	
	/**
	 * 查找员工信息
	 * @param worker
	 * @return
	 * @throws Exception
	 */
	public Worker findWorker(Worker worker) throws Exception;
	
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean findWorkerById(String id) throws Exception;
}
