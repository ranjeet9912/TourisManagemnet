package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.Employee;
import com.pojo.EmployeeDao;
import com.pojo.HodEmployee;


@Controller
public class ControllerDao {

	private ApplicationContext conn;

	@RequestMapping("/register1")
	public String view2(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee  emp = conn.getBean("info", Employee.class);
		m.addAttribute("bean",emp);
		return "register";
	}


	@RequestMapping("/save")
	public String view3(@ModelAttribute("bean") Employee e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveData(e);
		m.addAttribute("msg", "record inserted....");
		return "register";
	}


	//display

	@RequestMapping("/display")	
	public String view191(Model m, HttpServletRequest request)
	{		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		Employee use = (Employee)session.getAttribute("sdata");
		//if(!use.getFemail().isEmpty()) {
		if(use.getFlag()==1) {
			EmployeeDao  obj = conn.getBean("dao", EmployeeDao.class);
			List list  = obj.displayData();
			if(!list.isEmpty())
			{
				m.addAttribute("data",list);
			}
			else {
				m.addAttribute("msg", "no data found..");
			}
			return "display";
		}
		else {
			m.addAttribute("msg", "Login First..");
			return "redirect:index.jsp";	
		}
	}

	//login

	@RequestMapping("/login1")
	public String view51(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee  obj = conn.getBean("info", Employee.class);
		m.addAttribute("bean",obj);
		return "login";
	}

	@RequestMapping("/logindata")
	public String login21(@ModelAttribute("bean") Employee  obj ,HttpServletRequest request,Model m) {
		
		obj.setFemail(request.getParameter("femail"));
		obj.setFpass(request.getParameter("fpass"));
		String email = obj.getFemail();
		String pass = obj.getFpass();
		EmployeeDao  obj1 =  new EmployeeDao();

		List list = obj1.login(email,pass);
		if((list!=null) && (list.size()>0))
		{
			//my part
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj2 = conn.getBean("dao", EmployeeDao.class);
			Employee e1 = new Employee();
			e1.setFemail(email);
			e1.setFpass(pass);
			
			List list22 = obj2.getData(e1);
			if(!list22.isEmpty())
			{
				m.addAttribute("li2", list22);
				Employee e11 = new Employee();
				e11.setFemail(email);
				e11.setFlag(1);
				
				HttpSession session = request.getSession();
				session.setAttribute("sdata", e11);
				return "home";				
			}

			//till here
		}
		else{
			m.addAttribute("msg","login failed.try again..");

		}
		//return "redirect:index.jsp";	
		return "login";

	}

