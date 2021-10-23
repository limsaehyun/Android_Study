package Operators.create;

import Operators.common.CommonUtils;
import Operators.common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class intervalRangeToInterval {
    public static void main(String[] args) {
        Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(val -> val + 1)
                .take(5);
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
