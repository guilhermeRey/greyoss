package org.greyoss.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Kallajian {
	public static void main(String[] args) {
        opcaoJogo();//Chama a fun��o que ir� receber a op��o que sera escolhida o modo do jogo
    }

    public static void opcaoJogo() {//Fun��o opcaoJogo recebe o modo do jogo que ser� executado
        int opcao = imprimeMenuPrincipal();//variavel opcao chama a fun��o imprimeMenuPrincipal que recebera a escolha do usuario 
        while (opcao == 1 || opcao == 2 || opcao == 3) {//Certifica que enquanto uma das op��es for 1 ou 2 ou 3, o jogo vai continuar
            switch (opcao) {
                case 1://Se a op��o digitada for 1, ir� executar o modo jogador vs jogador
                    modoJogador();//chama conjunto de instru��es que executa o modoJogador
                    opcao = imprimeMenuPrincipal();//variavel opcao chama a fun��o imprimeMenuPrincipal que recebera a escolha do usuario novamente ao termino do modoJogador
                    break;//impede que os comandos abaixo sejam executados quando a op��o 1 acabar
                case 2://Se a op��o digitada for 2, ir� executar o modo jogador vs computadorFacil
                    modoFacil();//chama conjunto de instru��es que executa o modoFacil
                    opcao = imprimeMenuPrincipal();//variavel opcao chama a fun��o imprimeMenuPrincipal que recebera a escolha do usuario novamente ao termino do modoFacil
                    break;//impede que os comandos abaixo sejam executados quando a op��o 2 acabar
                case 3://Se a op��o digitada for 3, ir� executar o modo jogador vs computadorDificil
                    modoDificil();//chama conjunto de instru��es que executa o modoDificil
                    opcao = imprimeMenuPrincipal();//variavel opcao chama a fun��o imprimeMenuPrincipal que recebera a escolha do usuario novamente ao termino do modoDificil
                    break;//impede que os comandos abaixo sejam executados quando a op��o 3 acabar
            }
        }
    }

    public static int imprimeMenuPrincipal() {//Fun��o ImprimeMenuPrincipal mostra na tela as op��es possiveis que o usuario deve digitar
        Scanner leitor = new Scanner(System.in);//Comando que permite ler uma entrada feita pelo usuario
        int opcao;//variavel opcao � criada
        System.out.println("  xoxo | JOGO DA VELHA | oxox");//imprime o titulo jogo da velha
        System.out.println();//pula uma linha visualmente
        System.out.println("             MENU");//imprime o titulo Menu
        System.out.println();//pula uma linha visualmente
        System.out.println("     1 - JOGADOR x JOGADOR");//Informa que a op��o 1 um ir� executar o modoJogador
        System.out.println(" 2 - JOGADOR x COMPUTADOR F�CIL");//Informa que a op��o 1 um ir� executar o modoFacil
        System.out.println("3 - JOGADOR x COMPUTADOR DIF�CIL");//Informa que a op��o 1 um ir� executar o modoDificil
        System.out.println("          4 - SAIR");//Informa que a op��o 4 um ir� encerrar o programa
        System.out.println();//pula uma linha visualmente
        System.out.print("Digite sua escolha: ");//Informa ao usuario que devera fazer a sua escolha
        opcao = leitor.nextInt();//variavel opcao recebe o numero inserido pelo usuario
        while (opcao <= 0 || opcao > 4) {//Certifica que o numero inserido seja valido
            System.out.print("Op��o inv�lida. Escolha novamente: ");//Informa ao usuario que a opcao inserida n�o � valida
            opcao = leitor.nextInt();//variavel opcao recebe o numero inserido pelo usuario novamente
        }
        switch (opcao) {
            case 1://Se a op��o digitada for 1, ir� mostrar o titulo jogador vs jogador
                System.out.println();//pula uma linha visualmente
                System.out.println("JOGADOR x JOGADOR");//imprime o titulo jogador vs jogador
                System.out.println();//pula uma linha visualmente
                break;//impede que os comandos abaixo sejam executados quando a op��o 1 acabar
            case 2://Se a op��o digitada for 2, ir� mostrar o titulo jogador vs Maquina Facil
                System.out.println();//pula uma linha visualmente
                System.out.println("JOGADOR x COMPUTADOR F�CIL");//imprime o titulo Maquina Facil
                System.out.println();//pula uma linha visualmente
                break;//impede que os comandos abaixo sejam executados quando a op��o 2 acabar
            case 3://Se a op��o digitada for 3, ir� mostrar o titulo jogador vs Maquina Facil
                System.out.println();//pula uma linha visualmente
                System.out.println("JOGADOR x COMPUTADOR DIF�CIL");//imprime o titulo Maquina Dificil
                System.out.println();//pula uma linha visualmente
                break;//impede que os comandos abaixo sejam executados quando a op��o 3 acabar
            case 4://Se a op��o digitada for 4, ir� mostrar o titulo SAIR
                System.out.println();//pula uma linha visualmente
                System.out.println("SAIR");//imprime o titulo SAIR
                System.out.println();//pula uma linha visualmente
                break;//impede que haja falha no switch quando a op��o 4 acabar
        }
        return opcao;//return devolve o valor inserido pelo usuario para a fun��o
    }

    public static int[][] inicializarTabuleiro() {//Fun��o que cria a matriz responsavel pelo jogo
        int tabuleiroInicio[][] = new int[3][3];//matriz tabuleiroInicio � criada definida com tamanho de 3 linhas e 3 colunas
        for (int i = 0; i < tabuleiroInicio.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
            for (int j = 0; j < tabuleiroInicio[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas existentes em cada linha da matriz
                tabuleiroInicio[i][j] = 0;//todas as posi��es do tabuleiro recebem o valor zero;
            }
        }
        return tabuleiroInicio;//return devolve a matriz criada
    }

    public static void imprimirTabuleiro(String[][] tabuleiro) {//Fun��o que imprime a matriz responsavel pelo jogo recebe como parametro a fun��o Jogar
        System.out.println();//pula uma linha visualmente
        System.out.println("  " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);//Layout da linha 0 
        System.out.println("-------------");
        System.out.println("  " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);//Layout da linha 1 
        System.out.println("-------------");
        System.out.println("  " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);//Layout da linha 2 
        System.out.println();//pula uma linha visualmente
    }

    public static int leiaCoordenadaLinha() {//Fun��o que l� a coordenada Linha que ser� inserida pelo usuario
        Scanner leitor = new Scanner(System.in);//Comando que permite ler uma entrada feita pelo usuario
        System.out.print("Linha: ");//Solicita que seja inserido a coordenada Linha
        int linha = leitor.nextInt();//Variavel Linha � criada e recebe o valor inserido pelo usuario
        return linha;//return devolve o valor inserido pelo usuario para a fun��o
    }

    public static int leiaCoordenadaColuna() {//Fun��o que l� a coordenada Coluna que ser� inserida pelo usuario
        Scanner leitor = new Scanner(System.in);//Comando que permite ler uma entrada feita pelo usuario
        System.out.print("Coluna: ");//Solicita que seja inserido a coordenada Coluna
        int coluna = leitor.nextInt();//Variavel Coluna � criada e recebe o valor inserido pelo usuario
        return coluna;//return devolve o valor inserido pelo usuario para a fun��o
    }

    public static void imprimePontuacao(int pontuacao1, int pontuacao2) {//Fun��o que imprime o placar parcial da partida, recebe como parametro as pontua��es de cada jogador apos uma vitoria 
        System.out.println();//pula uma linha visualmente
        System.out.println("xoxo | PLACAR | oxox");//imprime o titulo Placar
        System.out.println();//pula uma linha visualmente
        System.out.println("JOGADOR X | JOGADOR O");//imprime os titulos de Jogador X e Jogador O
        System.out.println("    " + pontuacao1 + "           " + pontuacao2);//imprime a pontua��o parcial da partida
        System.out.println();//pula uma linha visualmente
    }

    public static boolean posicaoValida(int linha, int coluna, int[][] jogodavelha) {//Fun��o que verifica se as coordenadas recebidas por parametro s�o validas e j� n�o foram inseridas antes
        boolean valida = true;//Cria e inicia a variavel logica valida como verdadeira;
        if ((linha >= 0 && linha <= 2) && (coluna >= 0 && coluna <= 2)) {//Certifica que a coordenada recebida seja valida
            if (jogodavelha[linha][coluna] == 0) {//Verifica se a coordenada recebida ainda esta zerada no tabuleiro
                valida = true;//variavel valida recebe verdadeiro caso a coordenada ainda seja zero
            } else {//Caso a coordenada recebida n�o esteja zerada no tabuleiro
                valida = false;//variavel valida recebe falso caso a coordenada seja diferente de zero
            }
        } else {//Certificou que a coordenada recebida � invalida
            valida = false;//variavel valida recebe falso pois a coordenada recebida � invalida
        }
        return valida;//return devolve o valor logico para a fun��o
    }

    public static boolean verificaVencedor(int[][] tabuleiro) {//Fun��o que recebe como parametro o jogo da velha e verifica a cada jogado se houve algum vencedor
        int somaL0 = 0, somaL1 = 0, somaL2 = 0, somad = 0, somad2 = 0;//Cria��o e inicializa��o das variaveis que ir�o auxiliar nas compara��es
        int somaC0 = 0, somaC1 = 0, somaC2 = 0;//Cria��o e inicializa��o das variaveis que ir�o auxiliar nas compara��es
        boolean vencedor = false;//Variavel Logica vencedor � criada e inicializada como falsa
        for (int i = 0; i < tabuleiro.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
            for (int j = 0; j < tabuleiro[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas existentes em cada linha da matriz
                if (i == 0) {//Se indice de Linha � zero executa a seguinte instru��o
                    somaL0 = somaL0 + tabuleiro[i][j];//soma da linha recebe ela mesma mais o valor da matriz
                }
                if (i == 1) {//Se indice de Linha � 1 executa a seguinte instru��o
                    somaL1 = somaL1 + tabuleiro[i][j];//soma da linha recebe ela mesma mais o valor da matriz
                }
                if (i == 2) {//Se indice de Linha � 2 executa a seguinte instru��o
                    somaL2 = somaL2 + tabuleiro[i][j];//soma da linha recebe ela mesma mais o valor da matriz
                }
                if (i == j) {//Se indice de Linha � igual ao indice de Coluna executa a seguinte instru��o
                    somad = somad + tabuleiro[i][j];//soma da diagonalPrincipal recebe ela mesma mais o valor da matriz
                }
                if (i + j == 2) {//Se indice de Linha somado ao indice de Coluna � igual a 2, executa a seguinte instru��o
                    somad2 = somad2 + tabuleiro[i][j];//soma da diagonalSecundaria recebe ela mesma mais o valor da matriz
                }
            }
        }
        for (int i = 0; i < tabuleiro.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
            for (int j = 0; j < tabuleiro[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas existentes em cada linha da matriz
                if (i == 0) {//Se indice de Coluna � zero executa a seguinte instru��o
                    somaC0 = somaC0 + tabuleiro[j][i];//soma da coluna recebe ela mesma mais o valor da matriz
                }
                if (i == 1) {//Se indice de Coluna � 2 executa a seguinte instru��o
                    somaC1 = somaC1 + tabuleiro[j][i];//soma da coluna recebe ela mesma mais o valor da matriz
                }
                if (i == 2) {//Se indice de Coluna � 2 executa a seguinte instru��o
                    somaC2 = somaC2 + tabuleiro[j][i];//soma da coluna recebe ela mesma mais o valor da matriz
                }
            }
        }
        if (somaL0 == 3 || somaL1 == 3 || somaL2 == 3 || somad == 3 || somad2 == 3) {//Verifica se a soma de cada linha e diagonais � igual a 3
            vencedor = true;//Variavel Logica vencedor recebe verdadeiro caso a verica��o acima seja verdadeira
        } else if (somaL0 == -3 || somaL1 == -3 || somaL2 == -3 || somad == -3 || somad2 == -3) {//Verifica se a soma de cada linha e diagonais � igual a -3
            vencedor = true;//Variavel Logica vencedor recebe verdadeiro caso a verica��o acima seja verdadeira
        } else if (somaC0 == 3 || somaC1 == 3 || somaC2 == 3) {//Verifica se a soma de cada Coluna � igual a 3
            vencedor = true;//Variavel Logica vencedor recebe verdadeiro caso a verica��o acima seja verdadeira
        } else if (somaC0 == -3 || somaC1 == -3 || somaC2 == -3) {//Verifica se a soma de cada Coluna � igual a -3
            vencedor = true;//Variavel Logica vencedor recebe verdadeiro caso a verica��o acima seja verdadeira
        }

        return vencedor;//return devolve o valor logico para a fun��o
    }

    public static boolean verificaVelha(int[][] tabuleiro) {//Fun��o que recebe como parametro o jogo da velha e verifica a cada jogado se houve empate
        boolean velha = true;//Variavel Logica velha � criada e inicializada como verdadeira
        for (int i = 0; i < tabuleiro.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
            for (int j = 0; j < tabuleiro[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas existentes em cada linha da matriz
                if (tabuleiro[i][j] == 0) {//Verifica se a coordenada ainda esta zerada no tabuleiro
                    velha = false;//variavel velha falso caso a coordenada ainda seja zero, pois ainda h� jogadas possiveis
                }
            }
        }
        return velha;//return devolve o valor logico para a fun��o
    }

    public static String[][] jogar(int linha, int coluna, int[][] tabuleiro) {//Fun��o que recebe como parametro o jogo da velha e coordenadas validadas e substitui as intera��es por X e O
        String[][] tabuleiroXO = new String[3][3];//matriz tabuleiroXO � criada e definida com tamanho de 3 linhas e 3 colunas
        for (int i = 0; i < tabuleiro.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
            for (int j = 0; j < tabuleiro[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas existentes em cada linha da matriz
                if (tabuleiro[i][j] == 1) {//Verifica se o valor na posi��o [i][j] � igual a 1 
                    tabuleiroXO[i][j] = "X";//Se for 1 ir� imprimir um "X" no lugar
                } else if (tabuleiro[i][j] == -1) {//Verifica se o valor na posi��o [i][j] � igual a -1 
                    tabuleiroXO[i][j] = "O";//Se for -1 ir� imprimir um "O" no lugar
                } else {//Caso o valor na posi��o [i][j] � diferente de 1 e -1
                    tabuleiroXO[i][j] = "-";//Se for diferente de 1 e -1 ir� imprimir um "-" no lugar
                }
            }
        }
        return tabuleiroXO;//return devolve a matriz impresa com as altera��es ocorridas
    }

    public static int[][] jogadaUsuario(int[][] tabuleiro, int jogador) {//Fun��o que cria o ambiente de jogo entre jogador vs jogador
        int linha = leiaCoordenadaLinha();//Variavel Linha � criada e chama a fun��o coordenada Linha que recebera um valor inserido pelo usuario
        int coluna = leiaCoordenadaColuna();//Variavel Coluna � criada e chama a fun��o coordenada Coluna que recebera um valor inserido pelo usuario
        linha--;//Entende-se que o valor inserido � maior que a posi��o real da Matriz a varivael linha � decrementada
        coluna--;//Entende-se que o valor inserido � maior que a posi��o real da Matriz a varivael coluna � decrementada
        boolean posicao = posicaoValida(linha, coluna, tabuleiro);//Variavel Posicao � criada e chama a fun��o PosicaoValida para verificar as coordenadas inserida pelo usuario s�o validas
        while (posicao == false) {//Certifica que a posicao inserida seja valida
            System.out.println("Posi��o inv�lida. Digite novamente.");//Informa ao usuario que a coordenada inserida n�o � valida
            linha = leiaCoordenadaLinha();//Variavel Linha chama a fun��o coordenada Linha que recebera um valor inserido pelo usuario novamente
            coluna = leiaCoordenadaColuna();//Variavel Coluna chama a fun��o coordenada Coluna que recebera um valor inserido pelo usuario novamente
            linha--;//Entende-se que o valor inserido � maior que a posi��o real da Matriz a varivael linha � decrementada 
            coluna--;//Entende-se que o valor inserido � maior que a posi��o real da Matriz a varivael coluna � decrementada
            posicao = posicaoValida(linha, coluna, tabuleiro);//Variavel Posicao chama a fun��o PosicaoValida para verificar as coordenadas inserida pelo usuario s�o validas
        }
        tabuleiro[linha][coluna] = jogador;//Matriz tabuleiro recebe na coordenada ja validada a jogada do jogador X ou Jogador O conforme recebeu na fun��o como parametro
        imprimirTabuleiro(jogar(linha, coluna, tabuleiro));//A fun��o Imprimir tabuleiro chama a fun��o jogar para modificar os elementos por "X" e "O" e "-" e imprime tudo na tela
        return tabuleiro;//return tabuleiro � devolvido para o ModoJogador
    }

    public static int[][] jogadaMaquinaFacil(int[][] tabuleiro) {//Fun��o que cria o ambiente de jogo entre jogador vs Maquina Facil
        Random gerador = new Random();//Comando que permite gerar valores aleatorios para as jogadas da Maquina no Modo Facil
        int linha = gerador.nextInt(3);//Variavel Linha � criada e recebe um valor aleatorio 0 ou 1 ou 2
        int coluna = gerador.nextInt(3);//Variavel Coluna � criada e recebe um valor aleatorio 0 ou 1 ou 2
        boolean posicao = posicaoValida(linha, coluna, tabuleiro);//Variavel Posicao � criada e chama a fun��o PosicaoValida para verificar as coordenadas geradas aleatoriamente s�o validas
        while (posicao == false) {//Certifica que a posicao gerada aleatoriamente seja valida
            linha = gerador.nextInt(3);//Variavel Linha � criada e recebe um valor aleatorio 0 ou 1 ou 2 novamente
            coluna = gerador.nextInt(3);//Variavel Coluna � criada e recebe um valor aleatorio 0 ou 1 ou 2 novamente
            posicao = posicaoValida(linha, coluna, tabuleiro);//Variavel Posicao � criada e chama a fun��o PosicaoValida para verificar as coordenadas geradas aleatoriamente s�o validas novamente
        }
        tabuleiro[linha][coluna] = -1;//Matriz tabuleiro recebe na coordenada ja validada a jogada da MaquinaFacil
        imprimirTabuleiro(jogar(linha, coluna, tabuleiro));//A fun��o Imprimir tabuleiro chama a fun��o jogar para modificar os elementos por "X" e "O" e "-" e imprime tudo na tela
        return tabuleiro;//return tabuleiro � devolvido para o ModoFacil
    }

    public static int[][] jogadaMaquinaDificil(int[][] tabuleiro) {//Fun��o que cria o ambiente de jogo entre jogador vs Maquina Dificil
        int somaL0 = 0, somaL1 = 0, somaL2 = 0; //recebe a soma da pontua��o de cada linha 
        int somaC0 = 0, somaC1 = 0, somaC2 = 0; //recebe a soma da pontua��o de cada coluna
        int somaD = 0, somaD2 = 0; //recebe a soma da pontua��o de cada diagonal
        int linha = 1, coluna = 2, diagonal = 3; //variaveis para diferenciar se a verifica��o da posicaoVazia � linha, coluna ou diagonal
        int[] posicao = new int[2]; //recebe as coordenadas de linha e coluna da fun��o posicaoVazia
        if (tabuleiro[1][1] == 0) {//verifica se o meio est� vazio
            tabuleiro[1][1] = -1;//se sim, o meio recebe a jogada do computador
        } else {//se n�o, � executado conjunto de comandos abaixo
            for (int i = 0; i < tabuleiro.length; i++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
                for (int j = 0; j < tabuleiro[i].length; j++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas em cada linha da matriz
                    if (i == 0) {//Se indice da linha na matriz � zero executa conjunto de comandos respectivos
                        somaL0 = somaL0 + tabuleiro[i][j];//soma da linha recebe o valor da matriz
                        somaC0 = somaC0 + tabuleiro[j][i];//soma da coluna recebe o valor da matriz
                        if (somaL0 == -2 && j == 2) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1; //Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        } else if (somaC0 == -2 && j == 2) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        }
                    } else if (i == 1) {//Se indice da linha na matriz � 2 executa conjunto de comandos respectivos
                        somaL1 = somaL1 + tabuleiro[i][j];//soma da linha recebe o valor da matriz
                        somaC1 = somaC1 + tabuleiro[j][i];//soma da coluna recebe o valor da matriz
                        if (somaL1 == -2 && j == 2 && (somaL0 != -2 && somaC0 != -2)) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        } else if (somaC1 == -2 && j == 2 && (somaL0 != -2 && somaC0 != -2)) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        }
                    } else if (i == 2) {//Se indice da linha na matriz � 2 executa conjunto de comandos respectivos
                        somaL2 = somaL2 + tabuleiro[i][j];//soma da linha recebe o valor da matriz
                        somaC2 = somaC2 + tabuleiro[j][i];//soma da coluna recebe o valor da matriz
                        if (somaL2 == -2 && j == 2 && ((somaL0 != -2 && somaC0 != -2) && (somaL1 != -2 && somaC1 != -2))) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        } else if (somaC2 == -2 && j == 2 && ((somaL0 != -2 || somaC0 != -2) && (somaL1 != -2 || somaC1 != -2))) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                            posicao = posicaoVazia(tabuleiro, i, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                            linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                            coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                            tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                        }
                    }
                }
            }

            if (somaL0 != -2 && somaL1 != -2 && somaL2 != -2 && somaC0 != -2 && somaC1 != -2 && somaC2 != -2) {//Verifica se em cada linha ou coluna existe a possibilidade da maquina vencer
                for (int k = 0; k < tabuleiro.length; k++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
                    for (int l = 0; l < tabuleiro[k].length; l++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas em cada linha da matriz
                        if (k == l) {//Verifica se � a diagonalPrincipal
                            somaD = somaD + tabuleiro[k][l];//soma da diagonalPrincipal recebe o valor da matriz
                            if (somaD == -2 && k == 2) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                                posicao = posicaoVazia(tabuleiro, k, diagonal);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            }
                            if (k + l == 2) {//Verifica se � a diagonalSecundaria
                                somaD2 = somaD2 + tabuleiro[k][l];//soma da diagonalSecundaria recebe o valor da matriz
                                if (somaD2 == -2 && k == 2) {//se soma for igual a -2 e j� estiver na �ltima verifica��o de posi��o
                                    posicao = posicaoVazia(tabuleiro, k, diagonal);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                    linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                    coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                    tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                                }
                            }
                        }
                    }
                }
            }
            //BLOQUEAR
            if (somaL0 != -2 && somaL1 != -2 && somaL2 != -2 && somaC0 != -2 && somaC1 != -2 && somaC2 != -2 && somaD != -2 && somaD2 != -2) {//Verifica se em cada linha ou coluna existe a possibilidade da maquina vence
                somaL0 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaL1 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaL2 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaC0 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaC1 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaC2 = 0;//zera a variavel para compara��o de bloquear jogadas
                somaD = 0; //zera a variavel para compara��o de bloquear jogadas
                somaD2 = 0;//zera a variavel para compara��o de bloquear jogadas
                linha = 1; //variavel linha recebe 1 para diferenciar se a verifica��o da posicaoVazia � linha
                coluna = 2;//variavel coluna recebe 2 para diferenciar se a verifica��o da posicaoVazia � Coluna
                diagonal = 3;//variavel diagonal recebe 3 para diferenciar se a verifica��o da posicaoVazia � Diagonal
                for (int k = 0; k < tabuleiro.length; k++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
                    for (int l = 0; l < tabuleiro[k].length; l++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas em cada linha da matriz
                        if (k == 0) {//Se indice da linha na matriz � zero executa conjunto de comandos respectivos
                            somaL0 = somaL0 + tabuleiro[k][l];//soma da linha recebe o valor da matriz
                            somaC0 = somaC0 + tabuleiro[l][k];//soma da coluna recebe o valor da matriz
                            if (somaL0 == 2 && l == 2) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            } else if (somaC0 == 2 && l == 2) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            }
                        } else if (k == 1) {//Se indice da linha na matriz � 1 executa conjunto de comandos respectivos
                            somaL1 = somaL1 + tabuleiro[k][l];//soma da linha recebe o valor da matriz
                            somaC1 = somaC1 + tabuleiro[l][k];//soma da coluna recebe o valor da matriz
                            if (somaL1 == 2 && l == 2 && (somaL0 != 2 && somaC0 != 2)) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            } else if (somaC1 == 2 && l == 2 && (somaL0 != 2 && somaC0 != 2)) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            }
                        } else if (k == 2) {//Se indice da linha na matriz � 2 executa conjunto de comandos respectivos
                            somaL2 = somaL2 + tabuleiro[k][l];//soma da linha recebe o valor da matriz
                            somaC2 = somaC2 + tabuleiro[l][k];//soma da coluna recebe o valor da matriz
                            if (somaL2 == 2 && l == 2 && ((somaL0 != 2 && somaC0 != 2) && (somaL1 != 2 && somaC1 != 2))) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, linha);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            } else if (somaC2 == 2 && l == 2 && ((somaL0 != 2 && somaC0 != 2) && (somaL1 != 2 && somaC1 != 2))) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, k, coluna);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            }
                        }
                    }
                }
            }

            if (somaL0 != -2 && somaL1 != -2 && somaL2 != -2 && somaC0 != -2 && somaC1 != -2 && somaC2 != -2 && somaD != -2 && somaD2 != -2 &&
                    somaL0 != 2 && somaL1 != 2 && somaL2 != 2 && somaC0 != 2 && somaC1 != 2 && somaC2 != 2) {//Verifica se em cada linha ou coluna n�o existe a possibilidade da maquina vencer
                for (int m = 0; m < tabuleiro.length; m++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de linhas da matriz
                    for (int n = 0; n < tabuleiro[m].length; n++) {//La�o de repeti��o iniciado em 0 e vai ate o tamanho de colunas em cada linha da matriz
                        if (m == n) {//Verifica se � a diagonalPrincipal
                            somaD = somaD + tabuleiro[m][n];//soma da diagonalPrincipal recebe o valor da matriz
                            if (somaD == 2 && m == 2) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                posicao = posicaoVazia(tabuleiro, m, diagonal);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                            }
                            if (m + n == 2) {//Verifica se � a diagonalSecundaria
                                somaD2 = somaD2 + tabuleiro[m][n];//soma da diagonalSecundaria recebe o valor da matriz
                                if (somaD2 == 2 && m == 2) {//se soma for igual a 2 e j� estiver na �ltima verifica��o de posi��o para tentar bloquear
                                    posicao = posicaoVazia(tabuleiro, m, diagonal);//posicao recebe as coordenadas de qual posi��o est� vazia para preenchimento
                                    linha = posicao[0];//recebe a coordenada linha da fun��o posicaoVazia
                                    coluna = posicao[1];//recebe a coordenada coluna da fun��o posicaoVazia
                                    tabuleiro[linha][coluna] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                                }
                            }
                        }
                    }
                }
            }

            if (somaL0 != -2 && somaL1 != -2 && somaL2 != -2 && somaC0 != -2 && somaC1 != -2 && somaC2 != -2 && somaD != -2 && somaD2 != -2 && 
                    somaL0 != 2 && somaL1 != 2 && somaL2 != 2 && somaC0 != 2 && somaC1 != 2 && somaC2 != 2 && somaD != 2 && somaD2 != 2) {//Verifica se em cada linha ou coluna n�o existe a possibilidade da maquina vencer
                if (tabuleiro[0][0] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[0][0] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[0][2] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[0][2] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[2][0] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[2][0] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[2][2] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[2][2] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[0][1] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[0][1] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[1][0] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[1][0] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[1][2] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[1][2] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                } else if (tabuleiro[2][1] == 0) {//verifica se Coordenada Linha e Coluna est� vazia
                    tabuleiro[2][1] = -1;//Atribui para as coordenadas de linha e coluna o valor de -1 como jogada da Maquina Dificil
                }
            }
        }
        imprimirTabuleiro(jogar(linha, coluna, tabuleiro));//A fun��o Imprimir tabuleiro chama a fun��o jogar para modificar os elementos "1" e "-1" e "0", respectivamente por "X" e "O" e "-" e imprime tudo na tela
        return tabuleiro;//return devolve a intera��o caso aconte�a para a fun��o
    }

    public static int[] posicaoVazia(int[][] tabuleiro, int i, int pos) {//Fun��o que verifica se existe uma posi��o vazia e as demais preenchidas por linha ou coluna ou diagonal
        int posicaoVazia[] = new int[2];//Vetor posicaoVazia � criado com tamanho 2
        if (pos == 1) {//Verifica Linhas
            for (int j = 0; j < 3; j++) {//La�o de repeti��o ira fazer conjunto de intru�oes enquanto menor que 3
                if (tabuleiro[i][j] == 0) {//Verifica se a coordenada [i][j] no tabuleiro � igual a zero
                    posicaoVazia[0] = i;//vetor posicaoVazia de indice 0 recebe a coodenada da Linha
                    posicaoVazia[1] = j;//vetor posicaoVazia de indice 1 recebe a coodenada da Coluna
                }
            }
        } else if (pos == 2) {//Verifica Colunas
            for (int j = 0; j < 3; j++) {//La�o de repeti��o ira fazer conjunto de intru�oes enquanto menor que 3
                if (tabuleiro[j][i] == 0) {//Verifica se a coordenada [j][i] no tabuleiro � igual a zero
                    posicaoVazia[0] = j;//vetor posicaoVazia de indice 0 recebe a coodenada da Coluna
                    posicaoVazia[1] = i;//vetor posicaoVazia de indice 1 recebe a coodenada da Linha
                }
            }

        } else {//Verifica Diagonais
            for (int j = 0; j < tabuleiro.length; j++) {//La�o de repeti��o ira fazer conjunto de intru�oes enquanto menor que o tamanho de linhas da matriz Tabuleiro
                for (int k = 0; k < tabuleiro[i].length; k++) {//La�o de repeti��o ira fazer conjunto de intru�oes enquanto menor que o tamanho de colunas em cada linha da matriz Tabuleiro
                    if (j == k && tabuleiro[j][k] == 0) {//Verifica se a coordenada [j][k] no tabuleiro possue valor igual a zero e se J e K possuem mesmos indice para ser a diagonal Principal
                        posicaoVazia[0] = j;//vetor posicaoVazia de indice 0 recebe a coodenada da Linha
                        posicaoVazia[1] = k;//vetor posicaoVazia de indice 1 recebe a coodenada da Coluna
                    }
                    if (j + k == 2 && tabuleiro[j][k] == 0) {//Verifica se a coordenada [j][k] no tabuleiro possue valor igual a zero e se a soma de J e K � igual a 2 para ser a diagonal Secundaria
                        posicaoVazia[0] = j;//vetor posicaoVazia de indice 0 recebe a coodenada da Linha
                        posicaoVazia[1] = k;//vetor posicaoVazia de indice 1 recebe a coodenada da Coluna
                    }
                }
            }
        }

        return posicaoVazia;//return coordenada ainda n�o jogada � devolvida para a fun��o
    }

    public static void modoJogador() {//Fun��o ir� executar o modo jogador vs jogador
        int[][] tabuleiro = inicializarTabuleiro();//Matriz tabuleiro � criada e recebe a fun��o inicializarTabuleiro que ira iniciar o jogo;
        int jogador1 = 1, jogador2 = -1;//Variaveis Jogador1 e Jogador2 s�o criadas e iniciadas com valores 1 e -1 respectivamente, ser�o estas as intera��es realizadas na matriz
        int vez = 1;//Variavel vez � criada e iniciada em 1, confome cada rodada ela � decrementada e incrementada definindo assim de quem � a vez de jogar
        boolean vencedor, velha;//Variaveis logicas Vencedor e Velha s�o criadas, onde posteiormente cada uma ira receber uma fun��o respectivamente adequadas
        int pontuacao1 = 0, pontuacao2 = 0;//Variaveis pontuacao1 e pontuacao2 s�o criadas e iniciadas com valor 0(zero), ser�o os parametros para verificar as pontua�oes parciais
        System.out.println();//Pula uma Linha visualmente
        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar da partida 
        System.out.println();//Pula uma Linha visualmente
        while (pontuacao1 <= 3 || pontuacao2 <= 3) {//Verifica a cada vitoria se o total de vitorias do Jogador X ou Jogador O chegou a 3 no ModoJogador
            if (vez == 1) {//Variavel Vez valendo 1, Jogador X ir� realizar a jogada
                System.out.println("JOGADOR X");//Informa que � a vez do Jogador X
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaUsuario(tabuleiro, jogador1);//Matriz tabuleiro chama a fun��o JogadaUsuario executando o conjunto de instru�oes respectivos l� presentes
                vencedor = verificaVencedor(tabuleiro);//Variavel vencedor chama a fun��o verificaVencedor e verifica se a jogada realizada retornou um verdadeiro confirmando a virotia jo Jogador X
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao1++;//Variavel pontua��o1 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Jogador X
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es 
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Jogador O na proxima rodada
                    } else {//Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Jogador O na proxima rodada
                    }
                }

            } else {//Variavel Vez valendo -1, Jogador O ir� realizar a jogada
                System.out.println("JOGADOR O");//Informa que � a vez do Jogador O
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaUsuario(tabuleiro, jogador2);
                vencedor = verificaVencedor(tabuleiro);
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao2++;//Variavel pontua��o2 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Jogador O
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    } else {//Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    }
                }
            }

            if (pontuacao1 == 3 || pontuacao2 == 3) {//Verifica se uma das pontua��es chegou a 3 para informar quem foi o vencedor da partida
                if (pontuacao1 == 3) {//Se pontuacao do Jogador X chegou a 3 executa conjunto de comandos
                    System.out.println("~x~x~x~ VENCEDOR: JOGADOR X ~x~x~x~");//Informa que o Jogador X foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que os comandos abaixo sejam executados se a pontuacao1 for igual a 3
                } else {//Se pontuacao do Jogador X n�o chegou a 3 executa conjunto de comandos
                    System.out.println("~o~o~o~ VENCEDOR: JOGADOR O ~o~o~o~");//Informa que o Jogador O foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que demais comandos sejam executados se a pontuacao1 for diferente de 3
                }
            }
        }
    }

    public static void modoFacil() {//Fun��o ir� executar o modo jogador vs MaquinaFacil
        int[][] tabuleiro = inicializarTabuleiro();//Matriz tabuleiro � criada e recebe a fun��o inicializarTabuleiro
        int jogador1 = 1;//Variavel Jogador1 � criada e iniciada com valor 1, ser�o estas as intera��es realizadas na matriz pelo usuario
        int vez = 1;//Variavel vez � criada e iniciada em 1, confome cada rodada ela � decrementada e incrementada definindo assim de quem � a vez de jogar
        boolean vencedor, velha;//Variaveis logicas Vencedor e Velha s�o criadas, onde posteiormente cada uma ira receber uma fun��o respectivamente adequadas
        int pontuacao1 = 0, pontuacao2 = 0;//Variaveis pontuacao1 e pontuacao2 s�o criadas e iniciadas com valor 0(zero), ser�o os parametros para verificar as pontua�oes parciais
        System.out.println();//Pula uma Linha visualmente
        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar da partida 
        System.out.println();//Pula uma Linha visualmente
        while (pontuacao1 <= 3 || pontuacao2 <= 3) {//Verifica a cada vitoria se o total de vitorias do Jogador ou da Maquina chegou a 3 no ModoFacil
            if (vez == 1) {//Variavel Vez valendo 1, Jogador X ir� realizar a jogada
                System.out.println("JOGADOR X");//Informa que � a vez do Jogador X
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaUsuario(tabuleiro, jogador1);//Matriz tabuleiro chama a fun��o JogadaUsuario executando o conjunto de instru�oes respectivos l� presentes
                vencedor = verificaVencedor(tabuleiro);//Variavel vencedor chama a fun��o verificaVencedor e verifica se a jogada realizada retornou um verdadeiro confirmando a virotia jo Jogador X
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao1++;//Variavel pontua��o1 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Jogador X
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Computador O na proxima rodada
                    } else { //Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Computador O na proxima rodada
                    }
                }

            } else {//Variavel Vez valendo -1, Computador O ir� realizar a jogada
                System.out.println("COMPUTADOR O");//Informa que � a vez do Computador O
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaMaquinaFacil(tabuleiro);
                vencedor = verificaVencedor(tabuleiro);
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao2++;//Variavel pontua��o2 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Compuador O
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    } else {//Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    }
                }
            }

            if (pontuacao1 == 3 || pontuacao2 == 3) {//Verifica se uma das pontua��es chegou a 3 para informar quem foi o vencedor da partida
                if (pontuacao1 == 3) {//Se pontuacao do Jogador X chegou a 3 executa conjunto de comandos
                    System.out.println("~x~x~x~ VENCEDOR: JOGADOR X ~x~x~x~");//Informa que o Jogador X foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que os comandos abaixo sejam executados se a pontuacao1 for igual a 3
                } else {//Se pontuacao do Jogador X n�o chegou a 3 executa conjunto de comandos
                    System.out.println("~o~o~o~ VENCEDOR: COMPUTADOR O ~o~o~o~");//Informa que o Computador O foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que demais comandos sejam executados se a pontuacao1 for diferente de 3
                }
            }
        }
    }

    public static void modoDificil() {//Fun��o ir� executar o modo jogador vs MaquinaDificil
        int[][] tabuleiro = inicializarTabuleiro();//Matriz tabuleiro � criada e recebe a fun��o inicializarTabuleiro
        int jogador1 = 1;//Variavel Jogador1 � criada e iniciada com valor 1, ser�o estas as intera��es realizadas na matriz pelo usuario
        int vez = 1;//Variavel vez � criada e iniciada em 1, confome cada rodada ela � decrementada e incrementada definindo assim de quem � a vez de jogar
        boolean vencedor, velha;//Variaveis logicas Vencedor e Velha s�o criadas, onde posteiormente cada uma ira receber uma fun��o respectivamente adequadas
        int pontuacao1 = 0, pontuacao2 = 0;//Variaveis pontuacao1 e pontuacao2 s�o criadas e iniciadas com valor 0(zero), ser�o os parametros para verificar as pontua�oes parciais
        System.out.println();//Pula uma Linha visualmente
        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar da partida 
        System.out.println();//Pula uma Linha visualmente
        while (pontuacao1 <= 3 || pontuacao2 <= 3) {//Verifica a cada vitoria se o total de vitorias do Jogador ou da Maquina chegou a 3 no ModoDificil
            if (vez == 1) {//Variavel Vez valendo 1, Jogador X ir� realizar a jogada
                System.out.println("JOGADOR X");//Informa que � a vez do Jogador X
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaUsuario(tabuleiro, jogador1);//Matriz tabuleiro chama a fun��o JogadaUsuario executando o conjunto de instru�oes respectivos l� presentes
                vencedor = verificaVencedor(tabuleiro);//Variavel vencedor chama a fun��o verificaVencedor e verifica se a jogada realizada retornou um verdadeiro confirmando a virotia jo Jogador X
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao1++;//Variavel pontua��o1 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Jogador X
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Computador O na proxima rodada
                    } else {//Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = -1;//Variavel vez recebe -1 passando a vez para o Computador O na proxima rodada
                    }
                }

            } else {//Variavel Vez valendo -1, Computador O ir� realizar a jogada
                System.out.println("COMPUTADOR O");//Informa que � a vez do Computador O
                System.out.println();//pula uma linha visualmente
                tabuleiro = jogadaMaquinaDificil(tabuleiro);
                vencedor = verificaVencedor(tabuleiro);
                if (vencedor == true) {//Se vencedor � verdadeiro executa conjunto de instru��es 
                    pontuacao2++;//Variavel pontua��o2 � incrementada,ou seja recebe +1
                    imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida, nesse caso ira mostra acrescimo um ponto para o Compuador O
                    tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                } else {//Se vencedor � falso executa conjunto de instru��es
                    velha = verificaVelha(tabuleiro);//Variavel Velha chama a fun��o verificaVelha e verifica se a jogada realizada retornou um verdadeiro confirmando o empate da partida
                    if (velha == false) {//Se velha � falso executa conjunto de instru��es
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    } else {//Se velha � verdadeiro executa conjunto de instru��es
                        System.out.println("~~~ DEU VELHA ~~~");//Informa que o jogo empatou
                        System.out.println();//pula uma linha visualmente
                        imprimePontuacao(pontuacao1, pontuacao2);//Fun��o que imprime o placar parcial da partida
                        tabuleiro = inicializarTabuleiro();//Matriz tabuleiro chama a fun��o inicializarTabuleiro que ira iniciar um novo jogo;
                        vez = 1;//Variavel vez recebe 1 passando a vez para o Jogador X na proxima rodada
                    }
                }
            }

            if (pontuacao1 == 3 || pontuacao2 == 3) {//Verifica se uma das pontua��es chegou a 3 para informar quem foi o vencedor da partida
                if (pontuacao1 == 3) {//Se pontuacao do Jogador X chegou a 3 executa conjunto de comandos
                    System.out.println("~x~x~x~ VENCEDOR: JOGADOR X ~x~x~x~");//Informa que o Jogador X foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que os comandos abaixo sejam executados se a pontuacao1 for igual a 3
                } else {//Se pontuacao do Jogador X n�o chegou a 3 executa conjunto de comandos
                    System.out.println("~o~o~o~ VENCEDOR: COMPUTADOR O ~o~o~o~");//Informa que o Computador O foi o vencedor da partida
                    System.out.println();//Pula uma Linha visualmente
                    System.out.println();//Pula uma Linha visualmente
                    break;//impede que demais comandos sejam executados se a pontuacao1 for diferente de 3
                }
            }
        }
    }   
}
