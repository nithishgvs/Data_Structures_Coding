package org.nithishgvs.Practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class CallablePrac implements Callable<String> {

  private final String name;

  public CallablePrac(String name) {
    this.name = name;
  }


  @Override
  public String call() throws Exception {
    Thread.sleep(100);
    return "This name is: " + name;
  }
}

public class ExecServicePractice {


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    System.out.println(System.currentTimeMillis());
    Future<String> future = executorService.submit(new CallablePrac("Sai"));
    System.out.println(System.currentTimeMillis());
    System.out.println(System.currentTimeMillis());
    System.out.println("Result:" + future.get());
    executorService.shutdown();

  }

}
