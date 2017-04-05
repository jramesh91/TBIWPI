package com.javatbi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.javatbi.model.Application;
import com.javatbi.model.Surrogate;
import com.javatbi.service.ApplicationService;
import com.javatbi.service.EmailUtility;
import com.javatbi.service.SurrogateService;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class SurrogateServlet extends HttpServlet {
	private String host;
    private String port;
    private String user;
    private String pass;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		
	 String email = request.getParameter("email");

	
	 Surrogate surr = new Surrogate(email);
	 SurrogateService surr_service = new SurrogateService();
	boolean surrogate_success = surr_service.register(surr);
	if(surrogate_success){ 
	Application app = new Application();
	ApplicationService app_service = new ApplicationService();
	app_service.register(app);
	 Long app_id = app_service.application_id;
	 
			
	
	         ServletContext context = getServletContext();
	         host = context.getInitParameter("host");
	         port = context.getInitParameter("port");
	         user = context.getInitParameter("user");
	         pass = context.getInitParameter("pass");
	         // reads form fields
	         //String recipient = request.getParameter("recipient");
	         String subject = "UMass Application ID: " + app_id;
	         String content = "Hey, thank you for registering. Please note down your application number and use this to access your application in the future. Application ID : "+app_id;
	  
	         String resultMessage = "";
	  
	         try {
	             EmailUtility.sendEmail(host, port, user, pass, email, subject,content);
	             resultMessage = "Successful";
	         } catch (Exception ex) {
	             ex.printStackTrace();
	             resultMessage = "There were an error: " + ex.getMessage();
	         } finally {
	             request.setAttribute("Message", resultMessage);
	             getServletContext().getRequestDispatcher("/index.jsp").forward(
	                     request, response);
	         }
	     }
	}
	}
	/*private void testForiegnKey()
	 {
		Session session = HibernateUtil.openSession();
        session.beginTransaction();
 
        Application appl1 = new Application();
        Application appl2 = new Application();
        Application appl3 = new Application();

        
 
        //Add new Surrogate object
        Surrogate firstSurrogate = new Surrogate();
        firstSurrogate.setSurr_email("email1");
        Surrogate secondSurrogate = new Surrogate();
        secondSurrogate.setSurr_email("email2");
       
        
 
        Set<Application> accountsOfFirstApplicant = new HashSet<Application>();
        accountsOfFirstApplicant.add(appl1);
        accountsOfFirstApplicant.add(appl2);
        
        Set<Application> accountsOfSecondApplicant = new HashSet<Application>();
        accountsOfSecondApplicant.add(appl3);


 
        firstSurrogate.setApplication(accountsOfFirstApplicant);
        secondSurrogate.setApplication(accountsOfSecondApplicant);
        //Save Employee
        session.save(firstSurrogate);
        session.save(secondSurrogate);
 
        session.getTransaction().commit();
        session.close();
        //HibernateUtil.shutdown();
	 }

}*/