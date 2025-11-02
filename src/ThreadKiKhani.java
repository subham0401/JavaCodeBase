
// By extedning thread class and override run method

class Akshay extends Thread {
    @Override
    public void run(){
        System.out.println("akshay ****************");
    }

}

class Test implements Runnable{
    @Override
    public void run() {
       int count = 0 ;
       for(int i = 0 ; i<10000;i++){
           count++;
       }
        System.out.println("count = "+ count);
    }
}

public class ThreadKiKhani {
    public static void main(String[] args) {
//        Akshay obj = new Akshay();
//        obj.run(); // just normal calling
//        obj.start();

      Test obj = new Test();
      Thread t1 = new Thread(obj);

      Thread t2 = new Thread(obj);

        t1.start();
        System.out.println("t1");

        t2.start();
        System.out.println("t2");











    }
}
