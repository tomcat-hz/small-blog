package com.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/16 11:59
 */
@Component
public class HtmlParse {
    public static void main(String[] args) {
        HtmlParse htmlParse = new HtmlParse();
    }

    public String pwd(String keyword){
        String url = "https://baike.baidu.com/item/"+keyword;
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url), 2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements meta = document.getElementsByTag("meta").eq(3);
        String content = meta.attr("content");
        return content;
    }

    public String translate(String keyword){
        String url = "http://www.youdao.com/w/"+keyword;
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url), 2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements title = document.getElementsByClass("trans-container").eq(0);
        return title.text();
    }
}
