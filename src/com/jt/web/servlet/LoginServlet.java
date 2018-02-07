package com.jt.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jt.domain.Worker;
import com.jt.exception.WorkerException;
import com.jt.service.WorkerService;
import com.jt.service.impl.WorkerServiceImpl;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// ��ȡ������
		Worker worker = new Worker();
		try {
			BeanUtils.populate(worker, req.getParameterMap());
			req.setAttribute("workerBack", worker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����ҵ����
		WorkerService wService = new WorkerServiceImpl();
		Worker worker2 = null;
		try {
			worker2 = wService.login(worker);
			System.out.println("work2 in servlet: " + worker2);

			// �ж���֤��
			String code = req.getParameter("code");
			String vCode = (String) req.getSession().getAttribute("vCode");
			if (!code.equalsIgnoreCase(vCode)) {
				req.setAttribute("codeErr", "��֤�����!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}

			if (worker2 != null) {
				// ���û�����session
				req.getSession().setAttribute("worker", worker2);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		} catch (WorkerException e) {
			System.out.println("catch the exception");
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
