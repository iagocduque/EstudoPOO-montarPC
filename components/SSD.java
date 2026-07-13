package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe SSD (memória secundária do tipo "estado sólido")
public class SSD {
 private String nome;
 private Integer gb;
 private String conn;
 // ↓ Argumentos para criar a classe
 public SSD (String nome, Integer gb, String conn) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (gb <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (conn == null || conn.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  this.nome=nome;
  this.gb=gb;
  this.conn=conn;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DA MEMÓRIA SECUNDÁRIA :::::\nNome: "+nome+"\nCapacidade: "+gb+" GB\nConexão: "+conn+"\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public String verConexao() {return conn;}
 public Integer verGB() {return gb;}
}
