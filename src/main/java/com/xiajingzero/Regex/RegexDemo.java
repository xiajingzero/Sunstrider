package com.xiajingzero.Regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XiaJing on 2018/9/8.
 */
public class RegexDemo {


    @Test
    public void getImage(){
        String str = "<p>这<img src=\"http://172.16.3.100\" />ueditor<img src=\"http://172.1623232342344234.3.100\" />/jsp/upload<img src=\"http://172.23423423423416.3.100\" />/image/20180605/1528191743999007449.jpg\" title=\"1528191743999007449.jpg\" alt=\"123.jpg\"/><span></span/>ccasacac</p>";
        String regEx="(<img.*?>)";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test_25(){
        String str = "<p>这<a src=\"11111\" ><imgf styfsdfdtsdf src=\"http://172.16.3.100\" />uedit<a src=\"22222\" >or<img src=\"http://172.1623232342344234.3.100\" />/jsp/<a src=\"11111\" >upload<img src=\"http://172.23423423423416.3.100\" />/image/20180605/1528191743999007449.jpg\" title=\"1528191743999007449.jpg\" alt=\"123.jpg\"/><span></span/>ccasacac</p>";
        String regEx="(?<=(<img[^>]{1,100}?src=\"))[^\"]*?(?=\")";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test_a(){
        String url = "请点击<a href='http://www.baidu.com'>百度</a>进行查看";
        System.out.println(url.replaceAll("</?a.*?>", ""));
    }
}
