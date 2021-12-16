package Operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class FlatMapExample {
    public static void main(String[] args) {
        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball + "◆", ball + "◆");

        String[] balls = {"1", "3", "5"};

        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);
        source.subscribe(data -> System.out.println("main | value = " + data));
    }
}
