package org.leetcode.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class BoatstoSavePeople_881 {


    public int numRescueBoats(int[] people, int limit) {

        int noOfBoats = 0;
        int l = 0, h = people.length - 1;
        int allDone = people.length;
        Arrays.sort(people);

        while (l <= h) {
            if (allDone == 0) {
                break;
            }
            if (l == h) {
                allDone--;
                noOfBoats++;
                people[l] = Integer.MIN_VALUE;
                continue;
            }
            int low = people[l];
            int high = people[h];
            if (low == limit) {
                people[l] = Integer.MIN_VALUE;
                l++;
                allDone--;
                noOfBoats++;
                continue;
            }
            if (high == limit) {
                people[h] = Integer.MIN_VALUE;
                h--;
                allDone--;
                noOfBoats++;
                continue;
            }
            if (low == Integer.MIN_VALUE) {
                l++;
                continue;
            }
            if (high == Integer.MIN_VALUE) {
                h--;
                continue;
            }
            if (low + high <= limit) {
                allDone = allDone - 2;
                people[h] = Integer.MIN_VALUE;
                people[l] = Integer.MIN_VALUE;
                l++;
                h--;
                noOfBoats++;
            } else if (low + high > limit) {
                allDone--;
                people[h] = Integer.MIN_VALUE;
                h--;
                noOfBoats++;
            }

        }

        return noOfBoats;

    }


    @Test
    public void test1() {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
    }

    @Test
    public void test2() {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    @Test
    public void test3() {
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    @Test
    public void test4() {
        System.out.println(numRescueBoats(new int[]{2, 2}, 6));
    }

    @Test
    public void test5() {
        System.out.println(numRescueBoats(new int[]{2, 4}, 5));
    }

    @Test
    public void test6() {
        System.out.println(numRescueBoats(new int[]{7, 3, 2}, 8));
    }
}
