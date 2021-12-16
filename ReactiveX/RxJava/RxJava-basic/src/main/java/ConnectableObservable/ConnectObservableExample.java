package ConnectableObservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectObservableExample {
    private static Thread CommonUtils;

    public static void main(String[] args) {
        String[] dt = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);
        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        source.connect();

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        source.subscribe(data -> System.out.println("Subscriber #3 => " + data));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
