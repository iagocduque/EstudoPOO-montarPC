# Peças de computador em Java
![JavaWhite](/imagens/java-white.svg#gh-dark-mode-only)
![JavaBlack](/imagens/java-black.svg#gh-light-mode-only)
Poxa! Finalmente eu consegui criar um projeto em orientação a objetos que seja funcional! Depois de tanto inferno para aprender __Java__ — após tantas falhas de execução por erros de sintaxe, digitação e compilação — fico grato que eu consegui.

Após um tempo pensando, decidi fazer um projeto orientado a objetos com peças de computador. Em que todas elas se cooperam, com o computador já montado após o objeto.


## Conteúdo
1. [Sobre o Java](#sobre-o-java)
1. [Peças de Computador](#peças-de-computador)
   1. [Gabinete (Case)](#gabinete-case)
   1. [Fonte de alimentação (PSU)](#fonte-de-alimentação-psu)
   1. [Placa-mãe (Mobo)](#placa-mae-mobo)
   1. [Processador (CPU)](#processador-cpu)
   1. [Armazenamento (SSD)](#armazenamento-ssd)
   1. [Memória RAM (RAM)](#memória-ram-ram)
   1. [Placa de vídeo (GPU)](#placa-de-vídeo-gpu)
   1. [Sistema operacional (OS)](#sistema-operacional-os)
1. [Computador (PC)](#computador-pc)
1. [Main.java](#mainjava)


## Sobre o Java
Antes de começar, eu preciso descrever, com as minhas palavras, sobre o Java, linguagem para orientação a objetos. Não confundir com _JavaScript,_ linguagem para desenvolvimento web.

Essa é uma das linguagens de programação, de alto nível, mais "requisitadas" no mercado, junto com o Python. E isso de acordo com um artigo aleatório na internet que eu li (ok, pode ser fake, mas ainda sim).

A sintaxe do código-fonte, em texto, é assim:
```java
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Classe objeto = new Classe("",0,0.0,false);
    System.out.println(objeto);
  }
}
```
O código acima representa como a sintaxe do Java funciona. Mas é importante frisar que é em relação ao arquivo `Main.java`, arquivo principal para execuções de comandos já pré-definidos, com a expressão `public static void main(String[] args)` obrigatória.

Mas esse `Main.java` não funciona sozinho. A classe `Classe` não é algo pré-existente do `java.util.*`. E sim, um arquivo separado, que eu mesmo criei, chamado `Classe.java`:
```java
public class Classe {
 private String texto;
 private boolean booleano;
 private Integer inteiro;
 private double racional;
 public Classe (String texto, boolean booleano, Integer inteiro, double racional) {
  this.texto=texto;
  this.booleano=booleano;
  this.inteiro=inteiro;
  this.racional=racional;
 }
 @Override
 public String toString() {
  return "\nTexto: "+texto+"\nBooleano: "+booleano+"\nNúmero inteiro: "+inteiro+"\nNúmero racional: "+racional+"\n";
 }
}
```
A partir do ponto que eu fiz as classes em arquivos separados que eu matei a charada. Agora sim o código funcionou, pois tudo no mesmo arquivo _Main_ vivia dando erro e exceção que eu não entendia. E isso sem considerar os delimitadores e o uso de ponto e vírgula, já que todos estavam corretos.

Bom, o funcionamento dependia da situação. Na [IDE Java do OneCompiler](https://onecompiler.com/java), por exemplo, esses mesmos erros e exceções de fato aconteciam. Um novo arquivo na aba do IDE deve ser criado para solucionar o problema. Mas no próprio comando `java Main.java` do terminal Linux, após a compilação com `javac Main.java`, essas exceções não aconteciam.

Em relação a ambos os arquivos, esta é a saída esperada:
```
root@ubuntu:/home/user/Documents#

Texto: null
Booleano: false
Número inteiro: 0
Número racional: 0.0

```

Vale ressaltar que, também para funcionar corretamente, os arquivos devem estar na mesma pasta e o nome dos arquivos, todos com a extensão `.java`, devem ser os mesmos da classe em questão (se está escrito `public class Nome {...}`, o nome do arquivo será `Nome.java`).


## Peças de computador
![Peças](/imagens/peças.avif "Peças de computador")

Como descrito no começo neste README, este é um projeto orientado a objetos com peças de computador. Em que todas elas se cooperam, com o computador já montado após um novo objeto da classe PC criado.

Como visto no arquivo _Main_, eu criei as peças deliberadamente baseadas em dois computadores: um que eu tinha e outro que um membro familiar meu tinha. São peças mais modestas, e isso lá para 2016, que eu tinha um desses computadores e um membro familiar meu também tinha. E eu escolhi essas para criar como objetos pois não é só porque é algo mais próximo da minha realidade, como também eu simplesmente não sei como estão as peças de computador hoje em dia, já que eu simplesmente parei de pesquisar pelas mesmas, pois eu nunca terei na vida novamente um outro computador montado.

Eu devo descrever cada peça de computador usada para criação das classes em Java. Todas com base em artigos que eu li na internet sobre cada peça, em um curso técnico incompleto que eu fiz sobre _Montagem e Manutenção de Computadores_ e na matéria _Arquitetura de Computadores_ — logo no 1º período da minha faculdade.


### Gabinete (Case)
![Case](/imagens/case.png)
Essa é a peça irá proteger todas as outras do computador. Conta com o botão de energia, de reiniciar, algumas entradas USB próprias e, por opção do cliente que queira, drives de CD e de disquete.

__Argumentos necessários:__
* Nome do gabinete (string, não vazia);
* Formato do gabinete (string, não vazia);

Olha, até o momento, não sei como lidar com listas, tuplas ou arrays em Java. Eu queria uma restrição em que o formato do gabinete deve ser uma na lista dos válidos (_Micro ATX, Mini ITX, etc._).


### Fonte de alimentação (PSU)
![PSU](/imagens/psu.png)
Do inglês, __P__ ower __S__ upply __U__ nit ("unidade de suprimento de poder"). Esta é a peça que fornece energia ao computador, em _watts_. Ela puxa a corrente alternada da tomada de sua casa e converte a mesma em corrente contínua que "alimenta" o computador.

__Argumentos necessários:__
* Nome da fonte (string, não vazia);
* Energia da fonte em _watts_ (número inteiro, maior que 0);
* Eficiência da fonte em porcentagem (número inteiro, entre 0 e 100).

__Argumentos criados:__
* Corrente alternada puxada em _watts_ (Energia * 100 / Eficiência) (número inteiro);
* Certificação 80 Plus (sensível à eficiência) (string).

Sobre os watts de uma fonte de alimentação, algo que eu pensei errado sobre as mesmas. Eu achei que uma fonte de 400W puxava __400W__ da tomada e, se tivesse __80%__ de eficiência, entregava __320W__ de energia para o computador, enquanto os outros __80W__ viram calor. Mas, ao ver uma correção, seria o contrário. Na verdade, a fonte puxa __500W__ da tomada e de fato entrega __400W__ para o computador. Os outros __100W__ viram calor.

Outra coisa que eu pensei errado é a fonte alimentava o PC inteiro com esses ditos, como exemplo, __400W__ o tempo todo, com 100% de uso da fonte. Olha, não é bom fazer isso. Inclusive diminuirá o tempo de vida útil se o uso por beirando a 100%, e a eficiência será obviamente diferente.

Você pode consultar [este website](https://www.fsplifestyle.com/landing/calculator.html) para se ter uma ideia da fonte ideal para o possível hardware de seu computador.


### Placa-mãe (Mobo)
![Mobo](/imagens/mobo.png)
Do inglês, __Mo__ ther __bo__ ard ("placa mãe"). É a que conecta todos os componentes e possui informações ROM que não podem ser apagadas ou corrompidas (BIOS, data e hora, etc.).

__Argumentos necessários:__
* Nome da placa-mãe (string, não vazia);
* Formato da placa-mãe (string, não vazia);
* Socket de encaixe da CPU (string, não vazia);
* Conexão de memórias secundárias (string, não vazia);
* Conexão de memórias RAM (string, não vazia);
* Conexão de placas de vídeo (string, não vazia);
* Memória RAM máxima em _gigabytes_ (número inteiro, maior que 0).

Mais uma vez, não sei como lidar com listas, tuplas ou arrays em Java. Eu queria uma restrição em que o formato da placa-mãe deve ser uma na lista dos válidos (_Micro ATX, Mini ITX, etc._).


### Processador (CPU)
![CPU](/imagens/cpu.png)
Do inglês, __C__ entral __P__ rocessing __U__ nit ("unidade central de processamento"). Esta é a peça que considerada o "cérebro" do computador, pois é nela onde acontecem os cálculos, os pulsos em hertz, a execução das instruções presentes na memória cache, a unidade lógica e aritmética e outras coisas.

__Argumentos necessários:__
* Nome do processador (string, não vazia);
* Socket de encaixe da CPU (string, não vazia);
* Frequência base da CPU em _gigahertz_ (racional com 2 casas depois da vírgula, maior que 0);
* Frequência máxima da CPU em _gigahertz_ (racional com 2 casas depois da vírgula, maior que 0);
* Número de núcleos (número inteiro, maior que 0);
* Número de threads (número inteiro, maior que 0);
* Consumo (TDP) em _watts_ (número inteiro, maior que 0).

__Argumentos criados:__
* Overclock, ativado ou não (booleano);
* Frequência selecionada com base no overclock (racional com 2 casas depois da vírgula);

__Argumentos opcionais:__
* Placa de vídeo integrada (string, escreva '""' ou "null" caso não tenha).

__Restrições:__
* Número de threads não pode ser maior que o de núcleos.

Por decisão minha própria, não haverá opção de overclock na CPU. Pois, como dizem, não é uma prática recomendada, uma vez que fazendo isso, por mais que acelere o desempenho, o computador pode desligar por temperatura elevada, e a CPU pode pifar.

A alternativa segura seria a própria "frequência turbo" imposta pela fabricante. Isso é dito, porém, recomenda-se não usar o tempo todo, ainda mais que é capaz de reduzir o tempo útil da peça, igual como acontece no uso beirando a 100% da fonte de alimentação.


### Armazenamento (SSD)
![SSD](/imagens/ssd.png)
Até o momento, só lidará com armazenamentos do tipo SSD. Do inglês, __S__ olid __S__ tate __D__ rive ("drive em estado sólido"). Simplesmente o programa que armazena arquivos importantes para o correto funcionamento do sistema, arquivos para o funcionamento softwares aplicativos, todas as mídias do(s) usuário(s) (fotos, imagens, vídeos, textos, programas, documentos), etc.

__Argumentos necessários:__
* Nome do SSD (string, não vazia);
* Capacidade de aramzenamento em _gigabytes_ (número inteiro, maior que 0);
* Conexão na placa-mãe (string, não vazia).

Sobre o armazenamento, a matéria _Arquitetura de Computadores_ da minha faculdade falou pra mim que é essa a memória secundária, enquanto a memória RAM é "a principal". A melhor coisa que eu sei é que só "armazena" os programas quando estão abertos e "elimina-os" quando são fechados. Um tanto de _gigabytes_ da memória RAM é liberado quando o programa é fechado.

Bom, aparentemente sim. Mas pior que a memória principal de fato armazena alguns arquivos importantes, pois sabe a lerdeza que é a memória secundária. Percebe-se isso ao reabrir, após fechar, um programa pesado instalado (ex.: softwares de modelagem 3D), em que a reabertura é mais rápida.

Mais uma vez, não sei como lidar com listas, tuplas ou arrays em Java. Eu queria uma restrição em que a conexão na placa-mãe deve ser uma na lista dos válidos (_SATA, IDE, NVMe, etc._).


### Memória RAM (RAM)
![RAM](/imagens/ram.png)
Do inglês, __R__ andom __A__ ccess __M__ emory ("memória de acesso aleatório"). É o que irá armazenar arquivos importantes que têm grande probabilidade de serem reabertos futuramente. É mais rápida que a memória secundária. Porém, é mais lenta que a memória cache e os registradores da CPU e é volátil (se o computador é desligado, tudo na RAM é perdido)

__Argumentos necessários:__
* Nome da memória RAM (string, não vazia);
* Capacidade em _gigabytes_ (número inteiro, maior que 0);
* Conexão na placa-mãe (string, não vazia);
* Frequência em _megahertz_ (número inteiro, maior que 0).

Mais uma vez, não sei como lidar com listas, tuplas ou arrays em Java. Eu queria uma restrição em que a conexão de um pente de RAM na placa-mãe deve ser uma na lista dos válidos (_DDRx, DIMM, SIMM, etc._).


### Placa de vídeo (GPU)
![GPU](/imagens/gpu.png)
Do inglês, __G__ raphics __P__ rocessing __U__ nit ("unidade de processamento gráfico"). No começo, era o hardware que erá só para exibir o vídeo no monitor. Mas passou um tempo e essa peça passou a também lidar com polígonos 3D complexos, já que a CPU sozinha é incapaz. Com a evolução da tecnologia, o negócio é processar — em tempo real ou renderizando para vídeo — sombras, antisserrilhado, ray-tracing, etc.

__Argumentos necessários:__
* Nome da placa de vídeo (string, não vazia);
* Capacidade da VRAM em _gigabytes_ (número inteiro, maior que 0);
* Tipo de VRAM (string, não vazia);
* Conexão na placa-mãe (string, não vazia).

Mesma situação para a CPU: no ".toString()" da própria GPU, eu coloquei o _TechPowerUp GPU Database_ bem no início, como se fosse a abertura de um navegador no computador para ver as especificações da peça. Eu fiz isso pois antes eu coloquei CPU-Z para processadores e GPU-Z para placas de vídeo. Mas só depois eu percebi que ambos esses programas só têm para _Windows_ (não _macOS_ ou distros _Linux_).

Como também é visível na classe GPU, há uma classe filha herdeira chamada "hcfGPU" (de _Hybrid Crossfire_) — que são para placas de vídeo Radeon da AMD decidadas capazes de trabalhar junto com os gráficos integrados das "APUs" da mesma. Essa é uma tecnologia fracassada que durou pouco tempo, e os drivers mais recentes simplesmente barram o suporte, não valendo a pena mais fazer. Tipo, o desempenho da GPU dedicada deve ser muito parecida com a integrada, e o tipo de VRAM recomenda-se ser DDR3 (não GDDR5). Mas eu criei essa classe para fazer um teste.


### Sistema operacional (OS)
![UbuntuLight](/imagens/ubuntu-light.svg#gh-dark-mode-only)
![UbuntuDark](/imagens/ubuntu-dark.svg#gh-light-mode-only)
E para finalizar, o sistema operacional. Do inglês, __O__ perating __S__ ystem ("sistema operacional"). Este é o software de base para a execução de todos os outros programas (softwares). Aliás, não há como o software funcionar sem um hardware, e vice-versa.

__Argumentos necessários:__
* Nome do sistema operacional (string, não vazia);
* Número de bits (número inteiro, deve ser 32 ou 64);
* Ocupação no disco rígido em _gigabytes_ (número inteiro, maior que 0).


## Computador (PC)
Após a criação do pacote com as classes das peças de um computador, agora será criada uma nova classe, e essa importará todo o pacote `import components.*;` e ficará ao lado do arquivo `Main.java` para facilitação. Ao criar um objeto do tipo PC, o mesmo já virá montado.

__Argumentos necessários:__
* Gabinete (Case);
* Fonte (PSU);
* Placa (Mobo);
* Processador (CPU);
* Armazenamento (SSD);
* Memória (RAM);
* Vídeo (GPU ou hcfGPU);
* Sistema (OS).

__Argumentos criados:__
* Se o computador está ligado ou desligado (booleano);
* Armazenamento disponível em _gigabytes_ (capacidade do SSD - ocupação do SO) (número inteiro).

Obviamente haverá restrições quanto a compatibilidade.

__Restrições:__
* Se o gabinete for do formato ATX, apenas placas-mãe ATX e Micro-ATX serão compatíveis;
* Nome do socket da CPU deve ser igual à da placa-mãe;
* Nome da conexão da memória secundária deve ser igual à da placa-mãe;
* Nome da conexão do pente da memória RAM deve ser igual à da placa-mãe;
* Nome da conexão da placa de vídeo deve ser igual à da placa-mãe;
* Capacidade de armazenamento deve ser maior que a ocupação do sistema operacional;
* Se a RAM instalada superar o limite máximo de GBs da placa-mãe, a memória RAM disponível será limitada;
* Se o sistema operacional instalado for de 32 bits, a memória RAM disponível será limitada a 4 GB.
* Se a placa de vídeo for da classe filha hcfGPU, para o _Hybrid Crossfire_ ser ativado, o nome da GPU integrada deve ser a mesma da compatível;

Até o momento, eu trabalharei apenas com os computadores "torre" (desktop). Para notebooks, all-in-ones, tablets ou smartphones, devo fazer uma pesquisa melhor sobre cada peça. Caso sejam criadas criadas essas classes filhas — herdadas do PC (desktop) — serão adicionadas um novo valor nas peças para definir o setor das mesmas (_server, desktop, laptop, mobile,_ etc.). No caso, também, do laptop e do mobile, os objetos tela, bateria, teclado e mousepad também serão obrigatórios.


## Main.java
Assim, com todas as classes criadas, serão criados comandos no arquivo `Main.java` para serem executados via console. Dentro do arquivo, se parece mais ou menos com isto:
```java
import java.util.*;
import components.*;

public class Main {
 public static void main(String[] args) {
  Case gabinete = new Case(...);
  Mobo placa = new Mobo(...);
  CPU processador = new CPU(...);
  SSD armazenamento = new SSD(...);
  RAM memoria = new RAM(...);
  GPU video = new GPU(...);
  
  // ↓ Imprime "Novo computador montado."
  PC computador = new PC(gabinete,placa,processador,armazenamento,memoria,video,sistema);
  computador.botaoEnergia();
 }
}
```
São criado os objetos, o objeto principal (PC) que depende de outros objetos (as peças) e os métodos. Toda vez que um objeto da classe PC for criada, uma linha com o texto `Novo computador montado.` será impressa após a operação.
