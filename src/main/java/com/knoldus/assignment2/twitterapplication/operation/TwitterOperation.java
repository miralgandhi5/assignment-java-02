package com.knoldus.assignment2.twitterapplication.operation;


import com.knoldus.assignment2.twitterapplication.utilities.TwitterConfig;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class TwitterOperation {
    private Twitter twitter;

    public TwitterOperation() {
        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(TwitterConfig.consumerKey)
                .setOAuthConsumerSecret(TwitterConfig.consumerSecret)
                .setOAuthAccessToken(TwitterConfig.accessToken)
                .setOAuthAccessTokenSecret(TwitterConfig.accessSecret);
        TwitterFactory tweetFactory = new TwitterFactory(configBuilder.build());
        this.twitter = tweetFactory.getInstance();
    }

    /**
     * finds tweets based on hashtag.
     * @param hashTag on which find tweets.
     * @return CompletableFuture list of status.
     */
    public CompletableFuture<List<Status>> tweetsOnHashTag(String hashTag) {
        return CompletableFuture.supplyAsync(() -> {
            Query query = new Query(hashTag);
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return result != null ? result.getTweets() : null;

        }).exceptionally(ex -> Collections.emptyList());
    }

    /**
     * finds number of tweets based on hashtag.
     * @param hashTag hashTag on which count tweets.
     * @return CompletableFuture of integer.
     */

    public CompletableFuture<Integer> findNumberOfTweets(String hashTag) {
        return tweetsOnHashTag(hashTag).thenApply(List::size);
    }

    private long getDays(Date createdDate) {
        Date currentDate = new Date();
        long diff = currentDate.getTime() - createdDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    /**
     * finds average number of reTweets based on hashtag.
     * @param hashTag hashTag on which avg number of retweets.
     * @return completableFuture list of long.
     */

    public CompletableFuture<List<Long>> findAverageReTweets(String hashTag) {

        return tweetsOnHashTag(hashTag).thenApply(statuses -> statuses.stream().map(status -> ((status.getRetweetCount()) / (getDays(status.getCreatedAt()))))
                .collect(Collectors.toList())).exceptionally(ex -> Collections.emptyList());


    }

    /**
     * finds average number of likes for tweets based on hashtag.
     * @param hashTag hashTag on which number of likes for tweets.
     * @return completableFuture list of long.
     */

    public CompletableFuture<List<Long>> findAverageLikes(String hashTag) {

        return tweetsOnHashTag(hashTag).thenApply(statuses -> statuses.stream().map(status -> ((status.getFavoriteCount()) / (getDays(status.getCreatedAt()))))
                .collect(Collectors.toList())).exceptionally(ex -> Collections.emptyList());
    }


}
