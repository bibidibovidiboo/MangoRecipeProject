package com.sist.dao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RecommandData {
   
   public String weather()
   {
      String wd="";
      try {
         Document doc = Jsoup.connect("https://weather.naver.com/today").get();
         Elements tweather = doc.select(".weather_area .summary .weather");
         wd = tweather.text();
      } catch (Exception e) {
         e.printStackTrace();
      }
      System.out.println("오늘날씨:"+wd);
      return wd;
   }
}