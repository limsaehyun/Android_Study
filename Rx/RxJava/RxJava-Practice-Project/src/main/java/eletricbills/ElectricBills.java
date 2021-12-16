package eletricbills;

import static java.lang.Math.max;
import static java.lang.Math.min;

import common.Log;
import io.reactivex.rxjava3.core.Observable;
import java.text.DecimalFormat;

public class ElectricBills {

    private static int index = 0;

    public static void eletricBillV1() {
        String[] data = {
                "100", // 910 + 93.3 * 100 = 10,240
                "300"  // 1600 + 93.3 * 200 + 187.9 * 100 = 39.050
        };

        Observable<Integer> basePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                    if (val <= 200) return 910;
                    if (val <= 400) return 1600;
                    return 7300;
                });

        Observable<Integer> usagePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                    double series1 = min(200, val) * 93.3;
                    double series2 = min(200, max(val - 200, 0)) * 187.9;
                    double series3 = max(0, max(val - 400, 0)) * 280.65;
                    return (int) (series1 + series2 + series3);
                });

        Observable<Integer> source = Observable.zip(
                basePrice,
                usagePrice,
                (v1, v2) -> v1 + v2
        );

        source.map(val -> new DecimalFormat("#,###").format(val))
                .subscribe(val -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Usage: " + data[index]);
                    sb.append("Price: " + val + "원");

                    Log.i(sb.toString());

                    index++;
                });
    }

    public static void main(String[] args) {
        eletricBillV1();
    }

}
