package Observable.ObsdervableFromIterable.ObservableFromIterableBlockingQueue;

public class Order {
    private String mId;

    public String getmId() {
        return mId;
    }

    public Order(String mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Order ID: " + mId;
    }
}
