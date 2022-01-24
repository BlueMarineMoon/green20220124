package org.comstudy21.ex02;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03JSoup {
	
	public Ex03JSoup() {
		String urlPath = "https://www.w3schools.com/css/css_selectors.asp";
		Document doc = Jsoup.connect(urlPath).get();
		System.out.println(doc.title());
		
		Elements lis = doc.select("#main ul li");
		for(Element el : lis) {
			String imgUrl = String.format("https://%s", el.attr("arr")+1);
		}
	}

	public static void main(String[] args) throws IOException {
		new Ex03JSoup();
	}

}
