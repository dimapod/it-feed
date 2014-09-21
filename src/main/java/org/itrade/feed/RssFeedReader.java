package org.itrade.feed;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RssFeedReader {

    public List<FeedResult> read(String url) {
        try {
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            List<SyndEntry> entries = feed.getEntries();
            return entries.stream()
                    .map(entry -> new FeedResult().setDescription(entry.getDescription().getValue()).setTitle(entry.getTitle()).setType(FeedType.RSS))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new FeedException("Error when getting the feed: " + url, ex);
        }
    }

}
