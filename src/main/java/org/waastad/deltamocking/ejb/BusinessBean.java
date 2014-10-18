/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltamocking.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.waastad.deltamocking.util.AuthUtil;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Stateless
public class BusinessBean implements BusinessBeanLocal {

    @Inject
    private AuthUtil authUtil;

    @Override
    public String doSomething() {
        System.out.println("Doing something...");
        return authUtil.doStuff();
    }

}
