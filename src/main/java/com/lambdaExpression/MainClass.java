package com.lambdaExpression;

interface Lambda{
    void hello();

}
interface StringLength{
    int func(String s);
}
public class MainClass {
    public static void printLambda(StringLength l){
        System.out.println(l.func("Hello there!"));
    }
  public static void main(String[] args) {
      Lambda variable = () -> System.out.println("Hello Worlds!");
      Lambda varNew= new Lambda(){
          @Override
          public void hello(){
              System.out.println("hello innerclass");
          }

      };
      varNew.hello();//both are not same
      variable.hello(); // compiler tries to defines the type of lambdda based on left side of arguements
      printLambda(s->s.length());

  }

}
