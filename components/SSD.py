# ↓ Criando a classe SSD (memória secundária do tipo "estado sólido")
class SSD:
 lista_conn=["SATA","IDE","NVME"]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, gb:int, conn:str):
  
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if gb <= 0:
   raise ValueError("Deve ser maior que zero!")
  if conn is None or conn.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if conn.upper() not in SSD.lista_conn:
   raise TypeError("Conexão de armazenamento não está na lista das válidas!")
  
  self.__nome=nome
  self.__gb=gb
  self.__conn=conn
  
  # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DA MEMÓRIA SECUNDÁRIA :::::\nNome: {self.__nome}\nCapacidade: {self.__gb} GB\nConexão: {self.__conn}\n"
  
  # ↓ NOTA: Para manter os atributos da classe como privados e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verGB(self) -> int:
  return self.__gb
 def verConexao(self) -> str:
  return self.__conn
