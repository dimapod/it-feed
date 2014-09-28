package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrawlerManager {

    private List<CrawlController> controllerList = new ArrayList<>();

    @Autowired
    private AnalystCrawlerFactory analystCrawlerFactory;

    public void startNewCrawler() {
        CrawlController crawlController = analystCrawlerFactory.startAnalystCrawlerController(1, 20);
        controllerList.add(crawlController);
    }

    public List<CrawlController> getActiveControllers() {
        return controllerList.stream().filter(ctrl -> !ctrl.isFinished()).collect(Collectors.toList());
    }

}
