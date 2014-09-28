package org.itrade.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.itrade.commons.jms.ITradeMessageType;
import org.itrade.jms.JmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.itrade.commons.jms.ITradeMessageType.URL;

@Service
public class CrawlerHandlerImpl implements CrawlerHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JmsClient jmsClient;

    @Override
    public void onDocumentFound(Page page) {
        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
        String url = page.getWebURL().getURL();
        String text = htmlParseData.getText();
        String html = htmlParseData.getHtml();
        List<WebURL> links = htmlParseData.getOutgoingUrls();

        logger.debug("Document found. Url:{}, text:{}, html:{}, links:{}", url, text.length(), html.length(), links.size());
        jmsClient.sendMessageToInjection(url, URL, "ANALYST");
    }
}