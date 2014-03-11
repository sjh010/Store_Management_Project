package store.view;

import store.service.StoreService;

public class DeleteUI extends AbstractUI {

	public DeleteUI(StoreService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doJob() {
		// TODO Auto-generated method stub
		System.out.println("맛집 삭제를 선택하셨습니다.");
		System.out.println("삭제할 맛집의 이름을 입력해주세요.");
		String name = scan.nextLine();
		
		service.deleteStore(name);
		
		System.out.println("삭제가 완료되었습니다.");
	}

}
