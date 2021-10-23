package Operators.create;

import Operators.common.CommonUtils;
import Operators.common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class IntervalExample2 {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        Observable<Long> source = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
                .map(val -> val + 100)
                .take(5);
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
