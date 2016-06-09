package test;

import java.io.File;
import java.io.FilenameFilter;

public class shouzuoye {
	
	static String path = "D:\\zuoye\\";
	
	public static void main(String[] args) {
		File[] files = new File(path).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				int hou = name.lastIndexOf(".");
				String[] ss = name.substring(0, hou).split("-");
				if(ss.length != 3){
					System.out.println(name + "读取错误");
					return false;
				}
				if(ss[0].indexOf("1331032") == -1){
					String filename =dir.getPath()+"\\"+ ss[1]+"-"+ss[2]+"-"+ss[0]+name.substring(hou);
					File ff = new File(filename);
					File of = new File(dir.getPath()+"\\"+name);
					of.renameTo(ff);
					System.out.println(">>"+of.getPath()+"   改名为   >>"+ff.getPath());
				}else{
					System.out.println(">>"+name + "  不需要改名");
				}
				
				return false;
			}
		});
		
	}
}
