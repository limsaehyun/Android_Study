import io.reactivex.rxjava3.core.Observable;

public class FirstExample {
    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }

    private void emit() {
        Observable.just("Hello", "RxJava2!!")
                .subscribe(System.out::println);
    }

}
