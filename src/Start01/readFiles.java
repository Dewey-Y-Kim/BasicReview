package Start01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;

public class readFiles {

	public readFiles() {
		// TODO Auto-generated constructor stub
	}
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
	public void copy(File file) {
		BufferedReader bf = new BufferedReader(file.getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="../SumHtml";
		File[] files=setPath(path);
		
		for(File file : files) {
			System.out.println(file.getName());
		}
	}

}
