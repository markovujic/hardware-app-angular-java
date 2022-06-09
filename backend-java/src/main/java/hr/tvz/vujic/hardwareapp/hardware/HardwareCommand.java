package hr.tvz.vujic.hardwareapp.hardware;

import javax.validation.constraints.*;

public class HardwareCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    private String code;

    @NotNull(message = "Price must be entered")
    @Positive(message = "Price must be entered as a positive double")
    private Double price;

    @NotBlank(message = "Type must not be empty")
    @Pattern(message = "Type must be CPU, GPU, MBO, RAM, STORAGE or OTHER",
            regexp = "CPU|GPU|MBO|RAM|STORAGE|OTHER")
    private String type;

    @NotNull(message = "Number of pieces in stock must be entered")
    @PositiveOrZero(message = "Number of pieces in stock must be entered as a positive integer")
    private Integer stock;

    public HardwareCommand() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Integer getStock() {
        return stock;
    }

}
