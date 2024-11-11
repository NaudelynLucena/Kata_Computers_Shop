package com.factoriaf5.model;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setUp() {
        computer = new Computer(1L, "Apple", 16, "Intel i7", "macOS", 1500.0);
    }

    @Test
    public void testConstructor() {
        assertThat(computer.getId(), is(1L));
        assertThat(computer.getBrand(), is("Apple"));
        assertThat(computer.getMemory(), is(16));
        assertThat(computer.getProcessor(), is("Intel i7"));
        assertThat(computer.getOperatingSystem(), is("macOS"));
        assertThat(computer.getPrice(), is(1500.0));
    }

    @Test
    public void testConstructorDefault() {
        computer = new Computer();
        assertThat(computer.getId(), is(0L));
    }

    @Test
    public void testShowDetails() {
        String details = computer.showDetails();
        assertThat(details, containsString("Brand: Apple"));
        assertThat(details, containsString("Processor: Intel i7"));
        assertThat(details, containsString("Memory: 16GB"));
        assertThat(details, containsString("OS: macOS"));
        assertThat(details, containsString("Price: 1500.0"));
    }

    @Test
    public void testGetIdWhenNull() {
        Computer computerWithoutId = new Computer();
        try {
            computerWithoutId.getId();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), containsString("ID no está inicializado"));
        }
    }

    @Test
    public void testSettersAndGetters() {
        computer.setBrand("Dell");
        computer.setMemory(32);
        computer.setProcessor("AMD Ryzen 9");
        computer.setOperatingSystem("Windows 10");
        computer.setPrice(2000.0);

        assertThat(computer.getBrand(), is("Dell"));
        assertThat(computer.getMemory(), is(32));
        assertThat(computer.getProcessor(), is("AMD Ryzen 9"));
        assertThat(computer.getOperatingSystem(), is("Windows 10"));
        assertThat(computer.getPrice(), is(2000.0));
    }
}