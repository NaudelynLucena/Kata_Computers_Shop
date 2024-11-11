package com.factoriaf5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StoreTest {

    private Store store;
    private Computer computer1;
    private Computer computer2;

    @BeforeEach
    public void setUp() {
        store = new Store(1L, "Computers Shop", "Nahomi", "123-456-789");
        computer1 = new Computer(1L, "Dell", 16, "Intel i7", "Windows 10", 1200.00);
        computer2 = new Computer(2L, "HP", 8, "Intel i5", "Windows 10", 800.00);
    }

    @Test
    public void testConstructor() {
        assertNotNull(store);
        assertEquals(1L, store.getId());
        assertEquals("Computers Shop", store.getName());
        assertEquals("Nahomi", store.getOwner());
        assertEquals("123-456-789", store.getTaxId());
    }

    @Test
    public void testAddComputer() {
        store.addComputer(computer1);
        assertThat(store.listComputers(), hasSize(1));
        assertThat(store.listComputers(), contains(computer1));

        store.addComputer(computer2);
        assertThat(store.listComputers(), hasSize(2));
        assertThat(store.listComputers(), containsInAnyOrder(computer1, computer2));
    }

    @Test
    public void testDeleteComputer_Success() {
        store.addComputer(computer1);
        store.addComputer(computer2);

        assertThat(store.listComputers(), hasSize(2));

        boolean result = store.deleteComputer("Dell");

        assertTrue(result);
        assertThat(store.listComputers(), hasSize(1));
        assertThat(store.listComputers(), contains(computer2));
    }

    @Test
    public void testDeleteComputer_Failure() {
        store.addComputer(computer2);

        boolean result = store.deleteComputer("Dell");

        assertFalse(result);
        assertThat(store.listComputers(), hasSize(1));
        assertThat(store.listComputers(), contains(computer2));
    }

    @Test
    public void testFindComputer_Found() {
        store.addComputer(computer1);
        store.addComputer(computer2);

        Computer foundComputer = store.findComputer("Dell");

        assertNotNull(foundComputer);
        assertEquals("Dell", foundComputer.getBrand());
        assertEquals(computer1, foundComputer);
    }

    @Test
    public void testFindComputer_NotFound() {
        store.addComputer(computer2);

        Computer foundComputer = store.findComputer("Dell");

        assertNull(foundComputer);
    }

    @Test
    public void testListComputers() {
        store.addComputer(computer1);
        store.addComputer(computer2);

        assertThat(store.listComputers(), hasSize(2));
        assertThat(store.listComputers(), containsInAnyOrder(computer1, computer2));
    }

    @Test
    public void testListComputers_Empty() {
        assertThat(store.listComputers(), is(empty()));
    }

    @Test
    public void testGettersAndSetters() {
        store.setName("New Computer Shop");
        store.setOwner("John");
        store.setTaxId("987-654-321");

        assertEquals("New Computer Shop", store.getName());
        assertEquals("John", store.getOwner());
        assertEquals("987-654-321", store.getTaxId());
    }
}