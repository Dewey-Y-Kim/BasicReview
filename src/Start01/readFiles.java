package Start01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class readFiles {

	public readFiles() {
		// TODO Auto-generated constructor stub
	}
	ArrayList<String> prohibit= new ArrayList<>();
	public static File[] setPath(String path) {
		File dir = new File(path); //jsp가 있는 폴더 설정
		FilenameFilter filter = new FilenameFilter() { //jsp,html,css파일만 불러오기
			public boolean accept(File file, String name) {
				boolean result=(name.endsWith(".jsp")||name.endsWith(".html")||name.endsWith(".css"))&&(!name.startsWith("../"));	
				return result;
				}
			};
			File files[] = dir.listFiles(filter); //파일 검색및 출력
		return files;
	}
	public void read(File file)  {
		try {
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
			String line;
			do {
			line=bf.readLine();
			
			if(chkProhibit(line)!="!@#!@#"||chkProhibit(line)!=null) System.out.println(chkProhibit(line));
			}while(line!=null);
		bf.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	public String chkProhibit(String line) {
		for(int i=0;i<prohibit.size();i++) {
			if(line.contains(prohibit.get(i))) {
				line="!@#!@#";
			}
		}
		return line;
		
	}
	public void prohibit() {
		String[] prohibit= {"<body>", "</head>","</body>","</html>","<title>","<meta charset=\"UTF-8\">","<head>","<html>","<!DOCTYPE html>"};
		for(String str: prohibit) {
			this.prohibit.add(str);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="../SumHtml";
		new readFiles().prohibit();
		File[] files=setPath(path);
		try {
		
		for(File file : files) {
			new readFiles().read(file);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
