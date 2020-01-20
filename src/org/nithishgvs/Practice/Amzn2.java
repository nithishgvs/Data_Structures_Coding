package org.nithishgvs.Practice;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Amzn2
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

  public class Position{
    int r;
    int c;
    public Position(int r,int c){
      this.r=r;
      this.c=c;
    }
  }
  int minimumDays(int rows, int columns, List<List<Integer> > grid)
  {
    // WRITE YOUR CODE HERE

    int days=0;

    int serversFound=0;

    int[][] diagnols={{-1,0},{0,1},{0,-1},{1,0}};

    Queue<Position> queue=new ArrayDeque<>();
    for(int row=0;row<grid.size();row++){
      for(int col=0;col<grid.get(0).size();col++){
        if(grid.get(row).get(col)==1){
          queue.add(new Position(row,col));
        }else{
          serversFound++;
        }
      }
    }

    while(!queue.isEmpty()){
      int size=queue.size();
      days++;

      for(int i=0;i<size;i++){
        Position position=queue.poll();
        for(int[] diagnol:diagnols){
          if(isSafe(position.r+diagnol[0],position.c+diagnol[1],grid)&&
              grid.get(position.r+diagnol[0]).get(position.c+diagnol[1])==0){
            serversFound--;
            if(serversFound==0){
              return days;
            }
            grid.get(position.r+diagnol[0]).set(position.c+diagnol[1],1);
            queue.add(new Position(position.r+diagnol[0],position.c+diagnol[1]));
          }
        }
      }
    }


    return days;
  }
  // METHOD SIGNATURE ENDS

  private boolean isSafe(int x,int y,List<List<Integer>> grid){
    if(x>-1 && x<grid.size() && y>-1&& y<grid.get(0).size()){
      return true;
    }
    return false;

  }
}
