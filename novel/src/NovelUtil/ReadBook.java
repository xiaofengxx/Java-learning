package NovelUtil;

import java.io.File;

public class ReadBook {
	static String mainPath = "D:\\novels";
	String separator;
	public ReadBook(){
		 separator = File.separator;
	}
	static private String GetXMl(String path,int lvl){
		int order = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		File file  = new File(path);
		File[] files = file.listFiles();
		for(File f:files){
			int lev = lvl;
			while(lev -- >0){
				sb.append("    ");
			}
			sb.append("\""+f.getName()+"\" : \"");
			if(!f.isFile()){
				String temp_f = GetXMl(f.getPath(),lvl+1);
				if(temp_f != null)
					sb.append(temp_f);
			}else{
				sb.append(order++ +"\"");
			}
			sb.append(",\r\n");
		}
		int lev = lvl;
		while(lev -- >1){
			sb.append("    ");
		}
		sb.append("}");
		return sb.toString();
	}
	static public String GetXMl(String path){
		return GetXMl(path,1);
	}

}
