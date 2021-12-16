package Operators.create;

import common.Log;
import io.reactivex.rxjava3.core.Observable;

public class RangeExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 10)
                .filter(number -> number % 2 == 0);
        source.subscribe(Log::it);
    }
}
