package ua.azbest.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.azbest.part.Videocard;

import java.io.*;
import java.net.URL;
import java.util.*;

public class VideoParser {

    private LinkedList<String> links;
    private LinkedList<Videocard> videocards = null;


    public VideoParser() {
        links = new LinkedList<>();
    }

    private void parse() {
        videocards = new LinkedList<>();

    //for (int i=)

        String firstPage = "http://hard.rozetka.com.ua/videocards/c80087/page=8/";
        Document doc = null;
        try {
            doc = Jsoup.connect(firstPage).get();
            Elements references = doc.select(".g-i-tile-i-title.clearfix");

            //for (int i=0; i<5; i++) {
            for (int i=0; i<references.size(); i++) {
            //for (int i=0; i<3; i++) {
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
                        det.put(title, field);
                    }

                    String fullName = d.select(".detail-tabs-i-title-inner").first().text();
                    String manufacture = fullName.split(" ")[0];

                    Videocard v = Videocard.newBuilder()
                            .setFullName(fullName)
                            .setManufacture(manufacture)
                            .setPrice(p)
                            .setChip(det.get("Графический чип"))
                            .setFrequency(det.get("Частота памяти"))
                            .setCore(det.get("Частота ядра"))
                            .setVolume(det.get("Объем памяти"))
                            .setCooling(det.get("Система охлаждения"))
                            .setBit(det.get("Разрядность шины памяти"))
                            .setMemory(det.get("Тип памяти"))
                            .setDvi(det.get("Выходы DVI"))
                            .setResolution(det.get("Максимально поддерживаемое разрешение"))
                            .setApi3d(det.get("Поддерживаемые 3D API"))
                            .setIface(det.get("Интерфейс"))
                            .setPower(det.get("Дополнительное питание"))
                            .setDimm(det.get("Размеры"))
                            .setGarranty(det.get("Гарантия"))
                            .setLink(link)
                            .build();

                    //Videocard v = new Videocard(fullName, manufacture, p, det);
                    videocards.add(v);
                    System.out.println("V" + i + " was added");
                }
            }

//            System.out.println(links);
            System.out.println(" page done.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Videocard> getList() {
        parse();
        return videocards;
    }
}