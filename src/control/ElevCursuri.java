package control;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Elev;

public class ElevCursuri extends ActionSupport {
	
	private static final long serialVersionUID = 7985976217884404630L;
	
	private Elev elev;
	
	public Elev getElev() {
		return elev;
	}

	public void setElev(Elev elev) {
		this.elev = elev;
	}

	public String execute() {
		
	    elev = (Elev) ActionContext.getContext().getSession().get("elev");
	    return "success";
	}

}
