from components import Case, PSU, Mobo, CPU, SSD, RAM, GPU, hcfGPU, OS # ← Usará todos os arquivos ".py" da pasta components
# ↓ Criando a classe PC (o computador)
class PC:
 def __init__(self, gabinete:Case, fonte:PSU, placa:Mobo, processador:CPU, armazenamento:SSD, memoria:RAM, video:GPU, sistema:OS):
  
  # ↓ Restrições de compatibilidade na hora de montar o computador
  if gabinete.verFormato() == "ATX":
   if placa.verFormato() == "E-ATX" or placa.verFormato() == "Mini-ITX":
    raise ValueError("Essa placa-mãe não encaixa no gabinete!")
  # ↓ NOTA: O método .upper() de uma string flexibiliza a digitação de texto, pois, considerando o case-sensitive do Python, todas as letras são convertidas para maiúsculas e facilita a igualação de duas strings. Por exemplo, "LGA1200" e "lga1200" serão considerados iguais. "LGA 1200" e "LGA_1200", porém, serão considerados diferentes.
  if processador.verSocket().upper() != placa.verSocket().upper():
   raise ValueError("Esse processador não encaixa na placa-mãe!")
  if armazenamento.verConexao().upper() != placa.verConexaoSSD().upper():
   raise ValueError("Esse conector de SSD não encaixa na placa-mãe!")
  if memoria.verConexao().upper() != placa.verConexaoRAM().upper():
   raise ValueError("Esse(s) pente(s) de memória RAM não encaixa(m) na placa-mãe!")
  if video.verConexao().upper() != placa.verConexaoGPU().upper():
   raise ValueError("Essa placa de vídeo não encaixa na placa-mãe!")
  if sistema.verOcupacao() > armazenamento.verGB():
   raise ValueError("Espaço em disco insuficiente para instalar o sistema operacional!")
  if sistema.verBits() == 32:
   print("NOTA: Por ser de 32-bits, memórias RAM serão limitadas a 4 GB.")
  if memoria.verGB() > placa.verRAMmaxima():
   print("NOTA: A memória RAM instalada estoura o limite máximo suportado pela placa-mãe.")
  
  self.__gabinete=gabinete
  self.__fonte=fonte
  self.__placa=placa
  self.__processador=processador
  self.__armazenamento=armazenamento
  self.__memoria=memoria
  self.__video=video
  self.__sistema=sistema
  self.__ligado=False # ← Por padrão, o computador está desligado após montar
  self.__disponivel= armazenamento.verGB() - sistema.verOcupacao() # ← Após instalar o sistema operacional
  print("Novo computador montado.")
  
 def botaoEnergia(self): # ← Método do botão liga/desliga do computador
  self.__ligado = not(self.__ligado)
  print(f"O computador está ligado. {self.__sistema.verNome()} em execução.") if self.__ligado else print("O computador está desligado.")
 def botaoReset(self): # ← Método do botão para reiniciar o computador
  print(f"O computador foi reiniciado. {self.__sistema.verNome()} em execução.") if self.__ligado is True else print("O computador está desligado! Impossível reiniciar.")
  
 def propriedades(self): # ← Método para ver as especificações do computador
  if self.__ligado is False:
   print("O computador está desligado! Impossível executar.")
  # ↑ Assim como outros métodos, só será possível se o computador estiver ligado
  else:
   # ↓ Nome e bits do sistema operacional e propriedades da CPU
   print(f"\n::::: PROPRIEDADES DO COMPUTADOR :::::\nSO: {self.__sistema.verNome()}\nTipo de SO: {self.__sistema.verBits()}\nCPU: {self.__processador.verNome()} @ {self.__processador.verFrequencia():.2f} GHz")
   # ↓ NOTA: Este código é para demonstrar as propriedades da memória RAM. Eu tentei fazer com o operador ternário, mas a limitação de memória RAM para o máximo da placa-mãe exibia os valores errado. Então eu fiz com o if-else comum.
   if self.__memoria.verGB() > 4:
    if self.__sistema.verBits() == 32:
     print("RAM: 4 GB disponíveis")
    elif self.__memoria.verGB() > self.__placa.verRAMmaxima():
     print(f"RAM: {self.__placa.verRAMmaxima()} GB disponíveis")
    else:
     print(f"RAM: {self.__memoria.verGB()} GB disponíveis")
   print(f"SSD: {self.__armazenamento.verNome()} ({self.__disponivel} disponíveis dos {self.__armazenamento.verGB()} GB)\n");
   
 def CPUdb(self): # ← Método para ver as especificações do processador (importa o toString() da CPU)
  print(self.__processador) if self.__ligado is True else print("O computador está desligado! Impossível executar.")
 def GPUdb(self): # ← Método para ver as especificações da placa de vídeo (importa o toString() da CPU)
  print(self.__video) if self.__ligado is True else print("O computador está desligado! Impossível executar.")
 def Overclock(self): # ← Método de fazer overclock na CPU
  # ↓ Este método só será possível se o computador estiver desligado
  self.__processador.Overclock() if self.__ligado is False else print("O computador deve estar desligado para fazer o overclock!")
 
 def HybridCrossfire(self): # ← Método para a tecnologia Hybrid Crossfire da AMD Radeon
  # ↓ Este método também só será possível se o computador estiver desligado
  if self.__ligado is True:
   print("O computador deve estar desligado para ativar o Hybrid Crossfire!")
  else:
   if not isinstance(self.__video, hcfGPU):
    raise TypeError("A GPU dedicada não é compatível com o Hybrid Crossfire!")
   elif not(self.__video.veriGPU().lower() == self.__processador.veriGPU().lower()):
    raise TypeError("A GPU integrada não é compatível com a GPU dedicada para ativar o Hybrid Crossfire!")
   else:
    self.__video.HybridCrossfire()

