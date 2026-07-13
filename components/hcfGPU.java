package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Esta classe é herdada da GPU, para placas de vídeo Radeon com Hybrid Crossfire
public class hcfGPU extends GPU {
 private String igpu; // ← Placa de vídeo integrada compatível para Hybrid Crossfire
 private boolean hcf; // ← Tecnologia desligada por padrão
 private String valor;
 public hcfGPU (String nome, Integer gb, String tipo, String conn, String igpu) {
  super(nome, gb, tipo, conn);
  if (igpu == null || igpu.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  this.igpu=igpu;
  this.hcf=false;
  this.valor = (hcf) ? "Ativado" : "Desativado";
 }
 @Override
 public String toString() {
  return "\n::::: TECHPOWERUP GPU DATABASE :::::\nNome: "+nome+"\nVRAM: "+gb+" GB\nTipo de VRAM: "+tipo+"\nConexão: "+conn+"\nHybrid Crossfire ("+igpu+"): "+valor+"\n";
 }
 // ↓ Mesma situação para manter atributos como private
 public String veriGPU() {return igpu;}
 public boolean verHybridCrossfire() {return hcf;}
 public void HybridCrossfire() {
  this.hcf = !this.hcf;
  this.valor = (hcf) ? "Ativado" : "Desativado";
  System.out.println(this.hcf ? "O Hybrid Crossfire está ativado." : "O Hybrid Crossfire está desativado.");
 }
}
