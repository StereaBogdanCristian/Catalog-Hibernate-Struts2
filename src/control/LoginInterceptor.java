package control;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	
	public void destroy() {
	}
	
	public void init() {
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
		String result = "fail";
		if (sessionMap.containsKey("elev")) {
			result = invocation.invoke();
		}
		
		if (sessionMap.containsKey("profesor")) {
			result = invocation.invoke();
		}
		
		return result;
	}

}
