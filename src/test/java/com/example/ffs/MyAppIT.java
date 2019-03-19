package com.example.ffs;



import java.io.File;
import java.lang.management.ManagementFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.seleniumhq.jetty9.jmx.MBeanContainer;
import org.seleniumhq.jetty9.server.Handler;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty9.server.Server;

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.parallel.ParallelTest;
import com.vaadin.ui.TextField;
import org.eclipse.jetty.webapp.WebAppContext;

public class MyAppIT extends TestBenchTestCase {
	private static final String URL="http://127.0.0.1";
	  private static final String PORT="8080";
	  
	  
	@Before
	  public void setup() throws Exception {
		
		
		
		
		
		
		
		
		
		  setDriver(TestBench.createDriver(new PhantomJSDriver()));
			getDriver().manage().window().setSize(new Dimension(1024, 768));
	    //setDriver(new FirefoxDriver());
	    //Open the web page
	    getDriver().get(URL+":"+PORT);
	  }

	  @After
	  public void tearDown() throws Exception {
	    //close the browser window
	    getDriver().quit();
	  }

	  
	  
	  
}
