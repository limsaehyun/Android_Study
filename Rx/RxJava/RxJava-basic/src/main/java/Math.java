import common.Log;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Math {
    public static void main(String[] args) {
        Integer[] data = {1, 2, 3 ,4};

        // 1. count
        Single<Long> source = Observable.fromArray(data)
                .count();
        source.subscribe(count -> Log.i("count is " + count));

        // 2. max & min
        Flowable.fromArray(data)
                .to(MathFlowable::max)
                .subscribe(max -> Log.i("max is " + max));
        


    }
}
