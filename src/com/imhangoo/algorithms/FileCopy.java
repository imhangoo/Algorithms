package com.imhangoo.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

public class FileCopy {
	private File srcDir;
	private File destDir;
	private byte[] buf = new byte[1024];
	
	public static void main(String[] args) throws Exception {
		new FileCopy("resources","resources").execute();
		System.out.println("File copy complete!");

	}

	public FileCopy(String srcPath, String destPath) {
		srcDir = new File(srcPath);
		destDir = new File(destPath);
	}

	public void execute() throws Exception{

		if (!srcDir.exists()) {
			throw new Exception("src does not exist");
		}

		if (!destDir.exists()) {
			destDir.mkdir();
		}

		File[] files = srcDir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});

		for (File file : files) {
			FileInputStream fis = new FileInputStream(file);
			String newFileName = file.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(destDir + File.separator + newFileName));
			copy(fis, fos);
			fis.close();
			fos.close();

		}
	}


	private void copy(FileInputStream fis, FileOutputStream fos) throws Exception{
		int len = 0;
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}

	}
	

}
