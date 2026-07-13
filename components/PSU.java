package components; // ← Fará parte do pacote "components", junto com outras peças de computador.
// ↓ Criando a classe PSU (fonte de alimentação)
public class PSU {
 private String nome; // ← Nome da fonte de alimentação
 private Integer w; // ← Watts como corrente contínua
 private Integer ef; // ← Eficiência: relação entre contínua e alternada
 private Integer ac; // ← Watts como corrente alternada
 private Integer calor; // ← Calor gerado pela fonte
 private String certif; // ← Certificações 80 Plus
 // ↓ Argumentos para criar a classe
 public PSU (String nome, Integer w, Integer ef) {
  // ↓ NOTA: Os tratadores de exceção abaixo, marcados com if, são personalizados.
  if (nome == null || nome.trim().isEmpty()) {throw new IllegalArgumentException("Não pode ser vazio ou nulo!");}
  if (w <= 0) {throw new IllegalArgumentException("Deve ser maior que zero!");}
  if (ef < 1 || ef > 100) {throw new IllegalArgumentException("Deve ser entre 1 e 100!");}
  this.nome=nome;
  this.w=w;
  this.ef=ef;
  this.ac = (this.w * 100 / this.ef);
  this.calor = this.ac - this.w;
  this.certif = (ef >= 94) ? "80 Plus Titanium" :
                (ef >= 91) ? "80 Plus Platinum" :
                (ef >= 88) ? "80 Plus Gold" :
                (ef >= 85) ? "80 Plus Silver" :
                (ef >= 82) ? "80 Plus Bronze" :
                (ef >= 80) ? "80 Plus" : "Não";
 }
 // ↓ Simplesmente digitando o nome do instance dentro do parênteses no "System.out.println()" irá renderizar a string abaixo
 @Override
 public String toString() {
  return "\n::::: PROPRIEDADES DA FONTE DE ALIMENTAÇÃO :::::\nNome: "+nome+"\nCorrente contínua: "+w+"W\nCorrente alternada: "+ac+"W\nEficiência: "+ef+"%\nCalor: "+calor+"W\nCertificação: "+certif+"\n";
 }
 // ↓ NOTA: Para manter os atributos da classe como private e para serem visíveis por outras classes, os getters abaixo serão utilizados.
 public String verNome() {return nome;}
}
