package Observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableDIsposableExample {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");

        Disposable d = source.subscribe(
                v -> System.out.println("onNext() : value : " + v),
                err -> System.out.println("onError : value : " + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("isDisposed : " + d.isDisposed());
    }
}
