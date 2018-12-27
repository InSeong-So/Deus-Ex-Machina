package com.java.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Newser {

	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=102&sid2=249").get();
//		doc.select(".main_hotissu");
//		doc.select("#main");
//		doc.select(".main_hotissu a");
//		doc.select(".main_hotissu").get(0);
		for(int i = 0; i < doc.select("ul.type06_headline").size(); i++) {
			Element hotNews = doc.select("ul.type06_headline").get(i);
			Elements news = hotNews.select("a");
			Elements news2 = hotNews.select("span.lede");
			System.out.println(news);
			System.out.println("tete : " + news2);
//			for(Element e : news2){
//			    System.out.println(e.text());
//			}
		}
//	    System.out.println(e.getElementsByAttribute("href").attr("href"));
//	    text()로 해당 li 태그의 title 값을 얻어올 수 있다.
//	    getElementsByAttribute("href").attr("href")로 href 태그 값을 얻어와 해당 기사 URL을 얻어올 수 있다.
//		기사 URL을 다시 Jsoup.connect()해 링크를 들어간다면, 기사 본문을 크롤링 할 수 있을 것이다.
//	    element.toString()은 파싱한 태그 값 전체를 출력하고, element.text()는 파싱한 태그의 title 값만 출력할 수 있다.
	}
}
