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
public class Pessoa {

    private final static String filename = "ruby/pessoa.rb";

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String name) {
        this.nome = name;
        System.out.println("I got a name: " + name);
    }

    static public Pessoa geraPessoaRuby(String name) {
        System.out.println("[" + Pessoa.class.getName() + "]");
        ScriptingContainer container = new ScriptingContainer();

        // tem que colocar resources no POM
        String path = Pessoa.class.getClassLoader().getResource(filename).getPath();

        container.put("@name", name);
        Pessoa receiver = (Pessoa) container.runScriptlet(PathType.ABSOLUTE, path);
        //return container.callMethod(receiver, "to_pessoa", Pessoa.class);
        return receiver;
    }
}
