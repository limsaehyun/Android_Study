public class AsynchroExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            method1();
        });
        Thread t2 = new Thread(() -> {
            method2();
        });
        Thread t3 = new Thread(() -> {
            method3();
        });

        t.start();
        t2.start();
        t3.start();

    }

    private static void method1() {
        System.out.println("method1");
    }

    private static void method2() {
        System.out.println("method2");
    }

    private static void method3() {
        System.out.println("method3");
    }

}
