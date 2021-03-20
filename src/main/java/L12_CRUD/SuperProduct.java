package L12_CRUD;

public abstract class SuperProduct {
    private static Long counterID = 0L;
    public Long id;
    private Model model = new Model();
    public Currency currency = model.getDefoultCurrency();

    public SuperProduct() {
        id = ++counterID;

    }
}
