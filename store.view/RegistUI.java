package store.view;

import store.service.StoreService;
import store.vo.Store;

public class RegistUI extends AbstractUI{
	
	public RegistUI(StoreService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doJob() {
		// TODO Auto-generated method stub
		System.out.println("맛집 등록을 선택하셨습니다.");
		System.out.println("음식점명을 입력해주세요.");
		String name = scan.nextLine();
		
		System.out.println("위도를 입력해주세요.");
		double lat = Double.parseDouble(scan.nextLine());
		
		System.out.println("경도를 입력해주세요.");
		double lng = Double.parseDouble(scan.nextLine());
		
		System.out.println("메뉴를 입력해주세요.");
		String menu = scan.nextLine();
		
		Store store = new Store(name, lat, lng, menu);
		
		service.registStore(store);
		
		System.out.println("등록이 완료되었습니다.");
	}
	
}
