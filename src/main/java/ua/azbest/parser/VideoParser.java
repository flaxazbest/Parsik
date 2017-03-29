package ua.azbest.parser;

import azbest.parts.Videocard;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.stream.events.EndElement;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class VideoParser {

    private LinkedList<String> links;
    private LinkedList<Videocard> videocards;
    private HashSet<String> chipsets;

    public VideoParser() {
        links = new LinkedList<>();
        videocards = new LinkedList<>();
        chipsets = new HashSet<>();
    }

    public HashSet<String> getChipsets() {
        return chipsets;
    }

    public HashSet<String> getChipsetsFromFile() {
        HashSet<String> hs = new HashSet<>();
        LinkedList<Videocard> vc =  new LinkedList<>();

        try (FileInputStream streamIn = new FileInputStream("videocards.dat");
             ObjectInputStream objectinputstream = new ObjectInputStream(streamIn)) {

            Videocard readCase = null;
            do {
                readCase = (Videocard) objectinputstream.readObject();
                if(readCase != null){
                    vc.add(readCase);
                }
            } while (readCase != null);


        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Videocard v:vc) {
            HashMap<String, String> hm = v.getDetail();
            for (Map.Entry<String, String> e: hm.entrySet()) {
                if (e.getKey().equals("Графический чип"))
                    chipsets.add(e.getKey());
            }

        }

        return hs;
    }

    public void parse() {

        chipsets.clear();

        String firstPage = "http://hard.rozetka.com.ua/videocards/c80087/";
        Document doc = null;
        try {
            doc = Jsoup.connect(firstPage).get();
            Elements references = doc.select(".g-i-tile-i-title.clearfix");

           // for (int i=0; i<references.size(); i++) {
            for (int i=0; i<4; i++) {
                String link = references.get(i).children().select("a").attr("href") + "#tab=characteristics";
                Document d = Jsoup.connect(link).get();
                links.add(link);
                //#tab_content > div > div.pp-tab-aside > div > div > div > div:nth-child(2) > div > div.pp-carriage-good-middle > div > div.inline.pp-carriage-goods-box > div.detail-price-uah.pp-carriage-good-price

                Element newsHeadlines = d.select(".g-kit-price-uah").first();
                if (newsHeadlines != null) {
                    String price = newsHeadlines.text().replaceAll("[^0-9]", "");
                    int p = Integer.parseInt(price);
                    //Element eManufacture = d.select(".detail-tabs-i-title-inner").first();

                    Elements el = d.select(".detail-chars-l-i-title");
                    Elements fields = d.select(".detail-chars-l-i-field");

                    HashMap<String, String> det = new HashMap<>();
                    for (int k=0; k<el.size(); k++) {
                        String title = el.get(k).text();
                        String field = fields.get(k).text();
                        if (title.equals("Графический чип"))
                            chipsets.add(field);
                        det.put(title, field);
                    }

                    String fullName = d.select(".detail-tabs-i-title-inner").first().text();
                    String manufacture = fullName.split(" ")[0];

                    Videocard v = new Videocard(fullName, manufacture, p, det);
                    videocards.add(v);
                    //System.out.println(v);
                }

            }

            System.out.println(links);
            System.out.println("===============");
            //System.out.println(videocards);


            //* // serialize objacts

            ObjectOutputStream oos = null;
            FileOutputStream fout = null;
            try{
                FileOutputStream fileOut = new FileOutputStream("videocards.dat", true);
                ObjectOutputStream ooos = new ObjectOutputStream(fileOut);
                for (Videocard v: videocards)
                    ooos.writeObject(v);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if(oos  != null){
                    oos.close();
                }
            }

            //*/


        } catch (IOException e) {
            e.printStackTrace();
        }
//*/
        /*
        HashMap<String, String> prop = new HashMap<>();

        Document doc = null;
        try {
            //doc = Jsoup.connect("http://hard.rozetka.com.ua/asus_gt730-2gd3/p1436042/#tab=characteristics").get();
            doc = Jsoup.connect("http://hard.rozetka.com.ua/asus_turbo_gtx1080_8g/p9964049/#tab=characteristics").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element newsHeadlines = doc.select(".g-kit-price-uah").first();
        //Element newsHeadlines = doc.select(".g-kit-total-price-uah").last();
        //Element newsHeadlines = doc.select(".detail-price-uah").first();
        //Elements newsHeadlines = doc.select(".g-kit-total-price-uah");
        String price = newsHeadlines.text().replaceAll("[^0-9]", "");

        Element eManufacture = doc.select(".detail-tabs-i-title-inner").first();
        String manufacture = eManufacture.text().split(" ")[0];

        Elements all = doc.select(".detail-chars-l");
        Elements propValue = all.get(0).select(".detail-chars-l-i-field");
        Elements propName = all.get(0).select(".detail-chars-l-i-title");
        for (int i=0; i<propName.size(); i++) {
            prop.put(propName.get(i).text(), propValue.get(i).text());
        }

        System.out.println(manufacture);


        System.out.println(price);
        System.out.println(prop);

        //*/



    }
}