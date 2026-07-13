package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe Mobo (placa-mãe)
public class Mobo {
 private String nome;
 private String ff; // ← Formato de placa-mãe
 private String soc; // ← Socket suportado de CPUs (ex.: AM4, LGA 1200, etc.)
 private String connssd; // ← Conexão (IDE, SATA, NVMe, etc.) para SSDs e HDDs
 private String connram; // ← Conexão (DDRx, DIMM, SIMM, etc.) para memórias RAM
 private String conngpu; // ← Conexão (PCI Express 3.0 x16, etc.) para GPUs
 private Integer maxgb;
 // ↓ Argumentos para criar a classe
 public Mobo (String nome, String ff, String soc, String connssd, String connram, String conngpu, Integer maxgb) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (ff == null || ff.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (soc == null || soc.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (connssd == null || connssd.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (connram == null || connram.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (conngpu == null || conngpu.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (maxgb <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  this.nome=nome;
  this.ff=ff;
  this.soc=soc;
  this.connssd=connssd;
  this.connram=connram;
  this.conngpu=conngpu;
  this.maxgb=maxgb;
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DA PLACA-MÃE :::::\nNome: "+nome+"\nFormato: "+ff+"\nSocket: "+soc+"\nRAM máxima: "+maxgb+" GB\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
 public String verFormato() {return ff;}
 public String verSocket() {return soc;}
 public String verConexaoSSD() {return connssd;}
 public String verConexaoRAM() {return connram;}
 public String verConexaoGPU() {return conngpu;}
 public Integer verRAMmaxima() {return maxgb;}
}
