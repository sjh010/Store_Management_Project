Store_Management_Project
========================
package store.view;

import java.util.Scanner;

import store.service.StoreService;

public abstract class AbstractUI implements StoreUI{
	
	StoreService service;
	Scanner scan = new Scanner(System.in);
	
	public AbstractUI(StoreService service) {
		super();
		this.service = service;
	}

	
	
	
}
