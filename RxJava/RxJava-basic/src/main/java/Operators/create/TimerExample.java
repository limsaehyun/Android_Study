package Operators.create;

import Operators.common.CommonUtils;
import Operators.common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimerExample {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
                .map(notUsed -> {
                    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                            .format(new Date());
                });
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
