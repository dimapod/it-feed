package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;

interface CrawlerHandler {
    void onDocumentFound(Page page);
}
