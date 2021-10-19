package ObsdervableFromIterable.ObservableFromIterableBlockingQueue;

import io.reactivex.rxjava3.core.Observable;
import sun.security.provider.NativePRNG;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObservableFromIterableBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ABC-1"));
        orderQueue.add(new Order("DFG-2"));
        orderQueue.add(new Order("HIJ-3"));

        Observable<Order> source = Observable.fromIterable(orderQueue);

        source.subscribe(data -> System.out.println("Result : " + data.getmId()));

    }
}
