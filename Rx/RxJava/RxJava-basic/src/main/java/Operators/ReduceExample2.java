package Operators;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;


public class ReduceExample2 {
    public static void main(String[] args) {
        BiFunction<String, String, String> mergeBalls = (ball1, ball2) ->
                ball2 + "(" + ball1 + ")";

        String[] balls = {"1", "3", "5"};

        Maybe<String> source = Observable.fromArray(balls)
                .reduce(mergeBalls);
        source.subscribe(System.out::println);
    }
}
