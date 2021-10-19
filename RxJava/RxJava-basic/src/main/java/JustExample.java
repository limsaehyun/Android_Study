import io.reactivex.rxjava3.core.Observable;

public class JustExample {
    public static void main(String[] args) {
        JustExample demo = new JustExample();
        demo.emit();
    }

    private void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
    }
}
