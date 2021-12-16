package Observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ObservableFromFuture {
    public static void main(String[] args) {
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            // call() 메서드는 인자가 없으므로 () -> {} 형태로 나타낸다
            Thread.sleep(1000);
            return "Hello World!";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(data -> System.out.println(data));
    }
}
