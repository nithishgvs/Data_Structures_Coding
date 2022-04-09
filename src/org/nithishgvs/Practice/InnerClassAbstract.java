package org.nithishgvs.Practice;

public abstract class InnerClassAbstract {

  public abstract void test();

  public static void main(String[] args) {
    InnerClassAbstract innerClassAbstract = new InnerClassAbstract() {
      @Override
      public void test() {
        System.out.println("From class");
      }
    };

    innerClassAbstract.test();
  }

}
