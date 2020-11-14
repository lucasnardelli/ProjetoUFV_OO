# ProjetoUFV_OO
Projeto feito para a matéria de orientada a objeto

Universidade Federal de Viçosa
Campus Rio Paranaíba
Sistemas de Informação
SIN 141 - Programação Orientada a Objetos
Profª Rachel Reis

“Antivírus por um dia”
1. Introdução
Antivírus por um dia é um jogo de tabuleiro desktop colaborativo projetado para dois
jogadores. Esse jogo foi inventado por Clausius Reis e tem como objetivo percorrer os
setores da memória de um computador infectados por vírus. O jogador assume o papel de
antivírus, que deve avançar pelos setores, eliminando os vírus que encontrar, até que o
setor com a fonte de infecção seja alcançado. Mas tome cuidado, os vírus podem te destruir
no caminho.
2. Regras do Jogo
O jogo possui dois personagens principais, os jogadores e os inimigos (vírus), e é
baseado em um sistema de turnos para combate. Mais informações sobre o jogo são
apresentadas nas próximas subseções. 
2.1. Jogadores
O jogo é formado por dois tipos de jogadores: simples e de suporte.
1. Cada jogador possui um valor para ataque (ATK) e um valor de defesa (DEF), sendo
que o poder de ataque e defesa dos jogadores são fixos. O jogador simples deve ter
ATK=2 e DEF=6 e o jogador de suporte deve ter ATK=1 e DEF=7.
2. O jogador simples não possui habilidades especiais, já o jogador de suporte, possui
a capacidade de recuperar 2 pontos de sua defesa ou da defesa de outro jogador
que esteja no mesmo setor.
3. O jogador de suporte deve sempre possuir ataque menor que o jogador simples.
4. O jogador de suporte não pode existir sem um jogador simples.
5. O jogador simples pode executar as seguintes ações no jogo: movimentar, atacar e
procurar.
6. O jogador de suporte pode executar as seguintes ações no jogo: movimentar,
atacar, procurar e recuperar defesa.
7. As ações dos itens 6 e 7 serão detalhadas na seção Turno.
2.2. Inimigo
Os inimigos são os vírus de computador gerados por uma fonte de infecção. O objetivo do
jogo é que um dos jogadores, apresentados na Seção 2.1, encontre essa fonte de infecção.
1. Cada inimigo possui um valor para ataque (ATK) e um valor de defesa (DEF), sendo
que o poder de ataque e defesa devem ser inicialmente iguais, com valores entre 1 e
3. Por exemplo, um inimigo pode ter ATK=1 e DEF=1, e outro pode ter ATK=2 e
DEF=2.
2. Os valores de ATK e DEF devem ser definidos aleatoriamente, no momento em que
os inimigos forem criados.
3. Os inimigos só podem executar a ação de atacar, que será detalhada na seção
Turno.
4. Os inimigos não se movimentam, não efetuam procuras ou recuperam defesa
(somente os jogadores possuem essas ações).
2.3. Tabuleiro do jogo
O cenário do jogo é formado por um tabuleiro 5x5, conforme ilustrado na Figura 1.
Figura 1 – Tabuleiro inicial do jogo “Antivirus por um dia”.
Abaixo seguem as informações sobre o tabuleiro mostrado na Figura 1:
1. Os jogadores iniciam o jogo no centro do tabuleiro (posição C).
2. A fonte de infecção de vírus (posição X), que consiste no objetivo final, deve ser
aleatoriamente posicionada em qualquer posição do tabuleiro que não seja a central.
3. Cada posição do tabuleiro corresponde a um setor que o jogador deve percorrer, até
encontrar a fonte de infecção do vírus (X).
4. Cada setor possui uma posição no tabuleiro ([x,y]) e quatro lados que podem ser
portas ou paredes. Por exemplo, na Figura 1, a posição C corresponde ao Setor
[3,3], que possui quatro portas (*) e dois jogadores: P1 (jogador simples) e P2
(jogador de suporte).
5. Cada setor pode possuir até 4 portas para que um jogador se movimente entre os
setores. Estas portas serão definidas quando um jogador entrar em um novo setor.
6. Setores já criados não podem ter o número de portas e paredes alteradas.
7. Os limites do tabuleiro (parte externa) são sempre paredes, ou seja, não podem
possuir portas.
8. A posição inicial (C) sempre possui as 4 portas abertas, que estão representadas na
Figura 1 por um asterisco (*).
9. Podem existir 3 tipos de setores:
a. Setor normal: Não existe nenhuma restrição, ou seja, todas as ações dos
jogadores P1 e P2 podem ser executadas. Os inimigos sempre recebem o
dano de um ataque e a procura pode ser efetuada normalmente.
b. Setor oculto: A restrição neste setor é que quando o jogador efetuar um
ataque, o vírus pode ou não ser eliminado (aleatório), pois o jogador não
sabe a localização exata do vírus no setor.
c. Setor privado: A restrição é que os jogadores não podem executar a ação
de procurar no setor.
2.4. Turno
O jogo deve funcionar em sistema de turnos, alternando entre jogadores e inimigos.
1. Os jogadores possuem até 25 ciclos para encontrar a fonte de infecção do vírus (X).
Cada ciclo é formado pelos turnos do P1, P2 e inimigos.
2. Os jogadores iniciam no centro do tabuleiro (Turno 0) e devem selecionar uma das
portas do setor inicial (C) para se movimentar para um novo setor. O primeiro a jogar
é sempre o jogador simples (P1), seguido pelo jogador de suporte (P2).
3. Quando um jogador se movimentar para um setor ainda não visitado, três ações
devem ser realizadas:
a. O setor deve ser criado;
b. As portas e paredes deste setor devem ser definidas de forma aleatória. Para
maior probabilidade de criação de portas, sugere-se que um número maior
que 3 (entre 1 e 10) resulte em uma porta; e menor ou igual a 3, em uma
parede. Deve-se levar em consideração as portas e paredes dos setores
adjacentes já visitados (que não podem ser alterados).
c. Podem ser criados de 1 a 5 inimigos no setor, com ATK igual a DEF e no
intervalo de 1 a 3. Tanto o número de inimigos, quanto o seu ATK e DEF
devem gerados aleatoriamente.
Por exemplo, na Figura 2, os jogadores P1 e P2 se movimentaram para o mesmo
setor (Setor [3,4]), que foi criado com duas novas portas e uma parede, mantendo a porta
do setor anterior (Setor [3,3]). Também foram gerados 3 inimigos com ATK/DEF iguais a 1/1
(inimigo 1), 3/3 (inimigo 2) e 2/2 (inimigo 3).
Figura 2 – Jogadores P1 e P2 se movem para o mesmo setor.
4. Após a criação do setor e geração dos inimigos, o turno inicia com o jogador P1, que
pode executar duas ações*:
a. Atacar um inimigo. Por exemplo, suponha que P1 com ATK=2 ataque o
inimigo 2 (3/3). Esse ataque reduz em 2 a DEF do inimigo, ou seja, o inimigo
2 ficará com ATK/DEF igual a 3/1.
b. Procurar no setor por itens. Esta procura consiste em sortear um número
aleatório entre 1 e 6.
i. Para números entre 1 e 3, nada é encontrado no setor.
ii. Para número igual a 4, o jogador ganha 1 de DEF.
iii. Para número igual a 5, o jogador ganha 2 de DEF.
iv. Para número igual a 6, todos os inimigos do setor perdem 1 de DEF.
* Cada opção acima (a,b) representa uma única ação, ou seja, o jogador pode:
atacar duas vezes, atacar e procurar ou procurar duas vezes.
5. Após as duas ações do jogador P1, o turno do jogador P2 é iniciado. No seu turno,
P2 pode realizar as mesmas ações descritas no item 4. Além disso, o jogador P2
pode optar por usar sua habilidade especial (recuperar defesa) no lugar das ações
de atacar e procurar. Essa habilidade consiste em adicionar 2 a DEF dele ou do
jogador P1, desde que P1 esteja no mesmo setor que P2.
6. Após finalizar os turnos de P1 e P2, os inimigos que estiverem vivos iniciam seu
turno de ataque (única ação permitida). Cada inimigo ataca cada jogador uma única
vez (somente os jogadores que estiverem no mesmo setor). Por exemplo, suponha
que o inimigo 3 (2/2) ataque P1 (2/6) e P2 (1/7). Para cada ataque, um número
aleatório entre 1 e 6 deve ser gerado. Se o número for par, o ataque é realizado;
caso contrário, nada acontece. No caso do ataque ser destinado a P1, ele ficará com
2/4, ou seja, a DEF do jogador atacado é reduzida pelo ATK do inimigo atacante. Em
seguida, o inimigo 3 deve atacar P2 usando esse mesmo raciocínio.
7. Após todos os inimigos do setor finalizarem seu ataque, um novo ciclo é iniciado.
8. Os jogadores P1 e P2 só podem se movimentar para outro setor, quando não
existirem mais inimigos no setor em que eles se encontram. A Figura 3 mostra um
exemplo em que P1 se movimentou para o Setor [2,4] e P2 para o Setor [3,5], em
que novas portas e inimigos foram gerados.
Figura 3 – Jogadores P1 e P2 se movem para setores diferentes.
9. Setores já visitados não geram novos inimigos, porém ao passar por este setor, o
jogador pode usar o seu turno para procurar itens (P1, P2) ou recuperar defesa
(P2).
10. O jogo pode terminar de três formas:
a. Um jogador (P1 ou P2) entra no setor que se encontra a fonte de infecção
(X). Nesse caso, o jogador que entrar no setor será o vencedor do jogo.
b. Quando exceder o número de 25 ciclos.
c. Quando todos os jogadores forem eliminados pelos inimigos (DEF <= 0).
