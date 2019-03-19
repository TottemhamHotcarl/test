package com.example.ffs;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
@Theme("mytheme")
public class welcome_UI extends VerticalLayout implements View{

	@Override
    public void enter(ViewChangeEvent viewChangeEvent) {
		 

    }
	

	public welcome_UI() {
		
		
		
		User usera = new User();
		Person p = usera.person;
		print("AAAAAAA" + " ::" + p.getEmail());
		System.out.println(p.getEmail());
		
		final VerticalLayout layout = new VerticalLayout();
		
		setSizeFull();
		Label welcome = new Label("Welcome to learn MySQL page:  " + p.name);
		Button learn = new Button("Learn");
		
		welcome.setStyleName("ValoTheme");
	
		Button Back = new Button("Practice");
		Button QueryBox = new Button("Query Box");
		
		
		layout.addComponents(welcome,learn,Back, QueryBox);
		layout.setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
		addComponent(layout);
		
	
	
}
	
	public void print(String a) {
    	System.out.println(a);
    }
	
	public void ToTheQueryBox() {
		//Navigator navigator = new Navigator(this, this);
    	//navigator.addView("welcome", (View) new welcome_UI());
    	
    	//navigator.navigateTo("welcome");
	}
	
	}
