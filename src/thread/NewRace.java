package thread;


class CounterIncrease{
    int count = 0;

    public synchronized void increase(){
        count++;
    }

    public int getCount() {
        return count;
    }
}


class Test1 implements Runnable{

    CounterIncrease obj ;

    public Test1(CounterIncrease obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i =0 ;i<1000000 ; i++){
            obj.increase();
        }
    }
}

public class NewRace {

    public static void main(String[] args) throws InterruptedException {

        CounterIncrease obj1 = new CounterIncrease();

        Thread t1 = new Thread(new Test1(obj1)); // thread is conataing test class and test class coantin incrwse clasds


        Thread t2 = new Thread(new Test1(obj1));


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("value from both thread = "+ obj1.getCount());




    }
}
