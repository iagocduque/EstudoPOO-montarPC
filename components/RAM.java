package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe RAM (memória principal)
public class RAM {
 private String nome;
 private Integer gb;
 private String conn;
 private Integer mhz;
 // ↓ Argumentos para criar a classe
 public RAM (String nome, Integer gb, String conn, Integer mhz) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (gb < 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (conn == null || conn.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (mhz < 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  this.nome=nome;
  this.gb=gb;
  this.conn=conn;
  this.mhz=mhz;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DA MEMÓRIA PRINCIPAL :::::\nNome: "+nome+"\nMemória: "+gb+" GB\nConexão: "+conn+"\nFrequência: "+mhz+" MHz\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public String verConexao() {return conn;}
 public Integer verGB() {return gb;}
 public Integer verMHz() {return mhz;}
}
