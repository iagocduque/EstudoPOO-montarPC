# ↓ Criando a classe RAM (memória principal)
class RAM:
 lista_conn=["SIMM","DIMM","DDR","DDR2","DDR3","DDR4"]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, gb:int, conn:str, mhz:int):
 
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if gb <= 0:
   raise ValueError("Deve ser maior que zero!")
  if conn is None or conn.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if mhz <= 0:
   raise ValueError("Deve ser maior que zero!")
  if conn.upper() not in RAM.lista_conn:
   raise TypeError("Conexão de memória RAM não está na lista das válidas!")
  
  self.__nome=nome
  self.__gb=gb
  self.__conn=conn
  self.__mhz=mhz
  
  # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DA MEMÓRIA PRINCIPAL :::::\nNome: {self.__nome}\nMemória: {self.__gb} GB\nConexão: {self.__conn}\nFrequência: {self.__mhz} MHz\n"
  
  # ↓ NOTA: Para manter os atributos da classe como privados e serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verConexao(self) -> str:
  return self.__conn
 def verGB(self) -> int:
  return self.__gb
 def verMHz(self) -> int:
  return self.__mhz
