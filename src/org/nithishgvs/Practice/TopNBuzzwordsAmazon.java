package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.Test;

public class TopNBuzzwordsAmazon {


  public class QuoteStats {

    int times;
    Set<Integer> numQuotes;

    public QuoteStats(int times, Set<Integer> numQuotes, String quote) {
      this.times = times;
      this.numQuotes = numQuotes;
      this.quote = quote;
    }

    String quote;
  }


  public String[] topNBuzzWords(int numToys, int topToys, String[] toys, int numQuotes,
      String[] quotes) {
    String[] output = new String[topToys];

    Set<String> toySet = new HashSet<>();

    for (String toy : toys) {
      toySet.add(toy);
    }

    ArrayList list1=new ArrayList();

    Map<String, QuoteStats> map = new HashMap<>();

    PriorityQueue<QuoteStats> priorityQueue = new PriorityQueue<QuoteStats>((a, b) -> {
      if (a.times == b.times && a.numQuotes.size() != b.numQuotes.size()) {
        return b.numQuotes.size() - a.numQuotes.size();
      } else if (a.times == b.times && a.numQuotes.size() == b.numQuotes.size()) {
        return b.quote.compareTo(a.quote);
      }
      return b.times - a.times;
    });

    for (int index = 0; index < quotes.length; index++) {
      String quote = quotes[index];
      quote = quote.toLowerCase().replaceAll("[^a-z\\s]", "");
      String[] split = quote.split("\\s+");
      for (int i = 0; i < split.length; i++) {
        if (toySet.contains(split[i])) {
          if (!map.containsKey(split[i])) {
            Set<Integer> set = new HashSet<>();
            set.add(index);
            map.put(split[i], new QuoteStats(1, set, split[i]));
          } else {
            QuoteStats quoteStats = map.get(split[i]);
            quoteStats.times = quoteStats.times + 1;
            quoteStats.numQuotes.add(index);
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
      output[i++] = quoteStats.quote;
      System.out.println(quoteStats.quote + " " + quoteStats.times + " " + quoteStats.numQuotes);
    }

    return output;
  }


  @Test
  public void test() {
    String[] quotes = new String[]{
        "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
        "The new Elmo dolls are super high quality",
        "Expect the Elsa dolls to be very popular this year, Elsa!",
        "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
        "For parents of older kids, look into buying them a drone",
        "Warcraft is slowly rising in popularity ahead of the holiday season"};
    topNBuzzWords(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
        quotes);


  }
}
