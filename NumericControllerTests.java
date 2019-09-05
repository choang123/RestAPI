package com.app.server.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.server.domain.NumericRequest;

public class NumericControllerTests extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testListHave3Items() throws Exception {
       String uri = "/numeric/sqrt3highest";
       NumericRequest req = new NumericRequest();
       
       BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("4"),new BigDecimal("6")};
       req.setData(a);
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertThat(200, is(status));
       String content = mvcResult.getResponse().getContentAsString();
       assertThat(content, is("{\"output\":8.8}"));
    }
    
    @Test
    public void testListHaveMoreThan3Items() throws Exception {
       String uri = "/numeric/sqrt3highest";
       NumericRequest req = new NumericRequest();
       
       BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("4"),new BigDecimal("6"),new BigDecimal("2")};
       req.setData(a);
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertThat(200, is(status));
       String content = mvcResult.getResponse().getContentAsString();
       assertThat(content, is("{\"output\":8.8}"));
    }
    
    @Test
    public void testListHave2Items() throws Exception {
       String uri = "/numeric/sqrt3highest";
       NumericRequest req = new NumericRequest();
       
       BigDecimal[] a = new BigDecimal[]{new BigDecimal("5"),new BigDecimal("4")};
       req.setData(a);
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = null;
       try {
           mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       }
       catch (Exception e) {
           assertThat(e.getCause().getMessage(), is("list should have at least 3 items"));
       }
    }
    
    @Test
    public void testListHave0Items() throws Exception {
       String uri = "/numeric/sqrt3highest";
       NumericRequest req = new NumericRequest();
       
       BigDecimal[] a = new BigDecimal[]{};
       req.setData(a);
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = null;
       try {
           mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       }
       catch (Exception e) {
           assertThat(e.getCause().getMessage(), is("list is empty"));
       }
    }
    
    @Test
    public void testListIsNull() throws Exception {
       String uri = "/numeric/sqrt3highest";
       NumericRequest req = new NumericRequest();
       
       req.setData(null);
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = null;
       try {
           mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .content(inputJson)).andReturn();
       }
       catch (Exception e) {
           assertThat(true, is(e.getCause() instanceof NullPointerException));
       }
    }
    
}


