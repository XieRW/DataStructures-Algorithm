package test.date210817;

/**
 * 内部类实现线程设计，4个线程，其中,一个线程对j增加1，两个线程每次对j增加1，另外两个线程对j每次减少1
 */
public class Test1 {
    private int j;
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Inc inc = test1.new Inc();
        Dec dec = test1.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test1.inc();
            }
        });
        t2.start();
    }
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }
    class Inc implements Runnable{
        public void run(){
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable{
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
