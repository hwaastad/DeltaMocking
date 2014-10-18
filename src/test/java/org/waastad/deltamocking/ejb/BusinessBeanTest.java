/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltamocking.ejb;

import java.util.Properties;
import javax.ejb.EJB;
import javax.enterprise.inject.spi.Producer;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.mockito.MockitoInjector;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Jars;
import org.apache.openejb.testing.MockInjector;
import org.apache.openejb.testing.Module;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.waastad.deltamocking.util.AuthUtil;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@RunWith(ApplicationComposer.class)
public class BusinessBeanTest {

    public BusinessBeanTest() {
    }

    @Mock
    private AuthUtil mockAuthUtil;

    @Module
    @Classes(value = {BusinessBean.class}, cdi = true)
    @Jars(value = {"deltaspike-core-impl"})
    public WebApp app() {
        return new WebApp().contextRoot("test");
    }

    @MockInjector
    public Class<?> mockitoInjector() {
        return MockitoInjector.class;
    }

    @Configuration
    public Properties config() throws Exception {
        Properties p = new Properties();
        p.put("logging.level.OpenEJB.startup", "FINE");
        p.put("logging.level.OpenEJB.startup.config", "FINE");
        p.put("openejb.jul.forceReload", Boolean.TRUE.toString());
        return p;
    }

    @EJB
    private BusinessBeanLocal businessBean;

    @Test
    public void testSomeMethod() {
        when(mockAuthUtil.doStuff()).thenReturn("what");
        String doSomething = businessBean.doSomething();
        Assert.assertEquals("what", doSomething);
    }

}
