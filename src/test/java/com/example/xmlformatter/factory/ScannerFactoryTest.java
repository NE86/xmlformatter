package com.example.xmlformatter.factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScannerFactoryTest {

    @Test
    public void getInstance() {
        assertSame(ScannerFactory.getInstance(),ScannerFactory.getInstance());
    }
}
