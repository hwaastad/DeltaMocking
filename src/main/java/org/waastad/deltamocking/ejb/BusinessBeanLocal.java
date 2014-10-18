/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltamocking.ejb;

import javax.ejb.Local;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Local
public interface BusinessBeanLocal {

    String doSomething();
}
