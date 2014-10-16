/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltamocking.ejb;

import java.util.Properties;
import javax.ejb.EJB;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Jars;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.waastad.deltamocking.util.AuthUtil;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@RunWith(ApplicationComposer.class)
public class BusinessBeanIT {

    public BusinessBeanIT() {
    }

    @Module
    @Classes({BusinessBean.class, AuthUtil.class})
    @Jars("deltaspike-")
    public WebApp app() {
        return new WebApp();
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
    private BusinessBean businessBean;

    @Test
    public void testSomeMethod() {
        businessBean.doSomething();
    }

}
