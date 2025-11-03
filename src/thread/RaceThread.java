package thread;

class IncreaseCout {
    int  count = 0;

    public void increaseCount() {
        // yahi pe race condition aayegi
        count++;  // read -> increment -> write
    }

    public int getCount() {
        return count;
    }
}

class Test implements Runnable {
    private IncreaseCout obj;

    // shared object ka reference constructor se le rahe
    public Test(IncreaseCout obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            obj.increaseCount();
        }
    }
}

public class RaceThread {
    public static void main(String[] args) throws InterruptedException {
        IncreaseCout obj = new IncreaseCout(); // ye hi shared hoga

        Thread t1 = new Thread(new Test(obj));
        Thread t2 = new Thread(new Test(obj));

        t1.start();
        t2.start();

        // dono ka kaam khatam hone ka wait
        t1.join();
        t2.join();

        System.out.println("Final count: " + obj.getCount());
    }
}
