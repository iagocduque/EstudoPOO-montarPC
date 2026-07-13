package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe Case (gabinete)
public class Case {
 private String nome; // ← Nome do gabinete
 private String ff; // ← Formato de placa-mãe suportado
 // ↓ Argumentos para criar a classe
 public Case (String nome, String ff) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (ff == null || ff.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  this.nome=nome;
  this.ff=ff;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DO GABINETE :::::\nNome: "+nome+"\nFormato: "+ff+"\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public String verFormato() {return ff;}
}
