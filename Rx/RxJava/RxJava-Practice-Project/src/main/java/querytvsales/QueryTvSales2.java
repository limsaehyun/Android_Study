package querytvsales;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class QueryTvSales2 {

    public static void main(String[] args) {
        List<Pair<String, Integer>> sales = new ArrayList<>();

        sales.add(Pair.of("TV", 2500));
        sales.add(Pair.of("Camera", 300));
        sales.add(Pair.of("TV", 1600));
        sales.add(Pair.of("Phone", 800));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                // 매출 데이터 중 TV 매출을 필터링함
                .filter(sale -> "TV".equals(sale.getKey()))
                .map(sale -> sale.getValue())

                // 매출의 합을 구함
                .reduce((sale1, sale2) -> sale1 + sale2);
        tvSales.subscribe(data -> System.out.println("TV Sales : $" + data));

    }
}
