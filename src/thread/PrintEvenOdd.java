package thread;

// very very Important



class PrintEvensOdds{
    int count = 0 ;

    public void printEven()  {
          synchronized (this){
              while(count <101){
                  if(count %2==1){
                      try {
                          wait();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }
                  }
                  if (count<101){
                      System.out.println("evevn "+ count);
                      count++;
                      notify();
                  }
              }
          }
    }



    public void printOdd()  {
        synchronized (this){
            while(count <101){

                if(count %2==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count<101){
                    System.out.println("evevn "+ count);
                    count++;
                    notify();
                }
            }

        }
    }


}






public class PrintEvenOdd {

    public static void main(String[] args) {

        PrintEvensOdds obj = new PrintEvensOdds();



        Thread t1 =  new Thread(()->obj.printOdd());
        Thread t2 =  new Thread(()-> obj.printEven());


        t1.start();
        t2.start();


    }
}
