package Observable;

import io.reactivex.rxjava3.core.Observable;

public class ObservableJustExample {
    public static void main(String[] args) {
        ObservableJustExample demo = new ObservableJustExample();
        demo.emit();
    }

    private void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
    }
}
