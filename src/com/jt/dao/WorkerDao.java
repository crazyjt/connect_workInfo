package com.jt.dao;

import com.jt.domain.Worker;


public interface WorkerDao {
	/**
	 * ���Ա����Ϣ
	 * @param worker
	 * @throws Exception
	 */
	public void addWorker(Worker worker) throws Exception;
	
	/**
	 * ����Ա����Ϣ
	 * @param worker
	 * @return
	 * @throws Exception
	 */
	public Worker findWorker(Worker worker) throws Exception;
	
	/**
	 * ͨ��id�����û�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean findWorkerById(String id) throws Exception;
}
