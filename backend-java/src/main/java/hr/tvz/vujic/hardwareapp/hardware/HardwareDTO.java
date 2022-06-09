package hr.tvz.vujic.hardwareapp.hardware;

public class HardwareDTO {


    private final String code;
    private final String name;
    private final Double price;
    private final String type;
    private final Integer stock;

    public HardwareDTO(String code, String name, Double price, String type, Integer stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() { return type; }

    public Integer getStock() { return stock; }



    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
