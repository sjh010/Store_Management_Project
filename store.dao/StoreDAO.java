package store.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import store.vo.Store;

public class StoreDAO {
	
	String fileName;
	FileReader fileReader;
	FileWriter fileWriter;
	BufferedReader reader;
	BufferedWriter writer;
	StringTokenizer st;
	
	List<Store> storeList = new ArrayList<Store>();
	
	public StoreDAO(String filename){
		this.fileName = filename;
	}

	public List<Store> load(){
		
		try{
			fileReader = new FileReader(this.fileName);
			reader = new BufferedReader(fileReader);
			String line = null;
			
			while((line = reader.readLine()) != null){
				
				st = new StringTokenizer(line, "|");
				
				String name = st.nextToken();
				double lat = Double.parseDouble(st.nextToken());
				double lng = Double.parseDouble(st.nextToken());
				String menu = st.nextToken();
				
				Store store = new Store(name, lat, lng, menu);
				
				storeList.add(store);
			}	
		}
		catch(FileNotFoundException fnfe){
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException ioe){
		
		}
		finally{
			try{
				reader.close();
			}
			catch(Exception e){
				System.out.println("파일을 닫는 중에 오류가 생겼습니다.");
			}
		}
		return storeList;
	}
	
	public void write(List<Store> list, String type){
		
		try{
			boolean wType = true;
			
			if(type.equals("write")){
				wType = true;
			}
			else if(type.equals("delete")){
				wType = false;
			}
		
			fileWriter = new FileWriter(this.fileName, wType);
			writer = new BufferedWriter(fileWriter);
			
			for(int i=0; i<list.size(); i++){
				
				Store store = list.get(i);
				
				writer.write(store.getName());
				writer.write("|");
				writer.write(String.valueOf(store.getLat()));
				writer.write("|");
				writer.write(String.valueOf(store.getLng()));
				writer.write("|");
				writer.write(store.getMenu());
				writer.newLine();
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException ioe){
		}
		finally{
			try{
				writer.flush();
				writer.close();
			}
			catch(Exception e){
				System.out.println("파일을 닫는 중에 오류가 생겼습니다.");
			}
		}
	}
		
}


