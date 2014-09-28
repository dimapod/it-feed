package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.List;
import java.util.regex.Pattern;

public class AnalystCrawler extends WebCrawler {

    public final static Pattern ANALYST_ACTIONS = Pattern.compile(".*(analysts-actions-).*");
    public final static Pattern FILTERS =
            Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4"
                    + "|wav|avi|mov|mpeg|ram|m4v|pdf|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    private CrawlerHandler crawlerHandler;

    @Override
    public void onStart() {
        crawlerHandler = (CrawlerHandler) myController.getCustomData();
    }

    @Override
    public boolean shouldVisit(WebURL url) {
        String href = url.getURL().toLowerCase();
        //return !FILTERS.matcher(href).matches() && href.startsWith("http://www.ics.uci.edu/");
        return href.startsWith("http://www.thestreet.com/story/") && ANALYST_ACTIONS.matcher(href).matches() && !FILTERS.matcher(href).matches() ;
    }

    @Override
    public void visit(Page page) {
        //String url = page.getWebURL().getURL();
        if (page.getParseData() instanceof HtmlParseData) {
            //HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();

            crawlerHandler.onDocumentFound(page);
/*
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            List<WebURL> links = htmlParseData.getOutgoingUrls();
            System.out.println("=======================================================");
            System.out.println("URL: " + url);
            System.out.println("Text: " + text.length());
            System.out.println("Html: " + html.length());
            System.out.println("Links: " + links.size());
            System.out.println("=======================================================");
*/
        }
    }

    @Override
    public void onBeforeExit() {
        super.onBeforeExit();
        // Release reference for GC
        crawlerHandler = null;
    }
}
