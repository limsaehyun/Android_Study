package Operators;

import io.reactivex.rxjava3.core.Observable;

public class FilterExample2 {
    public static void main(String[] args) {
        Integer[] data = {100, 34, 27, 99, 50};
        Observable<Integer> source = Observable.fromArray(data)
                .filter(num -> num % 2 == 0);
        source.subscribe(System.out::println);
    }
}
