package com.knoldus.assignment2.twitterapplication;

import com.knoldus.assignment2.twitterapplication.operation.TwitterOperation;

public class TwitterApplication {

    public static void main(String[] args) {

        String hashTag = "#cool";

        TwitterOperation twitterOperation = new TwitterOperation();
        twitterOperation.tweetsOnHashTag(hashTag).thenAccept(statuses -> statuses.forEach(System.out::println));
        twitterOperation.findNumberOfTweets(hashTag).thenAccept(System.out::println);
        twitterOperation.findAverageLikes(hashTag).thenAccept(longs -> longs.forEach(System.out::println));
        twitterOperation.findAverageReTweets(hashTag).thenAccept(longs -> longs.forEach(System.out::println));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

