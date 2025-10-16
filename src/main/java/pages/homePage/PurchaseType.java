package pages.homePage;

public enum PurchaseType {

    FIRSTPURCHASE("firstPurchase"),
    REPEATPURCHASE("repeatPurchase");

    private final String purchaseType;

    PurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    @Override
    public String toString() {
        return purchaseType;
    }

}
