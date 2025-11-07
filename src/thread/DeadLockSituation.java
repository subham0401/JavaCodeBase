package thread;

class ResSource{

}


public class DeadLockSituation {
    public static void main(String[] args) throws InterruptedException {
        ResSource r1 = new ResSource();
        ResSource r2 = new ResSource();



        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("T1: holding r1, wants r2");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                synchronized (r2) {
                    System.out.println("T1: got r2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r1) { // 👈 yaha bhi r1 hi lock ho raha
                System.out.println("T2: holding r2, wants r1"); // 👈 but yaha print r2 likh diya
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                synchronized (r2) {
                    System.out.println("T2: got r1"); // 👈 yaha bhi ulta
                }
            }
        });

        t1.start();
        t2.start();


    }
}
