package com.jt.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jt.domain.Worker;
import com.jt.domain.WorkerValidation;
import com.jt.exception.WorkerExistException;
import com.jt.service.WorkerService;
import com.jt.service.impl.WorkerServiceImpl;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//获取表单数据
		Worker worker = new Worker();
		try {
			BeanUtils.populate(worker, req.getParameterMap());
			
			//调用业务处理
			WorkerService wService = new WorkerServiceImpl();
			WorkerValidation wValidation = new WorkerValidation();
			BeanUtils.populate(wValidation, req.getParameterMap());
			if (wValidation.validate()) {
				//注册前先检查该id是否已存在
				wService.registerCheck(worker.getW_id());
				wService.register(worker);
			} else {
				System.out.println("validateErr is not empty");
				req.setAttribute("validateErr", wValidation);
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				return ;
			}
			
		} catch (WorkerExistException e) { //id若已注册则抛出异常
			req.setAttribute("existErr", e.getMessage());
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//分发转向
		PrintWriter writer = resp.getWriter();
		writer.write(worker.toString());
		writer.write("注册成功，3秒后跳回主页");
		resp.setHeader("refresh", "3,url="+req.getContextPath()+"/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