	//logout
	@RequestMapping("/logout1")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Employee obj = (Employee)session.getAttribute("sdata");
		obj.setFemail(null);
		obj.setFlag(0);
		System.out.println("now:" + obj.getFemail());
		return "redirect:index.jsp";
	}


	
	//search
	@RequestMapping("/find")
	public String view33(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee  emp = conn.getBean("info", Employee.class);
		m.addAttribute("bean",emp);
		return "search";
	}

	@RequestMapping("/search1")
	public String view34(@ModelAttribute("bean") Employee e,Model m,HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		Employee use = (Employee)session.getAttribute("sdata");
		if(use.getFlag()==1) {
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.searchData(e);
		if(!list.isEmpty())
		{
			m.addAttribute("li", list);
		}
		else {
			m.addAttribute("msg1","no record found..");
		}
		return "search";
	}
		else
		{
			m.addAttribute("msg1","login first..");
			return "redirect:index.jsp";
		}
	}

	//update
	@RequestMapping("/update1")
	public String view314(@ModelAttribute("bean") Employee emp, Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.updateData(emp);
		m.addAttribute("msg2", "Successfully Updated..");

		return "home";


	}

	//delete
	@RequestMapping("/delete1")
	public String view7(@ModelAttribute("bean") Employee emp, Model m,HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.deleteData(emp);
		m.addAttribute("msg3", "Successfully Deleted Entry..");
		HttpSession session = request.getSession();
		Employee obj1 = (Employee)session.getAttribute("sdata");
		obj1.setFemail(null);
		obj1.setFlag(0);
		m.addAttribute("msg","Record Deleted... SignUp or SignIn now.");
		return "login";
		//return "home";

	}













	// =========================================================================//
	//hod part

	//register
	@RequestMapping("/hregister")
	public String view27(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HodEmployee  emp = conn.getBean("info1", HodEmployee.class);
		m.addAttribute("bean",emp);
		return "hodregister";
	}

	@RequestMapping("/hsave")
	public String view43(@ModelAttribute("bean") HodEmployee e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveHodData(e);
		m.addAttribute("msg", "HOD record inserted....");
		return "hodregister";
	}



	//login	
	@RequestMapping("/hlogin1")
	public String view561(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HodEmployee  emp = conn.getBean("info1", HodEmployee.class);
		m.addAttribute("bean",emp);
		return "hodlogin";
	}

	@RequestMapping("/hodlogindata")
	public String login261(@ModelAttribute("bean") HodEmployee  obj ,HttpServletRequest request,HttpServletResponse response,Model m) {

		obj.setHemail(request.getParameter("hemail"));
		obj.setHpass(request.getParameter("hpass"));
		String email = obj.getHemail();
		String pass = obj.getHpass();
		EmployeeDao  obj1 =  new EmployeeDao();

		List list = obj1.hodlogin(email,pass);
		if((list!=null) && (list.size()>0))
		{
			//my part
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj2 = conn.getBean("dao", EmployeeDao.class);
			HodEmployee e1 = new HodEmployee();
			e1.setHemail(email);
			e1.setHpass(pass);
			
			List list22 = obj2.getHodData(e1);
			if(!list22.isEmpty())
			{
				m.addAttribute("li2", list22);
				HodEmployee e11 = new HodEmployee();
				e11.setHemail(email);
				e11.setHflag(1);
				
				HttpSession session = request.getSession();
				session.setAttribute("shdata", e11);
				return "hodhome";				
			}

			//till here
		}
		else{
			m.addAttribute("msg","login failed.try again..");

		}
		//return "redirect:index.jsp";	
		return "hodlogin";
	}
	
    //hod logout part..
	@RequestMapping("/hlogout1")
	public String hodlogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		HodEmployee obj = (HodEmployee)session.getAttribute("shdata");
		obj.setHemail(null);
		obj.setHflag(0);
		//System.out.println("now:" + obj.getHemail());
		return "redirect:index.jsp";
	}
	//hod display all hods..
	@RequestMapping("/hdisplay")	
	public String view91(Model m, HttpServletRequest request)
	{		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		HodEmployee use = (HodEmployee)session.getAttribute("shdata");
		//if(!use.getFemail().isEmpty()) {
		System.out.println("session email: "+use.getHemail());
		if(use.getHflag()==1) {
			EmployeeDao  obj = conn.getBean("dao", EmployeeDao.class);
			List list  = obj.hoddisplayData();
			if(!list.isEmpty())
			{
				m.addAttribute("hdata",list);
			}
			else {
				m.addAttribute("msg", "no data found..");
			}
			return "hoddisplay";
		}
		else {
			m.addAttribute("msg", "Login First..");
			return "redirect:index.jsp";	
		}
	}
	
	//hod update record
	//update
		@RequestMapping("/hupdate1")
		public String view34(@ModelAttribute("bean") HodEmployee emp, Model m)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			obj.hodupdateData(emp);
			m.addAttribute("msg2", "Successfully Updated..");
			return "hodhome";
		}
		//hod delete record
		@RequestMapping("/hdelete1")
		public String view77(@ModelAttribute("bean") HodEmployee emp, Model m,HttpServletRequest request)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			obj.hoddeleteData(emp);
			m.addAttribute("msg3", "Successfully Deleted Record..");
			HttpSession session = request.getSession();
			HodEmployee obj1 = (HodEmployee)session.getAttribute("shdata");
			obj1.setHemail(null);
			obj1.setHflag(0);
			m.addAttribute("msg","Record Deleted... SignUp or SignIn now.");
			return "hodlogin";
			//return "home";

		}
		//hod display all faculties by hod.
		@RequestMapping("/hfdisplay")	
		public String view11(Model m, HttpServletRequest request)
		{		
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			HttpSession session = request.getSession();
			HodEmployee use = (HodEmployee)session.getAttribute("shdata");
			//if(!use.getFemail().isEmpty()) {
			if(use.getHflag()==1) {
				EmployeeDao  obj = conn.getBean("dao", EmployeeDao.class);
				List list  = obj.hoddisplayData();
				if(!list.isEmpty())
				{
					m.addAttribute("hdata",list);
				}
				else {
					m.addAttribute("msg", "no data found..");
				}
				return "hodfdisplay";
			}
			else {
				m.addAttribute("msg", "Login First..");
				return "redirect:index.jsp";	
			}
		}


}


