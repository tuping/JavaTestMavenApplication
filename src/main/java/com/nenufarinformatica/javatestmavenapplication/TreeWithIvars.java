/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nenufarinformatica.javatestmavenapplication;

import org.jruby.embed.PathType;
import org.jruby.embed.ScriptingContainer;

/**
 *
 * @author rodrigo
 */
public class TreeWithIvars {

    private final static String filename = "ruby/tree_with_ivars.rb";

    public TreeWithIvars() {

        System.out.println("[" + getClass().getName() + "]");
        ScriptingContainer container = new ScriptingContainer();

        // tem que colocar resources no POM
        String path = this.getClass().getClassLoader().getResource(filename).getPath();

        Object receiver = container.runScriptlet(PathType.ABSOLUTE, path);
        container.put(receiver, "@name", "cherry blossom");
        container.put(receiver, "@shape", "oval");
        container.put(receiver, "@foliage", "deciduous");
        container.put(receiver, "@color", "pink");
        container.put(receiver, "@bloomtime", "March - April");
        container.callMethod(receiver, "update", Object.class);
        System.out.println(container.callMethod(receiver, "to_s", String.class));

        container.put(receiver, "@name", "cedar");
        container.put(receiver, "@shape", "pyramidal");
        container.put(receiver, "@foliage", "evergreen");
        container.put(receiver, "@color", "nondescript");
        container.put(receiver, "@bloomtime", "April - May");
        container.callMethod(receiver, "update", Object.class);
        System.out.println(container.callMethod(receiver, "to_s", String.class));
    }
}
