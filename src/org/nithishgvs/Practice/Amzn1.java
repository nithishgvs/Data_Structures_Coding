package org.nithishgvs.Practice;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Amzn1 {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

  public class QuoteStats {

    int times;
    Set<Integer> numberOfQuotes;
    String word;

    public QuoteStats(int times, Set<Integer> numberOfQuotes, String word) {
      this.times = times;
      this.numberOfQuotes = numberOfQuotes;
      this.word = word;
    }
  }

  public ArrayList<String> popularNToys(int numToys,
      int topToys,
      List<String> toys,
      int numQuotes,
      List<String> quotes) {
    // WRITE YOUR CODE HERE
    //Final output list to return
    ArrayList<String> output = new ArrayList<String>();

    Set<String> toySet = new HashSet<>();

    for (String toy : toys) {
      toySet.add(toy);
    }

    Map<String, QuoteStats> map = new HashMap<>();

    PriorityQueue<QuoteStats> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (a.times == b.times && a.numberOfQuotes.size() != b.numberOfQuotes.size()) {
        return b.numberOfQuotes.size() - a.numberOfQuotes.size();
      } else if (a.times == b.times && a.numberOfQuotes.size() == b.numberOfQuotes.size()) {
        return a.word.compareTo(b.word);
      }
      return b.times - a.times;
    });

    for (int index = 0; index < quotes.size(); index++) {
      String quote = quotes.get(index);
      quote = quote.toLowerCase().replaceAll("[^a-z\\s]", "");

      String[] split = quote.split("\\s+");

      for (int i = 0; i < split.length; i++) {
        if (toySet.contains(split[i])) {
          if (!map.containsKey(split[i])) {
            Set<Integer> set = new HashSet();
            set.add(index);
            map.put(split[i], new QuoteStats(1, set, split[i]));
          } else {
            QuoteStats quoteStats = map.get(split[i]);
            if (quoteStats.numberOfQuotes.add(index)) {
              quoteStats.times = quoteStats.times + 1;
            }
          }
        }
      }
    }

      for (Map.Entry<String, QuoteStats> entry : map.entrySet()) {
        priorityQueue.add(entry.getValue());
      }

      int i = 0;

      while (!priorityQueue.isEmpty() && i < topToys) {
        QuoteStats quoteStats = priorityQueue.poll();
        i++;
        output.add(quoteStats.word);
      }

      return output;

    }
    // METHOD SIGNATURE ENDS
  }