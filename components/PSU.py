# ↓ Criando a classe PSU (fonte de alimentação)
class PSU:
 # ↓ Argumentos para criar a classe
 def __init__ (self, nome:str, w:int, ef:int):
 
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if w <= 0:
   raise ValueError("Deve ser maior que zero!")
  if ef < 1 or ef > 100:
   raise ValueError("Deve ser entre 1 e 100!")
  
  self.__nome=nome
  self.__w=w
  self.__ef=ef
  self.__ac = self.__w * 100 / self.__ef
  self.__calor = self.__ac - self.__w
  self.__certif = "80 Plus Titanium" if self.__ef >= 94 else "80 Plus Platinum" if self.__ef >= 91 else "80 Plus Gold" if self.__ef >= 88 else "80 Plus Silver" if self.__ef >= 85 else "80 Plus Bronze" if self.__ef >= 82 else "80 Plus" if self.__ef >= 80 else "Nenhuma"
                
 # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: PROPRIEDADES DA FONTE DE ALIMENTAÇÃO :::::\nNome: {self.__nome}\nCorrente contínua: {self.__w}W\nCorrente alternada: {self.__ac}W\nEficiência: {self.__ef}%\nCalor: {self.__calor}W\nCertificação: {self.__certif}\n";

 # ↓ NOTA: Para manter os atributos da classe como privados e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self.__nome
 def verCorrenteContinua(self) -> int:
  return self.__w
 def verCorrenteAlternada(self) -> int:
  return self.__ac
 def verEficiencia(self) -> int:
  return self.__ef
 def verCalor(self) -> int:
  return self.__calor
 def verCertificado(self) -> str: 
  return self.__certif
