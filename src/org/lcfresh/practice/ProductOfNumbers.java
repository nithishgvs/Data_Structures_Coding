package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.List;

//1352. Product of the Last K Numbers
public class ProductOfNumbers {

  List<Integer> list;

  public ProductOfNumbers() {
    list = new ArrayList<>();
  }

  public void add(int num) {
    list.add(0,num);
  }

  public int getProduct(int k) {

    int prod=1;
    int i=0;
    while(k>0) {
      prod*=list.get(i);
      k--;
      i++;
    }
    return prod;
  }

  public static void main(String[] args) {
    ProductOfNumbers productOfNumbers = new ProductOfNumbers();
    productOfNumbers.add(3);        // [3]
    productOfNumbers.add(0);        // [3,0]
    productOfNumbers.add(2);        // [3,0,2]
    productOfNumbers.add(5);        // [3,0,2,5]
    productOfNumbers.add(4);        // [3,0,2,5,4]
    System.out.println(productOfNumbers.getProduct(2)); // return 20.
    System.out.println(productOfNumbers
        .getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    System.out.println(productOfNumbers
        .getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    productOfNumbers.add(8);        // [3,0,2,5,4,8]
    System.out.println(productOfNumbers.getProduct(2));
  }

}
