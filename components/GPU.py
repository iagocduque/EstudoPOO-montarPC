# ↓ Criando a classe GPU (placa de vídeo)
class GPU:
 lista_tipo=["DDR3","GDDR5"]
 # ↓ Argumentos para criar a classe
 def __init__(self, nome:str, gb:int, tipo:str, conn:str):
 
  # ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if nome is None or nome.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if gb <= 0:
   raise ValueError("Deve ser maior que zero!")
  if tipo is None or tipo.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if conn is None or conn.strip() == "":
   raise ValueError("Não pode ser vazio ou nulo!")
  if tipo.upper() not in GPU.lista_tipo:
   raise ValueError("Tipo de VRAM não está na lista dos válidos!")
  
  # ↓ NOTA: Para os atributos serem acessíveis à classe filha hcfGPU, os atributos abaixo serão declarados como protegidos. No Python, requer um só underline após o "self." para declarar o atributo como protegido e dois para declarar como privado.
  self._nome=nome # ← Nome da placa (ex.: Radeon RX 550, GeForce RTX 3060, Arc Graphics, etc.)
  self._gb=gb # ← VRAM em Gigabytes
  self._tipo=tipo # ← Tipo de VRAM: DDR3, GDDR5, etc.
  self._conn=conn # ← Conexão (PCI Express 3.0 x16, etc.) na placa-mãe
  
 # ↓ Simplesmente digitando o nome do instance no console, ou dentro do parênteses no "print()" irá renderizar a string abaixo
 def __repr__(self) -> str:
  return f"\n::::: TECHPOWERUP GPU DATABASE :::::\nNome: {self._nome}\nVRAM: {self._gb} GB\nTipo de VRAM: {self._tipo}\nConexão: {self._conn}\n"
  
 # ↓ NOTA: Para manter os atributos da classe como protegidos e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 def verNome(self) -> str:
  return self._nome
 def verVRAM(self) -> int:
  return self._gb
 def verTipoVRAM(self) -> str:
  return self._tipo
 def verConexao(self) -> str:
  return self._conn
