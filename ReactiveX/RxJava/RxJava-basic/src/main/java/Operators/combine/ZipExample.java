package Operators.combine;

import common.Log;
import io.reactivex.rxjava3.core.Observable;

public class ZipExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.zip(
                Observable.just(100, 200, 300),
                Observable.just(10, 20, 30),
                Observable.just(1, 2, 3),
                (a, b, c) -> a + b + c );
        source.subscribe(Log::i);
    }
}