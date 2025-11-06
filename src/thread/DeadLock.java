package thread;
class Resource{

}

public class DeadLock {
    public static void main(String[] args) {
       Resource r1 = new Resource();
       Resource r2 = new Resource();


       Thread t1 = new Thread(()->{
          synchronized (r1){
              System.out.println("Holding r1 and waiting for R2");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              synchronized (r2){
                  System.out.println("demanding R2");
              }
          }
       });


        Thread t2 = new Thread(()->{
            synchronized (r2){
                System.out.println("Holding r2 and waiting for R1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (r1){
                    System.out.println("demanding R1");
                }
            }
        });



        t1.start();
        t2.start();

    }
}
