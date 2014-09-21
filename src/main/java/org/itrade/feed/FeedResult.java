package org.itrade.feed;

public class FeedResult {
    private FeedType type;
    private String title;
    private String description;

    public FeedResult() {
    }

    public FeedType getType() {
        return type;
    }

    public FeedResult setType(FeedType type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FeedResult setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FeedResult setDescription(String description) {
        this.description = description;
        return this;
    }
}
