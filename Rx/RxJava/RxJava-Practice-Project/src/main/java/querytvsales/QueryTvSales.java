package querytvsales;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class QueryTvSales {

    public static void main(String[] args) {
        List<ProductSales> sales = new ArrayList<>();

        sales.add(new ProductSales("TV", 2500));
        sales.add(new ProductSales("Camera", 300));
        sales.add(new ProductSales("TV", 1600));
        sales.add(new ProductSales("Phone", 800));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                // 매출 데이터 중 TV 매출을 필터링함
                .filter(sale -> "TV".equals(sale.getmProduct()))
                .map(sale -> sale.getmSale())
                .reduce((sale1, sale2) -> sale1 + sale2);
        tvSales.subscribe(data -> System.out.println("TV Sales : $" + data));

    }
}
