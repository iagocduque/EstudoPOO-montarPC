# ↓ Criando a classe CPU (processador de computador)
class CPU:
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, soc:str, ghzb:float, ghza:float, n:int, thr:int, w:int, igpu:str):
  
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if soc is None or soc.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if ghzb <= 0:
   raise ValueError("Deve ser maior que zero!")
  if ghza <= 0:
   raise ValueError("Deve ser maior que zero!")
  if n <= 0:
   raise ValueError("Deve ser maior que zero!")
  if thr <= 0:
   raise ValueError("Deve ser maior que zero!")
  if w <= 0:
   raise ValueError("Deve ser maior que zero!")
  if ghza < ghzb:
   raise ValueError("Frequência com overclock deve ser maior que a frequência base!")
  if thr < n:
   raise ValueError("Número de threads deve ser igual ou maior que o de núcleos!")
  
  self.__nome=nome # ← Nome do processador (ex.: Intel Core Ultra 5, AMD Ryzen 9, Snapdragon 7s Gen 2, etc.)
  self.__soc=soc # ← Socket do processador (ex.: AM4, LGA 1200, etc.)
  self.__overclockd=False # ← Por padrão, a CPU está sem overclock após montar
  self.__ghzb=ghzb # ← Frequência base do processador
  self.__ghza=ghza # ← Frequência do processador com overclock
  # ↓ Frequência do processador dependente do "overclockd"
  self.__ghz = self.__ghza if self.__overclockd is True else self.__ghzb
  self.__n=n # ← Número de núcleos do processador
  self.__thr=thr # ← Número de threads do processador
  self.__w=w # ← Consumo (TDP) do processador
  self.__igpu=igpu
  
  # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: TECHPOWERUP CPU DATABASE :::::\nNome: {self.__nome}\nSocket: {self.__soc}\nFrequência: {self.__ghz} GHz\nNúcleos: {self.__n}\nThreads: {self.__thr}\nConsumo: {self.__w}W\nGPU integrada: {self.__igpu if self.__igpu else "Nenhuma"}\n"
  
  # ↓ NOTA: Para manter os atributos da classe como privados e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verSocket(self) -> str:
  return self.__soc
 def verFrequencia(self) -> float:
  return self.__ghz
 def veriGPU(self) -> str:
  return self.__igpu
 def Overclock(self):
  self.__overclockd = not self.__overclockd
  self.__ghz = self.__ghza if self.__overclockd is True else self.__ghzb
  print("O overclock está ativado.") if self.__overclockd else print("O overclock está desativado.")
