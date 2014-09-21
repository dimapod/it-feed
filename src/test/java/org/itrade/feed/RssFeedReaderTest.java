package org.itrade.feed;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RssFeedReaderTest {

    private RssFeedReader rssFeedReader;

    @Before
    public void setUp() throws Exception {
        rssFeedReader = new RssFeedReader();
    }

    @Test
    public void should_read_feed() {
        List<FeedResult> read = rssFeedReader.read("http://news.google.com/?output=rss");
        System.out.println(read);
    }

}