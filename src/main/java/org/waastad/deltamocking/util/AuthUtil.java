/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltamocking.util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@RequestScoped
public class AuthUtil implements Serializable {

    private static final long serialVersionUID = 298311730402724610L;

    public AuthUtil() {
    }

    public String doStuff() {
        return "doing stuff";
    }
}
