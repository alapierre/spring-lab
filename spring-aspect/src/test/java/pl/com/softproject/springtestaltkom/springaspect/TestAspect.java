/*
 * Copyright 2012-09-12 the original author or authors.
 */
package pl.com.softproject.springtestaltkom.springaspect;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/spring-context.xml")
public class TestAspect extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    @Qualifier("targetBean")
    NewInterface bean;
    
    @Autowired
    @Qualifier("targetBean2")
    NewInterface bean2;
    
    @Test
    public void test() {
        bean.someMethod(1);
        bean.method2();
        
        bean2.method2();
    }
}
