import components.*; // ← Usará todos os arquivos ".java" da pasta components
// ↓ Criando a classe PC (o computador)
public class PC {
 private Case gabinete;
 private PSU fonte;
 private Mobo placa;
 private CPU processador;
 private SSD armazenamento;
 private RAM memoria;
 private GPU video;
 private OS sistema;
 private boolean ligado; // ← true para ligado, false para desligado
 private Integer disponivel; // ← Armazenamento disponível no SSD após ocupações
 public PC(Case gabinete, PSU fonte, Mobo placa, CPU processador, SSD armazenamento, RAM memoria, GPU video, OS sistema) {
  // ↓ Restrições de compatibilidade na hora de montar o computador
  if (gabinete.verFormato() == "ATX") {
   if (placa.verFormato() == "E-ATX") {throw new IllegalArgumentException("Essa placa-mãe não encaixa no gabinete!");}
   if (placa.verFormato() == "Mini-ITX") {throw new IllegalArgumentException("Essa placa-mãe não encaixa no gabinete!");}
  }
  if (!processador.verSocket().equalsIgnoreCase(placa.verSocket())) {throw new IllegalArgumentException("Esse processador não encaixa na placa-mãe!");}
  // ↑ NOTA: O método .equalsIgnoreCase() de uma String flexibiliza a digitação de texto, pois ignora a sensibilidade entre letras maiúsculas e minúsculas. Porém, não os espaços. Por exemplo, "LGA1200" e "lga1200" são iguais, mas "LGA 1200" e "LGA_1200" são diferentes.
  if (!armazenamento.verConexao().equalsIgnoreCase(placa.verConexaoSSD())) {throw new IllegalArgumentException("Esse conector de SSD não encaixa na placa-mãe!");}
  if (!memoria.verConexao().equalsIgnoreCase(placa.verConexaoRAM())) {throw new IllegalArgumentException("Esse(s) pente(s) de memória RAM não encaixa(m) na placa-mãe!");}
  if (!video.verConexao().equalsIgnoreCase(placa.verConexaoGPU())) {throw new IllegalArgumentException("Essa placa de vídeo não encaixa na placa-mãe!");}
  if (sistema.verOcupacao() > armazenamento.verGB()) {throw new IllegalArgumentException("Espaço em disco insuficiente para instalar o sistema operacional!");}
  if (sistema.verBits() == 32) {System.out.println("NOTA: Por ser de 32-bits, memórias RAM serão limitadas a 4 GB.");}
  if (memoria.verGB() > placa.verRAMmaxima()) {System.out.println("NOTA: A memória RAM instalada estoura o limite máximo suportado pela placa-mãe.");}
  this.gabinete=gabinete;
  this.fonte=fonte;
  this.placa=placa;
  this.processador=processador;
  this.armazenamento=armazenamento;
  this.memoria=memoria;
  this.video=video;
  this.sistema=sistema;
  this.ligado=false; // ← Por padrão, o computador está desligado após montar
  this.disponivel= armazenamento.verGB() - sistema.verOcupacao(); // ← Após instalar o sistema operacional
  System.out.println("Novo computador montado.");
 }
 public void botaoEnergia() { // ← Método do botão liga/desliga do computador
  this.ligado = !this.ligado;
  System.out.printf(this.ligado ? "O computador está ligado. %s em execução.\n" : "O computador está desligado.\n",sistema.verNome());
 }
  public void botaoReset() { // ← Método do botão para reiniciar o computador
  System.out.printf(this.ligado ? "O computador foi reiniciado. %s em execução.\n" : "O computador está desligado! Impossível reiniciar.\n",sistema.verNome());
 }
 public void propriedades() { // ← Método para ver as especificações do computador
  if (!this.ligado) {System.out.println("O computador está desligado! Impossível executar.");} else {
  // ↑ NOTA: Assim como outros métodos abaixo, só será possível se o computador estiver ligado.
   System.out.println("\n::::: PROPRIEDADES DO COMPUTADOR :::::");
   System.out.printf("SO: %s\n", sistema.verNome()); // ← Nome do sistema operacional
   System.out.printf("Tipo de SO: %d-bit\n", sistema.verBits()); // ← Bits do sistema operacional
   System.out.printf("CPU: %s @ %.2f GHz\n", processador.verNome(), processador.verFreq()); // ← Propriedades da CPU
   // ↓ NOTA: Este código é para demonstrar as propriedades da memória RAM. Eu tentei fazer com o operador ternário, mas a limitação de memória RAM para o máximo da placa-mãe exibia os valores errado. Então eu fiz com o if-else comum.
   if (memoria.verGB() > 4) {
    if (sistema.verBits() == 32) {System.out.printf("RAM: 4 GB disponíveis\n");}
    else if (memoria.verGB() > placa.verRAMmaxima()) {System.out.printf("RAM: %d GB disponíveis\n", placa.verRAMmaxima());}
    else {System.out.printf("RAM: %d GB disponíveis\n", memoria.verGB());}
   }
   // ↓ Propriedades do armazenamento
   System.out.printf("SSD: %s (%d disponíveis dos %d GB)\n\n", armazenamento.verNome(), this.disponivel, armazenamento.verGB());
  }
 }
 // ↓ Método para ver as especificações do processador (importa o toString() da CPU)
 public void CPUdb() {System.out.println(this.ligado ? this.processador : "O computador está desligado! Impossível executar.");}
 // ↓ Método para ver as especificações da placa de vídeo (importa o toString() da GPU)
 public void GPUdb() {System.out.println(this.ligado ? this.video : "O computador está desligado! Impossível executar.");}
 public void Overclock() { // ← Método de fazer overclock na CPU
  if (this.ligado) {System.out.println("O computador deve estar desligado para fazer o overclock!");} else {
   processador.Overclock();
  }
 }
 public void HybridCrossfire() { // ← Método para a tecnologia Hybrid Crossfire da AMD Radeon
  if (this.ligado) {System.out.println("O computador deve estar desligado para ativar o Hybrid Crossfire!");} else {
   if (!((hcfGPU) video).veriGPU().equalsIgnoreCase(processador.veriGPU())) {throw new IllegalArgumentException("A GPU integrada não suporta, ou não é compatível com a GPU dedicada, para ativar o Hybrid Crossfire!");} else {
    ((hcfGPU) video).HybridCrossfire();
   } 
  }
 }
}
