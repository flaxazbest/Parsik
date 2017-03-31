package ua.azbest.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.azbest.part.Stone;
import ua.azbest.part.Videocard;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CoreParser extends Parser {

    private LinkedList<String> links;
    private LinkedList<Stone> cpu = null;

    public CoreParser() {
        links = new LinkedList<>();
    }

    @Override
    protected void parse() {
        cpu = new LinkedList<>();

        String firstPage = "http://hard.rozetka.com.ua/processors/c80083/page=3/";
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

                Element newsHeadlines = d.select(".g-price-uah").first();
                //Element newsHeadlines = d.select("itemprop").attr("priceCurrency");
                //String ppp = d.select("itemprop").attr("priceCurrency");
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

                    Stone s = Stone.newBuilder()
                            .setFullName(fullName)
                            .setPrice(p)
                            .setFamily(det.get("Семейство процессора"))
                            .setSocket(det.get("Тип разъема"))
                            .setCore(det.get("Количество ядер"))
                            .setGraphic(det.get("Интегрированная графика"))
                            .setFrequency(det.get("Внутренняя тактовая частота"))
                            .setBox(det.get("Тип упаковки"))
                            .setPin(det.get("Количество контактов"))
                            .setGeneration(det.get("Наименование ядра"))
                            .setLink(link)
                            .build();
                    cpu.add(s);
                    System.out.println("V" + i + " was added");
                }
            }

//            System.out.println(links);
            System.out.println(" page done.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Stone> getList() {
        parse();
        return cpu;
    }
}
