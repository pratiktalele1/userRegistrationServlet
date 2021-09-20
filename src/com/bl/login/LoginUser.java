package com.bl.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUser extends HttpServlet {
	public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		String name = httpServletRequest.getParameter("userName");
		PrintWriter printWriter = httpServletResponse.getWriter();
		System.out.println("");
		String password = httpServletRequest.getParameter("password");
		System.out.println("");

		Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]");
		Matcher matcher = pattern.matcher(name);

		Pattern pattern2 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$");
		Matcher matcher2 = pattern2.matcher(password);

		int flag = 0;
		while (matcher.find()) {
			flag = 1;
		}

		int flag2 = 0;
		while (matcher2.find()) {
			flag = 1;
		}

//		if (flag == 1 && flag2 == 1) {
//			System.out.println("valid username");
			if (name.equalsIgnoreCase("Pratik")) {
				printWriter.println("<font color=green><h1>login succesful</h1></font>");

			} else {
				printWriter.println("<font color=red><h1>login failed</h1></font>");
			}
//		} else {
//			System.out.println("invalid details");
//		}

	}
}
