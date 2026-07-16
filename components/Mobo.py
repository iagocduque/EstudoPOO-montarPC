# ↓ Criando a classe Mobo (placa-mãe)
class Mobo:
 lista_ff=["ATX","MICROATX","MICRO ATX","MICRO-ATX","MINIITX","MINI ITX","MINI-ITX","EATX","E-ATX","E ATX"]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, ff:str, soc:str, connssd:str, connram:str, conngpu:str, maxgb:int):
  
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if ff is None or ff.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if soc is None or soc.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if connssd is None or connssd.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if connram is None or connram.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if conngpu is None or conngpu.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if maxgb <= 0:
   raise ValueError("Deve zer maior que zero!")
  if ff.upper() not in Mobo.lista_ff:
   raise TypeError("Formato de placa-mãe não está na lista dos válidos!")
  
  self.__nome=nome # ← Nome da placa-mãe
  self.__ff=ff # Formato da placa-mãe
  self.__soc=soc # ← Socket suportado de CPUs (ex.: AM4, LGA 1200, etc.)
  self.__connssd=connssd # ← Conexão (IDE, SATA, NVMe, etc.) para SSDs e HDDs
  self.__connram=connram # ← Conexão (DDRx, DIMM, SIMM, etc.) para memórias RAM
  self.__conngpu=conngpu # ← Conexão (PCI Express 3.0 x16, etc.) para GPUs
  self.__maxgb=maxgb # ← Memória RAM máxima suportada
  
 # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DA PLACA-MÃE :::::\nNome: {self.__nome}\nFormato: {self.__ff}\nSocket: {self.__soc}\nRAM máxima: {self.__maxgb} GB\n"

 # ↓ NOTA: Para manter os atributos da classe como privados e serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verFormato(self) -> str:
  return self.__ff
 def verSocket(self) -> str:
  return self.__soc
 def verConexaoSSD(self) -> str:
  return self.__connssd
 def verConexaoRAM(self) -> str:
  return self.__connram
 def verConexaoGPU(self) -> str:
  return self.__conngpu
 def verRAMmaxima(self) -> str:
  return self.__maxgb
