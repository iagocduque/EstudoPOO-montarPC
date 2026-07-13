package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe OS (sistema operacional)
public class OS {
 private String nome;
 private Integer bit; // ← 32 ou 64 bits?
 private Integer gb; // ← Ocupação no armazenamento
 // ↓ Argumentos para criar a classe
 public OS (String nome, Integer bit, Integer gb) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (bit != 32 && bit != 64) {throw new IllegalArgumentException("Deve ser 32-bit ou 64-bit!");}
  if (gb <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  this.nome=nome;
  this.bit=bit;
  this.gb=gb;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DO SISTEMA OPERACIONAL :::::\nNome: " +nome+ "\nBits: " +bit+ "-bit\nOcupação: " +gb+ " GB\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public Integer verBits() {return bit;}
 public Integer verOcupacao() {return gb;}
}
