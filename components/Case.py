# ↓ Criando a classe Case (gabinete)
class Case:
 lista_ff=["ATX","MICROATX","MICRO ATX","MICRO-ATX","MINIITX","MINI ITX","MINI-ITX","EATX","E-ATX","E ATX"]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, ff:str):
 
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if ff is None or ff.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if ff.upper() not in Case.lista_ff:
   raise TypeError("Formato de placa-mãe não está na lista dos válidos!")
   
  self.__nome=nome # ← Nome do gabinete
  self.__ff=ff # Formato de placa-mãe suportado
  
 # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DO GABINETE :::::\nNome: {self.__nome}\nFormato: {self.__ff}\n"
  
 # ↓ NOTA: Para manter os atributos da classe como privados e serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verFormato(self) -> str:
  return self.__ff
