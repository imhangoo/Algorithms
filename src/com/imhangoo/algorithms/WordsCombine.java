package com.imhangoo.algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WordsCombine{
	public static void main(String[] args) throws Exception{
		String aFilePath = "resources/a.txt";
		String bFilePath= "resources/b.txt";
		FileManager aManager = new FileManager(aFilePath,new char[]{'\n'});
		FileManager bManager = new FileManager(bFilePath,new char[]{'\n',' '});
		BufferedWriter writer = new BufferedWriter(new FileWriter("resources/c.txt"));
		String aWord = null;
		String bWord = null;
		while((aWord = aManager.nextWord())!=null){
			writer.write(aWord+"\n");
			bWord = bManager.nextWord();
			if(bWord != null){
				writer.write(bWord+"\n");
			}
		}
		while((bWord = bManager.nextWord()) != null){
			writer.write(bWord+"\n");
		}
		writer.close();
		
	}
}

class FileManager{
	private String[] words;
	int position;
	
	public FileManager(String filePath, char[] dilimiter) throws Exception{
		File file = new File(filePath);
		FileReader reader = new FileReader(file);
		char[] buf = new char[(int)file.length()];
		int len = reader.read(buf);
		String content = new String(buf,0,len);
		String regex = null;
		if(dilimiter.length > 1){
			regex = "" + dilimiter[0] + "|" + dilimiter[1];
		}else{
			regex = "" + dilimiter[0];
		}
		words = content.split(regex);
		reader.close();
	}
	
	public String nextWord(){
		if(position == words.length){
			return null;
		}
		return words[position++];
	}
}