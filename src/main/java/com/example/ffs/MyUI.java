package com.example.ffs;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */


@Theme("mytheme")
public class MyUI extends UI {

		boolean failed_login = false;

	    @Override
	    protected void init(VaadinRequest vaadinRequest) {
	        final VerticalLayout layout = new VerticalLayout();
	    
	        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	        //This where you add Views
	        Navigator navigator = new Navigator(this, this);
        	navigator.addView("welcome", (View) new welcome_UI());
	        navigator.addView("QueryBox", (View) new Query_Box_UI()); 
	        
	        
	        
	        Label wel = new Label("Welcome to LearnMySQL");
	        wel.setWidthUndefined();
	        final TextField username = new TextField();
	        username.setCaption("USERNAME");
	        final PasswordField password = new PasswordField();
	        password.setCaption("PASSWORD");
	      
	        
	        Button button = new Button("Log in");
	        Button logoff = new Button("Log off");
	        button.addClickListener(e -> {
	           
	            setContent(layout);
	            String user = username.getValue();
	            String pass = password.getValue();
	           
		            Ldap  ldap = Ldap.connect("students", user, pass);
		            Person u = ldap.getUser(user);
		           
		            if (u==null && !(user.equals("admin") && pass.equals( "admin"))) {
		            	print("__________________________________");
		            	
		            	if (!failed_login) {
		            		Label wpu = new Label("Wrong Username or Password!");
			            	wpu.addStyleName("red");
			            	layout.addComponent(wpu);
			            	 layout.setComponentAlignment(wpu, Alignment.MIDDLE_CENTER);
			            	 failed_login = true;
		            	}
		            	
		            		            	 
		            	
		            }
		            else if(user.equals("admin") && pass.equals("admin")){
		            	Person temp = new Person();
		            	temp.setName("admin");
		            	temp.setLastname("admin");
		            	temp.setEmail("admin@admin.com");
		            	temp.setId("1");
		            	temp.access = "1";
		            	
		            	User usera = new User(temp);
		            	System.out.println(temp.toString());
		            	
		            	
		            	
		            	
		            	
		            	navigator.navigateTo("QueryBox");
		            	
		            	
		            		
		            	
		            }
		            else {
		            	 layout.removeAllComponents();
		            	layout.addComponent(new Label("You are a student!!!"));
		            	User usera = new User(u);
		            	System.out.println(u.toString());
		            
		            	
		            	navigator.navigateTo("welcome");
		            }
		            
		            
		            ldap.close();
		            
	            
	        });
	        
	        layout.addComponents(wel, username,password, button);
	        layout.setComponentAlignment(wel, Alignment.MIDDLE_CENTER);
	        layout.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
	        layout.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
	        layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
	       
	        setContent(layout);
	    }

	    @WebServlet(urlPatterns = "/*", asyncSupported = false)
	    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	    public static class MyUIServlet extends VaadinServlet {
	    	
	    	
	    }
	    public void print(String a) {
	    	System.out.println(a);
	    }
}
