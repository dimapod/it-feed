package org.itrade.controller;

import org.itrade.crawler.CrawlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrawlerController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CrawlerManager crawlerManager;

    @RequestMapping(value = "/crawler/analyst/thestreet/start", method = RequestMethod.GET)
    @ResponseBody
    public String startCrawlerTheStreet() {
        logger.info("Start crawl 'The Street'...");
        crawlerManager.startNewCrawler();
        return "Crawler started";
    }

    @RequestMapping(value = "/crawler/analyst/thestreet/count", method = RequestMethod.GET)
    @ResponseBody
    public String countCrawlersTheStreet() {
        return "Active crawlers: " + crawlerManager.getActiveControllers().size();
    }

}
