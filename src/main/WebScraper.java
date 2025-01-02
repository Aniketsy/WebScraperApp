package com.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void scrape(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements items = doc.select("a"); // Modify selector as needed
            for (Element item : items) {
                String title = item.text();
                String link = item.absUrl("href");
                System.out.println(title + " - " + link);

                // Save to DB
                DatabaseConnector.insertData(title, link);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
