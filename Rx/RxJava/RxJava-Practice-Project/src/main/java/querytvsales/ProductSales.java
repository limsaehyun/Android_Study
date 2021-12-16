package querytvsales;

public class ProductSales {

    private String mProduct;
    private int mSale;

    public ProductSales(String mProduct, int mSale) {
        this.mProduct = mProduct;
        this.mSale = mSale;
    }

    public String getmProduct() {
        return mProduct;
    }

    public int getmSale() {
        return mSale;
    }

    public void setmProduct(String mProduct) {
        this.mProduct = mProduct;
    }

    public void setmSale(int mSale) {
        this.mSale = mSale;
    }

}
