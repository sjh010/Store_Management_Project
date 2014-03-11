package store.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import store.service.StoreService;
import store.service.StoreServiceImpl;
import store.vo.Store;

public class IntroUI {
	
	StoreService service;
	Store store;
	Scanner scan;
	Map<String, StoreUI> uiMap;
	
	public IntroUI(){
		super();
		service = new StoreServiceImpl();
		scan = new Scanner(System.in);
		
		uiMap = new HashMap<String, StoreUI>();
		uiMap.put("1", new RegistUI(this.service));
		uiMap.put("2", new FindUI(this.service));
		uiMap.put("3", new UpdateUI(this.service));
		uiMap.put("4", new DeleteUI(this.service));
	}
	
	public void intro(){
		
		System.out.println("1. 맛집 등록");
		System.out.println("2. 맛집 검색");
		System.out.println("3. 맛집 수정");
		System.out.println("4. 맛집 삭제");
		System.out.println("5. 의사결정트리로 메뉴 고르기");
		System.out.println("6. 종           료");
		
		String userInput = scan.nextLine();
		
		if(userInput.equals("6")){
			return;
		}
		
		uiMap.get(userInput).doJob();
		
		intro();
	}

}
