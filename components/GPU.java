package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe GPU (placa de vídeo)
public class GPU {
 protected String nome; // ← Nome da placa (ex.: Radeon RX 550, GeForce RTX 3060, Arc Graphics, etc.)
 protected Integer gb; // ← VRAM em Gigabytes
 protected String tipo; // ← Tipo de VRAM: DDR3, GDDR5, etc.
 protected String conn; // ← Conexão (PCI Express 3.0 x16, etc.) na placa-mãe
 // ↓ Argumentos para criar a classe
 public GPU (String nome, Integer gb, String tipo, String conn) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (gb < 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (tipo == null || tipo.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (conn == null || conn.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  this.nome=nome;
  this.gb=gb;
  this.tipo=tipo;
  this.conn=conn;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: TECHPOWERUP GPU DATABASE :::::\nNome: "+nome+"\nVRAM: "+gb+" GB\nTipo de VRAM: "+tipo+"\nConexão: "+conn+"\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public Integer verVRAM() {return gb;}
 public String verTipoVRAM() {return tipo;}
 public String verConexao() {return conn;}
}
