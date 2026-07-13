import java.util.*; // ← Usará todas as utilidades do Java
import components.*; // ← Usará todos os arquivos ".java" da pasta components

public class Main {
 public static void main(String[] args) {
  Case aerocool = new Case("AeroCool","ATX"); // ← Criando um gabinete
  Case coolermaster = new Case("Cooler Master","ATX"); // ← Criando outro gabinete
  
  PSU evga = new PSU("EVGA 500B",500,83); // ← Criando uma fonte de alimentação
  PSU corsair = new PSU("Corsair CX600",600,83); // ← Criando outra fonte de alimentação
  
  Mobo asrock = new Mobo("ASRock FM2A55M-VG3+","Micro ATX","FM2+","SATA","DDR3","PCIe x16 3.0",32); // ← Placa-mãe 1
  Mobo asus = new Mobo("ASUS M5A78L-M LX/BR","Micro ATX","AM3+","SATA","DDR3","PCIe x16 3.0",32); // ← Placa-mãe 2
  
  CPU a10_7850k = new CPU("AMD A10-7850K","FM2+",3.7,4.4,4,4,95,"Radeon R7 series"); // ← Linha APU da AMD
  CPU fx_6300 = new CPU("AMD FX-6300","AM3+",3.5,4.1,6,6,95,null); // ← Linha FX da AMD
  
  SSD sandisk = new SSD("SanDisk 500GB SATA",500,"SATA"); // ← SSD da SanDisk
  SSD alltek = new SSD("Alltek 256GB SATA",256,"SATA"); // ← SSD da Alltek
  
  RAM kingston = new RAM("Kingston 8GB DDR3 1600MHz",8,"DDR3",1600); // ← Dois pentes de memória RAM, um objeto
  
  GPU radeon = new hcfGPU("AMD Radeon R7 240",2,"DDR3","PCIe x16 3.0","Radeon R7 series"); // ← Placa de vídeo Radeon
  GPU nvidia = new GPU("NVIDIA GeForce GTX 750 Ti",2,"GDDR5","PCIe x16 3.0"); // ← Placa de vídeo GeForce
  
  OS windows = new OS("Windows 10 Pro",64,32); // ← Sistema operacional Windows
  OS ubuntu = new OS("Ubuntu 20.04 Focal Fossa",64,25); // ← Distro Linux
  
  // ↓ Montando um novo computador e fazendo operações de overclock
  PC esteComputador = new PC(coolermaster,corsair,asus,fx_6300,sandisk,kingston,nvidia,windows);
  esteComputador.botaoEnergia(); // ← Se desligado, irá ligar o computador
  esteComputador.propriedades(); // ← Vendo especificações básicas do computador
  esteComputador.Overclock(); // ← Não irá funcionar se o computador estiver ligado
  esteComputador.botaoEnergia(); // ← Se ligado, irá desligar o computador
  esteComputador.Overclock(); // ← Irá funcionar se o computador estiver desligado
  esteComputador.botaoEnergia(); // ← Ligando o computador
  esteComputador.propriedades(); // ← Novo valor da frequência da CPU
  
  // ↓ Montando um outro computador e fazendo operações de Hybrid Crossfire
  PC esseComputador = new PC(aerocool,evga,asrock,a10_7850k,alltek,kingston,radeon,ubuntu);
  esseComputador.botaoEnergia();
  esseComputador.propriedades();
  esseComputador.GPUdb(); // ← Vendo especificações detalhadas da placa de vídeo
  esseComputador.Overclock();
  esseComputador.HybridCrossfire(); // ← Também não irá funcionar se o computador estiver ligado
  esseComputador.botaoEnergia();
  esseComputador.Overclock();
  esseComputador.HybridCrossfire();
  esseComputador.botaoEnergia();
  esseComputador.propriedades();
  esseComputador.GPUdb(); // ← Hybrid Crossfire ativado
  
 }
}
