package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe CPU (processador de computador)
public class CPU {
 private String nome; // ← Nome do processador (ex.: Intel Core Ultra 5, AMD Ryzen 9, Snapdragon 7s Gen 2, etc.)
 private String soc; // ← Socket do processador (ex.: AM4, LGA 1200, etc.)
 private boolean overclockd;
 private double ghzb; // ← Frequência base do processador
 private double ghza; // ← Frequência do processador com overclock
 private double ghz; // ← Frequência do processador dependente do "overclockd"
 private Integer n; // ← Número de núcleos do processador
 private Integer thr; // ← Número de threads do processador
 private Integer w; // ← Consumo (TDP) do processador
 private String igpu;
 // ↓ Argumentos para criar a classe
 public CPU (String nome, String soc, double ghzb, double ghza, Integer n, Integer thr, Integer w, String igpu) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (soc == null || soc.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (ghzb <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (ghza <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (n <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (thr <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (w <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (ghza < ghzb) {throw new IllegalArgumentException("Frequência com overclock deve ser maior que a frequência base!");}
  if (thr < n) {throw new IllegalArgumentException("Número de threads deve ser igual ou maior que o de núcleos!");}
  this.nome=nome;
  this.soc=soc;
  this.overclockd=false; // ← Por padrão, a CPU está sem overclock após montar
  this.ghzb=ghzb;
  this.ghza=ghza;
  this.ghz = (this.overclockd) ? this.ghza : this.ghzb;
  this.n=n;
  this.thr=thr;
  this.w=w;
  this.igpu=igpu;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: TECHPOWERUP CPU DATABASE :::::\nNome: "+nome+"\nSocket: "+soc+"\nFrequência: "+ghz+" GHz\nNúcleos: "+n+"\nThreads: "+thr+"\nConsumo: "+w+"W\nGPU integrada: "+igpu+"\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public String verSocket() {return soc;}
 public double verFrequencia() {return ghz;}
 public String veriGPU() {return igpu;}
 public void Overclock() {
  this.overclockd = !this.overclockd;
  this.ghz = (this.overclockd) ? this.ghza : this.ghzb;
  System.out.println(this.overclockd ? "O overclock está ativado." : "O overclock está desativado.");
 }
}
