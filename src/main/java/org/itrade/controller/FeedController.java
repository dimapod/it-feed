package org.itrade.controller;

import org.itrade.feed.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "/googlenews/rss", method = RequestMethod.GET)
    @ResponseBody
    public String googleNewsRss() {
        logger.debug("Fetch google news rss feed");
        int count = feedService.fetchGoogleNews();
        return "Fetched " + count + " articles";
    }

}
