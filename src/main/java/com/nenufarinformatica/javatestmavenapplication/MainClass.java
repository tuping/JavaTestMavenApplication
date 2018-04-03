/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nenufarinformatica.javatestmavenapplication;

import java.io.StringReader;
import org.jruby.embed.PathType;
import org.jruby.embed.ScriptingContainer;

/**
 *
 * @author rodrigo
 */
public class MainClass {

    private MainClass() {
        /*
        String script
                = "puts message\n"
                + "puts @message\n"
                + "puts $message\n"
                + "puts MESSAGE";
        container.runScriptlet(script);
         */
        ScriptingContainer container = new ScriptingContainer();
        container.put("message", "local variable");
        container.put("@message", "instance variable");
        container.put("$message", "global variable");
        container.put("MESSAGE", "constant");
        String path = this.getClass().getClassLoader().getResource("ruby/teste.rb").getPath();
        container.runScriptlet(PathType.ABSOLUTE, path);
    }

    public static void main(String[] args) {
        System.out.println("new MainClass();");
        new MainClass();
        System.out.println("=========================");
        System.out.println("new TreeWithIvars();");
        new TreeWithIvars();
        System.out.println("=========================");
        Pessoa p = Pessoa.geraPessoaRuby("Rodrigo");
        System.out.println("p.nome = " + p.getNome());
    }

}
