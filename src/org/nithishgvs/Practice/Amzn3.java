package org.nithishgvs.Practice;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Amzn3 {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

  public class Stats {

    int times;
    Set<Integer> numberOfReviews;
    String word;

    public Stats(int times, Set<Integer> numberOfReviews, String word) {
      this.times = times;
      this.numberOfReviews = numberOfReviews;
      this.word = word;
    }
  }

  public ArrayList<String> topNCompetitors(int numCompetitors,
      int topNCompetitors,
      List<String> competitors,
      int numreviews,
      List<String> reviews) {
    // WRITE YOUR CODE HERE
    //Final output list to return
    ArrayList<String> output = new ArrayList<String>();

    Set<String> currentSet = new HashSet<>();

    for (String toy : competitors) {
      currentSet.add(toy);
    }

    Map<String, Stats> map = new HashMap<>();


    PriorityQueue<Stats> priorityQueue=new PriorityQueue<>(new Comparator<Stats>() {
      @Override
      public int compare(Stats a, Stats b) {
        if (a.times == b.times && a.numberOfReviews.size() != b.numberOfReviews.size()) {
          return b.numberOfReviews.size() - a.numberOfReviews.size();
        } else if (a.times == b.times && a.numberOfReviews.size() == b.numberOfReviews.size()) {
          return a.word.compareTo(b.word);
        }
        return b.times - a.times;
      }
    });



    for (int index = 0; index < reviews.size(); index++) {
      String quote = reviews.get(index);
      quote = quote.toLowerCase().replaceAll("[^a-z\\s]", "");

      String[] split = quote.split("\\s+");

      for (int i = 0; i < split.length; i++) {
        if (currentSet.contains(split[i])) {
          if (!map.containsKey(split[i])) {
            Set<Integer> set = new HashSet();
            set.add(index);
            map.put(split[i], new Stats(1, set, split[i]));
          } else {
            Stats stats = map.get(split[i]);
            if (stats.numberOfReviews.add(index)) {
              stats.times = stats.times + 1;
            }
          }
        }
      }
    }

      for (Map.Entry<String, Stats> entry : map.entrySet()) {
        priorityQueue.add(entry.getValue());
      }

      int i = 0;

      while (!priorityQueue.isEmpty() && i < topNCompetitors) {
        Stats stats = priorityQueue.poll();
        i++;
        output.add(stats.word);
      }

      return output;

    }
    // METHOD SIGNATURE ENDS
  }