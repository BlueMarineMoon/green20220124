package org.comstudy21.ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.comstudy21.ex02.Ex03JSoup;

public class Ex02Url {
	
	public Ex02Url() throws IOException {
		String imgUrlPath = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMjRfMjkg%2FMDAxNjM3NzYyMjk2MDE0.uCJdDAwTVz2O6FrGJlpq86xVrk4fPFYRvPK2hqZRHzMg.8liBGWLYDVG-d3qWxIzp-mjtYPZpDYU_YDTPz43Gvskg.JPEG.wellmom%2F1635512866982%25A3%25AD7.jpg&type=a340";
		URL url = new URL(imgUrlPath);
		
		InputStream is = url.openStream();
		DataInputStream dis = new DataInputStream(is);
		
		File dir = new File("./images");
		if(!dir.exists()) {
			if(dir.mkdir()) {
				// 디렉토리 생성 권한이 없다면 만들어지지 않는다.
				System.out.println("새 디렉토리 생성 완료!");
			}
		}
		
		String saveFilePath = "photo.jpg";
		File file = new File(dir, saveFilePath);
		//getClass().getResourceAsStream(saveFilePath);
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		int data = 0;
		while((data=dis.read())!=-1) {
			//System.out.print((char)data);
			
			// 파일로 저장 하기
			dos.write(data);
		}
		
		if(dis != null) dis.close();
		if(is != null) dis.close();
		if(dos != null) dos.close();
		if(fos != null) dos.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Ex02Url();
	}
}
