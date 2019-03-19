package com.example.ffs;

import java.util.ArrayList;

public class pairsList {
	ArrayList<pairs> pairsList = new ArrayList<pairs>();
	
	public void put(String key, String value) {
		pairs p = new pairs(key, value);
		pairsList.add(p);
	}
	
	
	public int size() {
		return pairsList.size();
	}
	
	public String stringC(int i) {
		pairs p = pairsList.get(i);
		String t = "";
		t = t + p.key;
		t = t + "=";
		t = t + p.value;
		return t;
	}	
	
	
}
