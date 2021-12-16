package Operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class FileterSameExample {
    public static void main(String[] args) {
        Integer[] numbers = {100, 200, 300, 400, 500};
        Single<Integer> single;
        Observable<Integer> source;

        // first
        single = Observable.fromArray(numbers).first(-1);
        single.subscribe(data -> System.out.println("first() value = " + data));

        // last
        single = Observable.fromArray(numbers).last(-1);
        single.subscribe(data -> System.out.println("last() value = " + data));

        // take(N)
        source = Observable.fromArray(numbers).take(3);
        source.subscribe(data -> System.out.println("take() value = " + data));

        // takeLast(N)
        source = Observable.fromArray(numbers).takeLast(3);
        source.subscribe(data -> System.out.println("takeLast() value = " + data));

        // skip(N)
        source = Observable.fromArray(numbers).skip(2);
        source.subscribe(data -> System.out.println("skip() value = " + data));


        // skipLast(N)
        source = Observable.fromArray(numbers).skipLast(2);
        source.subscribe(data -> System.out.println("takeLast() value = " + data));

    }
}
