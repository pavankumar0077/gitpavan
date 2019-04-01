package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw = null;
		String name = null;
		String tage = null;
		String vstatus = null;
		int age = 0;
		//get Print Writer
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data from the form components of form page
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		
		vstatus = req.getParameter("vflag"); //get client side validation status
		if(vstatus.equals("no")) //if client side validation arenot done
			{
			//Server form validation
			if(name.equals("")|| name == null|| name.length()==0)//required rule
			{
				pw.println("<font color:'red'> Person name is mandatory </font>");
				return;
			}
			if(tage.equals("")||tage==null||tage.length()==0)//required rule
			{
				pw.println("<font color:'green'> person age is mandatory </font>");
				return;
			}
			else//to check wheather age is numberic value or not
			{
				try {
					//convert givent age value to numberic value
					age=Integer.parseInt(tage);
				}
				catch(NumberFormatException nfe)
				{
					pw.println("<font color:'red'> Age must be numeric value </font>");
				}
			}//else
			System.out.println("Server side validations completed");
			}//if
		else {//when client side form validation are done
			age = Integer.parseInt(tage);
		}
		
		
		//write request processsing logic
		if(age>=18)
			pw.println("<h1><font color:'green'>"+name+" u r elgible to vote </font></h1>");
		else
			pw.println("<h1><font color:'red'>"+name+" u r not elgible to vote </font></h1>");
		//add graphical hyperlink 
		pw.println("<br><br> <a href='input.html'><img src='tips.gif' width='100' height='100'></a>");
		//close stream
		pw.close();
	}//doGet
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		System.out.println("VoterServlet:doPost(-,-)");
		doGet(req,res);
	}
}//class

		