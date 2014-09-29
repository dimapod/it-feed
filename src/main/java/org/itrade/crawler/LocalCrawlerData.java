package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.Page;

import java.util.ArrayList;
import java.util.List;

public class LocalCrawlerData {
    private List<Page> pages = new ArrayList<>();

    public void add(Page page) {
        pages.add(page);
    }

    public List<Page> getPages() {
        return pages;
    }
}
