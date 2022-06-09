package hr.tvz.vujic.hardwareapp.hardware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardwareTest {

    @Test
    void isPriceCommon_true() {
        Hardware hardware = new Hardware();
        hardware.setPrice(70.9);

        Assertions.assertTrue(hardware.isPriceCommon());
    }

    @Test
    void isPriceCommon_false() {
        Hardware hardware = new Hardware();
        hardware.setPrice(20.8);

        Assertions.assertFalse(hardware.isPriceCommon());
    }

    @Test
    void isPriceCommon_illegalArgument() {
        Hardware hardware = new Hardware();
        hardware.setPrice(-1.1);

        Assertions.assertThrows(IllegalArgumentException.class, hardware::isPriceCommon);
    }

    @Test
    void isStockCommon_true() {
        Hardware hardware = new Hardware();
        hardware.setStock(5);

        Assertions.assertTrue(hardware.isStockCommon());
    }

    @Test
    void isStockCommon_false() {
        Hardware hardware = new Hardware();
        hardware.setStock(0);

        Assertions.assertFalse(hardware.isStockCommon());
    }

    @Test
    void isStockCommon_illegalArgument() {
        Hardware hardware = new Hardware();
        hardware.setStock(-1);

        Assertions.assertThrows(IllegalArgumentException.class, hardware::isStockCommon);
    }









}