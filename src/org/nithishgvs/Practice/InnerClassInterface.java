package org.nithishgvs.Practice;

public interface InnerClassInterface {

   void test();

   static void main(String[] args) {
    InnerClassInterface innerClassInterface = new InnerClassInterface() {
      @Override
      public void test() {
        System.out.println("From Interface");
      }
    };
    innerClassInterface.test();
  }

}
