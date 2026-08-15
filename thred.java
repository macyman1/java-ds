 class Printer {
    synchronized void printMessage(String msg) {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(" ]");
    }
}

class MyThread extends Thread {
    Printer p;
    String msg;

    MyThread(Printer p, String msg) {
        this.p = p;
        this.msg = msg;
    }

    @Override
    public void run() {
        p.printMessage(msg);
    }
}

public class thred {
    public static void main(String[] args) {
        Printer p = new Printer();

        MyThread t1 = new MyThread(p, "Hello");
        MyThread t2 = new MyThread(p, "World");

        t1.start();
        t2.start();
    }
}
