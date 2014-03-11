package store.service;

import java.util.List;

import store.vo.Store;

public interface StoreService {
	
	public abstract void registStore(Store store);
	
	public abstract List<Store> readStore(String input);
	
	public abstract void updateStore(Store store);
	
	public abstract void deleteStore(String name);
	
	public abstract List<Store> Comparator(double lat, double lng);

}
