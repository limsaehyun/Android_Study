package Operators.create;

import Operators.common.CommonUtils;
import common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class IntervalRangeExample {
    public static void main(String[] args) {
        Observable<Long> source = Observable.intervalRange(1,
                5,
                100L,
                100L,
                TimeUnit.MILLISECONDS);
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
