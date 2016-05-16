package NovelUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Books {
	static private String xml;
	static private HashMap<String,Book> map;
	static private ArrayList<Book> list;
	static private String mainPath = "D:\\novels";
	public void update(){
		this.xml = ReadBook.GetXMl(mainPath);
		updateMap();
	}
	public Books() {
		map = new HashMap<String,Book>();
		list = new  ArrayList<Book>();
		update();
	}
	private void updateMap(){
		int p1,p2;
		BufferedReader br = new BufferedReader(new StringReader(xml));
		try {
			String temp_m = br.readLine();
			StringBuilder sb = new StringBuilder();
			while((temp_m=br.readLine()) !=null){
				sb.append(temp_m);
				sb.append("\r\n");
				if(temp_m.indexOf("},") != -1){
					Book book = new Book(sb.toString());
					map.put(book.getName(), book);
					list.add(book);
					sb = new StringBuilder();
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printlist(){
		for(Book b :list){
			System.out.print(b.getXML());
		}
	}
	
	public static HashMap<String, Book> getMap() {
		return map;
	}
	public static ArrayList<Book> getList() {
		return list;
	}
	public class Book{
		private static final String mode = "{\r\n"
				+ "	\"item\": \"book\",\r\n"
				+ "	\"name\": \"##\",\r\n"
				+ "	\"count\": \"##\"\r\n"
				+ "	\"part\": {\r\n"
				+ "##"
				+ "	},\r\n"
				+ "}\r\n";
		private String item;
		private String name;
		int part;
		private String xml;
		public Book(String xml1){
			part = 0;
			int p1,p2;
			BufferedReader br = new BufferedReader(new StringReader(xml1));
			StringBuilder sb = new StringBuilder();
			try {
				String temp_b = br.readLine();
				p1 = temp_b.indexOf('\"');
				p2 = temp_b.indexOf(":");
				name = temp_b.substring(p1+1, p2-2);
				xml = mode.replaceFirst("##", name);
				while((temp_b = br.readLine()) != null){
					if(temp_b.indexOf('}') != -1)
						break;
					sb.append(temp_b);
					sb.append("\r\n");
					part++;
				}
				xml = xml.replaceFirst("##", part+"");
				xml = xml.replaceFirst("##", sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public String getXML(){
			return xml;
		}
		public String getName() {
			return name;
		}
	}
}
