package com.jt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jt.dao.WorkerDao;
import com.jt.domain.Worker;
import com.jt.utils.DBUtils;

public class WorkerDaoImpl implements WorkerDao {

	@Override
	public void addWorker(Worker worker) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into worker values(?,?,?,?,?,?)");
			ps.setString(1, worker.getW_id());
			ps.setString(2, worker.getW_password());
			ps.setString(3, worker.getW_name());
			ps.setString(4, worker.getW_type());
			ps.setString(5, worker.getW_sex());
			ps.setFloat(6, worker.getW_workTime());
			
			int i = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ÃÌº” ß∞‹");
		} finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
	}

	@Override
	public Worker findWorker(Worker worker) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Worker worker2 = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from worker where w_id=? and w_password=?");
			ps.setString(1, worker.getW_id());
			ps.setString(2, worker.getW_password());
			rs = ps.executeQuery();
			if (rs.next()) {
				worker2 = new Worker(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getFloat(6));
				System.out.println("worker2: " + worker2.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return worker2;
	}

	@Override
	public boolean findWorkerById(String id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from worker where w_id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}

}
