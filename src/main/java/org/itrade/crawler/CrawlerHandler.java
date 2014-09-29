package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;

import java.util.List;

interface CrawlerHandler {
    void onFinished(List<Page> foundPages);
    void onDocumentFound(Page page);
}
