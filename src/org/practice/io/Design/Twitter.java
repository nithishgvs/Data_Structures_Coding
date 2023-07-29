package org.practice.io.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {


  Map<Integer, Set<Integer>> followerMap;

  PriorityQueue<TweetData> tweetDataHeap;

  public Twitter() {
    followerMap = new HashMap<>();
    tweetDataHeap = new PriorityQueue<>((a, b) -> b.timeStamp.compareTo(a.timeStamp));
  }

  public void postTweet(int userId, int tweetId) {
    tweetDataHeap.add(new TweetData(System.nanoTime(), userId, tweetId));
  }

  public List<Integer> getNewsFeed(int userId) {
    int count = 0;
    List<Integer> newsFeedList = new ArrayList<>();
    List<TweetData> poppedList = new ArrayList<>();
    while (!tweetDataHeap.isEmpty()) {
      if (count == 10) {
        break;
      }
      TweetData tweetData = tweetDataHeap.poll();
      poppedList.add(tweetData);
      if (tweetData.userId == userId || followerMap.getOrDefault(tweetData.userId, new HashSet<>())
          .contains(userId)) {
        newsFeedList.add(tweetData.tweetId);
        count++;
      }
    }
    poppedList.forEach(poppedEntry -> {
      tweetDataHeap.add(poppedEntry);
    });

    return newsFeedList;
  }

  public void follow(int followerId, int followeeId) {
    Set<Integer> followList = followerMap.getOrDefault(followeeId, new HashSet<>());
    followList.add(followerId);
    followerMap.put(followeeId, followList);
  }

  public void unfollow(int followerId, int followeeId) {
    Set<Integer> followList = followerMap.getOrDefault(followeeId, new HashSet<>());
    followList.remove(followerId);
    followerMap.put(followeeId, followList);
  }

  class TweetData {

    Long timeStamp;
    Integer userId;
    Integer tweetId;

    public TweetData(Long timeStamp, Integer userId, Integer tweetId) {
      this.timeStamp = timeStamp;
      this.userId = userId;
      this.tweetId = tweetId;
    }
  }

  public static void main(String[] args) {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    twitter.postTweet(1, 3);
    twitter.getNewsFeed(1);
  }

}
