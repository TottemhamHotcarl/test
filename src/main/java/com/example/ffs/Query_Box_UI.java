package com.example.ffs;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Query_Box_UI extends VerticalLayout implements View {
	
	public Query_Box_UI() {
		final VerticalLayout layout = new VerticalLayout();
		
		setSizeFull();
		
		TextField SQL = new TextField();
		SQL.setCaption("put SQL Here");
		
		
		Button execute = new Button("execute");
		
		 execute.addClickListener(e -> {
			 removeAllComponents();
			 String sql_query = SQL.getValue();
			 
			 pairsList pl = new pairsList();
				pl.put("DATABASE", "d1606558");
				pl.put("SQL", sql_query);
				System.out.println("pizza");
			 
			 ConnectToInternet CI = new ConnectToInternet("http://lamp.ms.wits.ac.za/~s1606558/sqlQueryExecute.php",pl);
				String s = CI.execute();
				final VerticalLayout layout2 = new VerticalLayout();
				String[] t2 = s.split("<br />");
				for(int i = 0; i < t2.length; i++) {
		           Label t = new Label();
		           
		           t.setValue(t2[i]);
		           layout2.addComponent(t);
		         
				}
				  addComponent(layout2);
	          
		
		 });
		
		
		
		layout.addComponents(SQL,execute);
		addComponent(layout);
		
	}

}
