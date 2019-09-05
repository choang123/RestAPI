package com.app.server.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceImplTests {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testListIsNull() {
        Service service = new ServiceImpl();
        
        List<BigDecimal> a = null;
        try {
            service.computeSquareRootOf3Highest(a);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("list is empty"));
        }
    }

    @Test
    public void testListIsNotNullButEmpty() {
        Service service = new ServiceImpl();
        
        List<BigDecimal> a = new ArrayList<BigDecimal>();
        try {
            service.computeSquareRootOf3Highest(a);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("list is empty"));
        }
    }
    
    @Test
    public void testListIsNotNullButNotEnough3Items() {
        Service service = new ServiceImpl();
        
        BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("4")};
        List<BigDecimal> l = new ArrayList<BigDecimal>(Arrays.asList(a));
        try {
            service.computeSquareRootOf3Highest(l);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("list should have at least 3 items"));
        }
    }
    
    @Test
    public void testListHave3Items() {
        Service service = new ServiceImpl();
        
        BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("4"),new BigDecimal("6")};
        List<BigDecimal> l = new ArrayList<BigDecimal>(Arrays.asList(a));
        BigDecimal ret = null;
        try {
            ret = service.computeSquareRootOf3Highest(l);
        } catch (Exception e) {
        }
        
        assertThat(ret, is(new BigDecimal("8.8")));
    }
    
    @Test
    public void testListHaveMoreThan3Items() {
        Service service = new ServiceImpl();
        
        BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("1"),new BigDecimal("2"),new BigDecimal("3")};
        List<BigDecimal> l = new ArrayList<BigDecimal>(Arrays.asList(a));
        BigDecimal ret = null;
        try {
            ret = service.computeSquareRootOf3Highest(l);
        } catch (Exception e) {
        }
        
        assertThat(ret, is(new BigDecimal("6.2")));
    }
}
