from .GPU import GPU # ← Esta classe é herdada da GPU, para placas de vídeo Radeon com Hybrid Crossfire
class hcfGPU(GPU):
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, gb:int, tipo:str, conn:str, igpu:str):
  # ↓ Puxará atributos da classe mãe GPU
  super().__init__(nome, gb, tipo, conn)
  if igpu is None or igpu.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  
  self.__igpu=igpu # ← Placa de vídeo integrada compatível para Hybrid Crossfire
  self.__hcf=False # ← Tecnologia desligada por padrão
  self.__valor = "Ativado" if self.__hcf else "Desativado"
  
 # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: TECHPOWERUP GPU DATABASE :::::\nNome: {self._nome}\nVRAM: {self._gb} GB\nTipo de VRAM: {self._tipo}\nConexão: {self._conn}\nHybrid Crossfire ({self.__igpu}): {self.__valor}\n"
 
 # ↓ Mesma situação para manter atributos como privados
 def veriGPU(self) -> str:
  return self.__igpu
 def verHybridCrossfire(self) -> bool:
  return self.__hcf
 def HybridCrossfire(self):
  self.__hcf = not(self.__hcf)
  self.__valor = "Ativado" if self.__hcf else "Desativado"
  print("O Hybrid Crossfire está ativado.") if self.__hcf else print("O Hybrid Crossfire está desativado.")
