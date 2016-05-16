package Server;

import java.util.ArrayList;

import NovelUtil.Books;
import NovelUtil.Books.Book;

public class Cmmd {
	
	static public void get_list(String mode,int page,Call call){
		ArrayList<Book> list = Books.getList();
		ArrayList<Book> temp_list;
		switch (mode) {
		case "default":
			
			break;
		default:
			break;
		}

	}
	static public void down(String[] what,Call call){
		
	}
	static public void serch(String words,Call call){
		
	}
	public interface Call{
		public  void run(Object... obj);
	}
	
}
