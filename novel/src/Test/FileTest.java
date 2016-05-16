package Test;

import java.io.BufferedReader;
import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import NovelUtil.ReadBook;

public class FileTest {
	static String mainPath = "D:\\novels";
	String separator;
	static byte[] newLine;
	public FileTest(){
		 separator = File.separator;
		 newLine = "\r\n".getBytes();
	}
	public static void main(String[] args) {
		FileTest ft = new FileTest();
		File file  = new File("D:\\test1.xml");
		FileOutputStream fos = null;
		BufferedReader bf = null;
		try {
			fos = new FileOutputStream(file);
			String temp_bf;
			bf =new BufferedReader(new StringReader(ReadBook.GetXMl(mainPath)));
			while((temp_bf=bf.readLine())!=null){
				byte[] b = temp_bf.getBytes("UTF-8");
				fos.write(b, 0, b.length);
				fos.write(newLine, 0, newLine.length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(bf != null)
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
