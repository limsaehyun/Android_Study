package Operators.create;


import Operators.common.CommonUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class DeferExample {
    private static Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();

    public static void main(String[] args) {
        CommonUtils.exampleStart();

        Callable<Observable<String>> supplier = ()->getObservable();
        Observable<String> source = Observable.defer(supplier);

        source.subscribe(val -> System.out.println("subscriber #1 : " + val));
        source.subscribe(val -> System.out.println("subscriber #2 : " + val));
    }

    private static Observable<String> getObservable() {
        if(colors.hasNext()) {
            String color = colors.next();
            return Observable.just(color + "-B", color + "-R", color + "-P");
        }
        return Observable.empty();
    }
}
