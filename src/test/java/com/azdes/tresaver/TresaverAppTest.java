package com.azdes.tresaver;

import static org.testng.Assert.assertTrue;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class TresaverAppTest extends AbstractTestNGSpringContextTests {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }
}
