package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;

import java.util.ArrayList;
import java.util.List;

public class CrawlerWaiter implements Runnable {

    private final CrawlerHandler crawlerHandler;
    private final CrawlController crawlController;

    public CrawlerWaiter(CrawlController crawlController, CrawlerHandler crawlerHandler) {
        this.crawlController = crawlController;
        this.crawlerHandler = crawlerHandler;
    }

    @Override
    public void run() {
        crawlController.waitUntilFinish();
        List<Object> crawlersLocalData = crawlController.getCrawlersLocalData();

        List<Page> pages = new ArrayList<>();
        for (Object object : crawlersLocalData) {
            pages.addAll(((LocalCrawlerData) object).getPages());
        }
        crawlerHandler.handleDocuments(pages);
    }
}
