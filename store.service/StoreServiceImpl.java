package store.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import store.dao.StoreDAO;
import store.vo.Store;

public class StoreServiceImpl implements StoreService {

	private List<Store> storeList;
	private StoreDAO dao;
	
	
	
	
	public StoreServiceImpl() {
		super();
		dao = new StoreDAO("storeList.txt");
		storeList = dao.load();
		
	}

	@Override
	public void registStore(Store store) {
		// TODO Auto-generated method stub
		storeList.add(store);
		List<Store> tempList = new ArrayList<Store>();
		tempList.add(store);
		dao.write(tempList, "write");	
	}
	
	@Override
	public List<Store> readStore(String userInput) {
		// TODO Auto-generated method stub
		List<Store> tempStoreList = new ArrayList<Store>();
		Store store;
		for(int i=0; i<storeList.size(); i++){
		
			store = storeList.get(i);
			
			if(store.getMenu().equals(userInput) || store.getName().equals(userInput)){
				tempStoreList.add(store);	
			}
		}
		
		return tempStoreList;
	}
	
	@Override
	public void updateStore(Store store) {  // 아직 구현 못함
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void deleteStore(String name) {
		// TODO Auto-generated method stub
		for(int i=0; i<storeList.size(); i++){
			if(storeList.get(i).getName().equals(name)){
				storeList.remove(i);
			}
		}
		dao.write(this.storeList, "delete");
	}

	@Override
	public List<Store> Comparator(double lat, double lng) {
		// TODO Auto-generated method stub
		final double finalLat = lat;
		final double finalLng = lng;
		
		Collections.sort(storeList, new Comparator<Store>(){

			@Override
			public int compare(Store s1, Store s2) {
				
				double d1 = s1.calcDistance(finalLat, finalLng);
				double d2 = s2.calcDistance(finalLat, finalLng);
				return (int) (d1 - d2);
			}
			
		});
		return storeList;
	}
	
	
}

