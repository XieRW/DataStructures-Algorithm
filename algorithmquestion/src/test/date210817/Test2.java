package test.date210817;

/**
 * 继承Thread类创建线程
 */
public class Test2 extends Thread{
    //重写run方法，run方法的方法体就是现场执行体
    public void run(){
        for (int i = 0;i < 100; i++) {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i == 20){
                new Test2().start();
                new Test2().start();
            }
        }
    }
}
