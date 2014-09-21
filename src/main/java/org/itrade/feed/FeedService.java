package org.itrade.feed;

import org.itrade.jms.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private RssFeedReader rssFeedReader;

    @Autowired
    private JmsClient jmsClient;

    public int fetchGoogleNews() {
        List<FeedResult> feedResults = rssFeedReader.read("http://news.google.com/?output=rss");
        feedResults.forEach(result -> jmsClient.sendMessageToInjection(result.getDescription(), result.getType().name()));
        return feedResults.size();
    }

}
