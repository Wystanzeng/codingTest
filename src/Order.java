/**
 * the order
 */
public class Order {

    // format for the order
    private String format;
    // quantity for the order
    private Integer quantity;

    public Order(String format, Integer quantity) {
        this.format = format;
        this.quantity = quantity;
    }

    /**
     * get the quantity for the order
     *
     * @return Integer the quantity for the order
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * get the format for the order
     *
     * @return string format for the order
     */
    public String getFormat() {
        return format;
    }
}
