#https://github.com/jruby/jruby/wiki/CallingJavaFromJRuby
java_import 'com.nenufarinformatica.javatestmavenapplication.Pessoa'
#require 'java'
#class RPessoa < Java::ComNenufarinformaticaJavatestmavenapplication::Pessoa
#  def to_pessoa
#    Pessoa.new(self.name)
#  end
#end
#RPessoa.new(@name)
Pessoa.new(@name)