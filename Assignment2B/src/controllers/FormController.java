package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean 
@ViewScoped
public class FormController {

	
	public String onSubmit() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		System.out.println("The user's first name is: " + user.getFirstName());
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		
		return "TestResponse2.xhtml";
		
		
	}
}
