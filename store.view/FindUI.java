package store.view;

import java.util.List;

import store.service.StoreService;
import store.vo.Store;

public class FindUI extends AbstractUI{
	
	public FindUI(StoreService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doJob() {
		// TODO Auto-generated method stub
		System.out.println("1. 이름 검색");
		System.out.println("2. 메뉴 검색");
		System.out.println("3. 가까운 맛집 검색");
		
		int num = Integer.parseInt(scan.nextLine());
		
		if(num==1){
			System.out.println("찾으시는 맛집의 이름을 입력하세요.");
		}
		else if(num==2){
			System.out.println("찾으시는 메뉴의 이름을 입력하세요.");
		}
		else if(num==3){
			findByPosition();
			return;
		}
	
		String userInput = scan.nextLine();
		
		List<Store> list = service.readStore(userInput);
		
		show(list);
	}
	
	private void show(List<Store> list){
		
		for(int i=0; i<list.size(); i++){
			Store store = list.get(i);
			System.out.println("음식점명 : " + store.getName());
			System.out.println("위          도 : " + store.getLat());
			System.out.println("경          도 : " + store.getLng());
			System.out.println("메          뉴 : " + store.getMenu());
		}
	}
	
	private void findByPosition(){
		
		System.out.println("현재 위도를 입력하세요.");
		double lat = Double.parseDouble(scan.nextLine());
		
		System.out.println("현재 경도를 입력하세요.");
		double lng = Double.parseDouble(scan.nextLine());
		
		List<Store> list = service.Comparator(lat, lng);
		
		show(list);
	}

}
