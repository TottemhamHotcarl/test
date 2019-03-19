package com.example.ffs;
import java.net.*;
import java.io.*;




public class ConnectToInternet{

	String URL;
	pairsList pairslist = new pairsList();
	
	public ConnectToInternet(String URL, pairsList pairslist) {
		this.URL = URL;
		this.pairslist = pairslist;
	}
	
	public String execute() {
		try {
			String Final_URL = URL+"/?";
			 for(int i = 0; i < pairslist.size(); i++) {
				 if (i == 0) {
					 Final_URL = Final_URL + pairslist.stringC(i);
				 }
				 else {
					 Final_URL = Final_URL +"&" + pairslist.stringC(i);
				 }
				 
			 }
			 System.out.println(Final_URL);
			 Final_URL = Final_URL.replace(" ", "%20");
			 System.out.println(Final_URL);
			 URL website = new URL(Final_URL);
			 URLConnection yc = website.openConnection();
			 BufferedReader in = new BufferedReader(new InputStreamReader(
                     yc.getInputStream()));
			 String inputLine;
			 String response = "";
			 while ((inputLine = in.readLine()) != null) {
				 System.out.println(inputLine);
				 response = response + inputLine;
			 }
			 in.close();
			 System.out.println("we made it");
			 return response;
	 
		}catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
		 
	}
	
	
}
