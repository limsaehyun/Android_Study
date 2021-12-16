package Operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;


public class MapFuntionExample {

    public static void main(String[] args) {
        Function<String, String> getDiamond = ball -> ball + "◆";

        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(getDiamond);
        source.subscribe(System.out::println);
    }

}
