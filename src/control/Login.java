package control;

import java.util.Map;

//import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import dbConnection.ReadElev;
import dbConnection.ReadProfesor;
import model.Elev;
import model.Profesor;
//import model.Test;

public class Login extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	private Elev elev;
	private Profesor profesor;
	private Map<String, Object> sessionMap;
	
	
	
	public String login() {
		
		//Test test =new Test();
		//test.hibernate();
		
		ReadElev re = new ReadElev();
		
	   	if (re.isParola(getUser(), getPassword())) {
	   		elev = re.getElev();
	   		sessionMap.put("elev", elev);
	   		return "successElev";
	   	}
	   	
	   	ReadProfesor rp = new ReadProfesor();
	   	
	   	if (rp.isParola(getUser(), getPassword())) {
	   		profesor = rp.getProfesor();
	   		sessionMap.put("profesor", profesor);
	   		return "successProfesor";
	   	}
	   	
	   	addActionError("Logare nereusita!");
		return "fail";
	}
	
	public String homeElev () {
		elev = (Elev) sessionMap.get("elev");
		return "success";
	}
	
	public String homeProfesor () {
		profesor = (Profesor) sessionMap.get("profesor");
		return "success";
	}
	
	public String out() {
		return "success";
	}
	
	public String logout() {
	
	        if (sessionMap.containsKey("elev")) {
	            sessionMap.remove("elev");
	        }
	        
	        if (sessionMap.containsKey("profesor")) {
	            sessionMap.remove("profesor");
	        }
	        return "success";
	    }
	  
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public Map<String, Object> getSession() {
		return sessionMap;
	}
	
	public Elev getElev() {
		return elev;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
