package com.baidu.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * 运行lint后，删除无用的资源文件
 * using method:lint  --check UnusedResources > res.txt
 * */
public class DeleteUnusedFiles {

	//lint 结果
	private static String lintResult = "/home/liushaogeng/baidu/code/cloudtv/tv-app/modules/TVPan/res.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			deleteUnusedResources();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 自动删除无用的资源文件
	 * */
	private static void deleteUnusedResources() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(lintResult));
		String line;
		
		while((line = reader.readLine()) != null){
			if(line.contains("UnusedResources") && !line.contains("res/value") && !line.contains("appcompat")){
				int end = line.indexOf(":");
				if(end!=-1){
					String file = line.substring(0, end);
					String f = file;
					System.out.println(f);
					new File(f).delete();
				}
			}
		}
		return;
	}

}
