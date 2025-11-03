package abstarctvsinterface;


abstract class subham{
    public abstract void  dance();


    public int add(int a , int b){
        return a+b;
    }
}

interface Akshay {
    public void run();
    public void eat();

    default void play(){
        System.out.println("busdfweifcwe0[-");
    }

    static void play1(){
        System.out.println("busdfweifcwe0[-");
    }

}

// function interface


interface Test2{
    public void run();


    default void play(){
        System.out.println("busdfweifcwe0[-");
    }

    static void play1(){
        System.out.println("busdfweifcwe0[-");
    }

}


// constructor

abstract class Test4{
    public Test4(int a , int b) {
        System.out.println("I am in constructor");
    }
}



 class RunTest extends Test4{
     public RunTest(int a, int b) {
         super(a, b);
     }
 }



public class Test {

    public static void main(String[] args) {
        RunTest runTest = new RunTest(10,20);
    }
}
