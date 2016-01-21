package com.develogical.app;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutPressman() throws Exception {
        assertThat(queryProcessor.process("pressman"), containsString("Paratrooper"));
    }

    @Test
    public void additions() throws Exception {
        assertThat(queryProcessor.process("what is 2000 plus 200"), containsString("2200"));
    }

    @Test
    public void multiplication() throws Exception {
        assertThat(queryProcessor.process("what is 2 multiplied by 4"), containsString("8"));
    }

    @Test
    public void largestNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 23, 222, 4, 55"), containsString("222"));
    }

    @Test
    public void squareAndCube() throws Exception {
        assertThat(queryProcessor.process("fsd:which of the following numbers is both a square and a cube: 762, 121"), containsString(""));
        assertThat(queryProcessor.process("fsd:which of the following numbers is both a square and a cube: 762, 121, 0"), containsString("0"));
    }
}
