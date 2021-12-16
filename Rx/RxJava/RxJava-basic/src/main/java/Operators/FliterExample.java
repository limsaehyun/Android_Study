package Operators;


import io.reactivex.rxjava3.core.Observable;

public class FliterExample {
    public static void main(String[] args) {
        String[] objs = {"1 CIRCLE", "2 DIAMOND", "3 TRINAGLE",
                "4 DIAMOND", "5 CIRCLE", "6 HEXAGON"};
        Observable<String> source = Observable.fromArray(objs)
                .filter(obj -> obj.endsWith("CIRCLE"));
        source.subscribe(System.out::println);
    }
}
