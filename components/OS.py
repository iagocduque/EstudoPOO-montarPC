# ↓ Criando a classe OS (sistema operacional)
class OS:
 bits=[32,64]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, bit:int, gb:int):
  
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if bit not in OS.bits:
   raise ValueError("Deve ser 32-bit ou 64-bit!")
  if gb<=0:
   raise ValueError("Deve ser maior que zero!")
  
  self.__nome=nome
  self.__bit=bit # ← 32 ou 64 bits?
  self.__gb=gb # ← Ocupação no armazenamento
  
  # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DO SISTEMA OPERACIONAL :::::\nNome: {self.__nome}\nBits: {self.__bit}-bit\nOcupação: {self.__gb} GB\n"
  
  # ↓ NOTA: Para manter os atributos da classe como privados e serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verBits(self) -> int:
  return self.__bit
 def verOcupacao(self) -> int:
  return self.__gb
