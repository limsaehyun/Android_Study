import io.reactivex.rxjava3.core.Observable;

public class ObservableFirstExample {
    public static void main(String[] args) {
        ObservableFirstExample demo = new ObservableFirstExample();
        demo.emit();
    }

    private void emit() {
        Observable.just("Hello", "RxJava2!!")
                .subscribe(System.out::println);
    }

}
