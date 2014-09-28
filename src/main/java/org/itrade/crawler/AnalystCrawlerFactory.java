package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnalystCrawlerFactory {
    public static final String CRAWL_STORAGE_FOLDER = "/tmp/crawl/root/";

    @Autowired
    private CrawlerHandler crawlerHandler;

    public CrawlController startAnalystCrawlerController(int maxDepthOfCrawling, int maxPagesToFetch) {
        CrawlController controller = newCrawlController(maxDepthOfCrawling, maxPagesToFetch);

        controller.setCustomData(crawlerHandler);

        // Seed urls: the first URL that are fetched and then the crawler starts following links which are found
        controller.addSeed("http://www.thestreet.com/headlines-and-perspectives/analyst-upgrades-downgrades/index.html");
        controller.startNonBlocking(AnalystCrawler.class, 5);
        return controller;
    }

    private CrawlController newCrawlController(int maxDepthOfCrawling, int maxPagesToFetch) {
        CrawlConfig config = new CrawlConfig();
        // Storage folder for intermediate data
        config.setCrawlStorageFolder(CRAWL_STORAGE_FOLDER + new Date().getTime());
        config.setMaxDepthOfCrawling(maxDepthOfCrawling);
        config.setMaxPagesToFetch(maxPagesToFetch);

        // Instantiate the controller for this crawl.
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);

        CrawlController controller;
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            throw new CrawlerException("Exception when initialising analyst crawler controller", e);
        }
        return controller;
    }

}
