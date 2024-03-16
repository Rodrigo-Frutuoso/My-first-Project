import java.util.Scanner;
/**
 * O objetivo do jogador é, a partir da pista recebida para cada palavra jogada, adivinhar a palavra;
 * O jogo termina quando a palavra é revelada ou após ter sido atingido o número máximo de tentativa;
 * 
 * @author Rodrigo Frutuoso 61865
 * @author Tiago Leite 61863
 *
 * Compilar: javac Ipurdle.java
 * Executar para default(size = 5 && maxAttempts = 6): java Ipurdle
 * Executar para outros size(maior de 4 e menor de 7) && outros maxAttempts, (substituir os dois por um número inteiro): java Ipurdle size maxAttempts
 */
public class Ipurdle {
    public static void main(String[] args) {
        // Os valores para size e maxAttempts caso não sejam introduzidos argumentos 
        int size = 5;
        int maxAttempts = 6;
        /****************** Tarefa adicional **********************************
        * consiste em ter o método main preparado para ler o tamanho
        * das palavras e o número máximo de tentativas a partir de argumentos
        * da linha de comandos e usar o valor 5 e 6 apenas quando estes valores
        * não são fornecidos.
        */ 
        if (args.length >= 2) {
            size = Integer.parseInt(args[0]);
            maxAttempts = Integer.parseInt(args[1]);
        }
        // Definição de variáveis para os dicionários e para a vitória
        DictionaryIP gameWordsDictionary = new DictionaryIP(size);
        DictionaryIP puzzlesDictionary = new DictionaryIP(size);
        Scanner sc = new Scanner(System.in);
        boolean vitoria = false;
        // Cabeçalho do jogo
        System.out.println();
        System.out.println("Bem vindo ao jogo Ipurdle!");
        System.out.println("Neste jogo as palavras têm tamanho " + size + ". O dicionário tem apenas palavras em inglês realcionadas com IP.");
        System.out.println("Tens apenas " + maxAttempts +" tentativas para advinhar a palavra. Boa sorte!");
        
        while (maxAttempts > 0 && !vitoria){
            System.out.print("Palavra a jogar? ");
            String guess = sc.nextLine().toUpperCase();
            int pista = playGuess(puzzlesDictionary, guess);
            // Verifica se a guess tem o tamanho certo
            if (guess.length() != size)
                System.out.println("Palavra inválida. Tamanho errado");
            // Verifica se a guess é válida tendo em conta o dicionário
            else if (!gameWordsDictionary.isValid(guess)) {
                System.out.println("Palavra inválida. Não existe no dicionário.");
            } else {
                System.out.println("Palavra com pista -> " + printClue(guess, pista));
                maxAttempts--;
                if (isMaxClue(pista, guess.length()))
                    vitoria = true;
            }
        }
        if (vitoria == false){
            System.out.println("Ohhh, perdeste.");
        } else {
            System.out.println("Parabéns, encontraste a palavra secreta!");
        }
          sc.close();
    }

    /**
     * dados dois números inteiros clue e size, e
     * assumindo que size é um número maior que zero, verifica se clue representa uma pista para uma
     * palavra com o tamanho size. Note que isto corresponde a verificar as seguintes condições:
     * clue é positivo, clue tem size dígitos, clue é composto apenas pelos dígitos 1, 2 e 3
     * e a retornar true se todas as condições se verificarem e false caso contrário.
     * 
     * @param clue número inteiro que representa a pista para palavras de tamanho size
     * @param size número inteiro que reprenta o tamanho da clue(da pista)
     * @return true se todas as condições se verificarem e false caso contrário
     * @requires {@code clue > 0 && size > 0 }
     */
    public static boolean validClue(int clue, int size) {
        // Verifica se clue é positivo
        if (clue > 0) {
            int tamanho = 0;
            // Verifica se clue é composto apenas pelos dígitos 1, 2 e 3
            for(int digit = clue; digit > 0; digit /= 10){
                if ((digit % 10) != 1 && (digit % 10) != 2 && (digit % 10) != 3) {
                    return false;
                }
                tamanho++;
            }
            // Verifica se clue tem size dígitos
            if (tamanho != size) {
                return false;
            }
        } else {
            return false;
        }
        // Se todas as condições se verificarem retorna true    
        return true;
    }


    /**
     * dado um número inteiro size, e assumindo que
     * size é um número maior que zero, retorna a menor pista para palavras desse tamanho. 
     * 
     * @param size número inteiro que reprenta o tamanho da clue(da pista)
     * @return menor pista para palavras desse tamanho
     * @requires {@code size >0 }
     * @ensures {@code \result > 0}
     */
    public static int minClue(int size) {
        int min_clue = 1;
        // Cria um número de tamanho size composto apenas por 1's
        for (int i = min_clue; i < size; i++) {
            min_clue = (min_clue * 10) + 1;
        }
        return min_clue;
    }
 

    /**
     * dados dois números inteiros clue e size, e
     * assumindo que size é um número maior que zero e clue representa uma pista para palavras de
     * tamanho size, verifica se clue é a maior pista para palavras desse tamanho. 
     * 
     * @param clue número inteiro que representa a pista para palavras de tamanho size 
     * @param size número inteiro que reprenta o tamanho da clue(da pista)
     * @ensures clue representa uma pista para palavras de tamanho size
     * @return true se a clue atual é máxima, senão false  
     * @requires {@code clue > 0 && size > 0 }
     */
    public static boolean isMaxClue(int clue, int size) {
        int max_clue = 3;
        for (int i = 1; i < size; i++) {
            max_clue = max_clue * 10 + 3;
        }
        return (clue == max_clue);
    }

    
    /**
     * dados dois números inteiros clue e size, e
     * assumindo que
     * size é um número maior que zero, clue representa uma pista para palavras de tamanho size
     * e clue não é a maior pista para palavras de tamanho size, esta função
     * calcula o número que representa a pista imediatamente a seguir, ou seja, o menor número inteiro
     * maior que clue que representa uma pista para palavras de tamanho size.
     * 
     * @param clue número inteiro que representa a pista para palavras de tamanho size
     * @param size número inteiro que reprenta o tamanho da clue(da pista)
     * @return o número que representa a pista imediatamente a seguir, ou seja, o menor número inteiro
     * @requires {@code clue > 0 && size > 0 }
     * @ensures {@code \result > clue}
     */
    public static int nextClue(int clue, int size) {
        clue++;
        int position = 1;
        for (int i = 1; i <= size; i++) {
            if (clue / position % 10 == 4) {
                clue = clue - 3 * position;
                position *= 10;
                clue += position;
            }
        }
        return clue;
    }

   
    /**
     * dada uma String guess que se assume
     * não ser null e um número inteiro clue que se assume representar uma pista para guess, imprime
     * guess com as suas letras coloridas de acordo com a clue. Devem ser coloridas a verde as letras
     * que na pista têm 3, a amarelo as letras que na pista têm 2 e a preto as letras que na pista têm 1.
     * @param guess palavra que o jogador escolheu
     * @param clue número inteiro que representa a pista para guess de tamanho size
     * @requires {@code guess!=null && clue>0}
     */
    public static String printClue(String guess, int clue) {
        StringBuilder guess_colored = new StringBuilder();
        // Ciclo para percorrer a clue da esquerda para a direita
        for (int i = guess.length(); i > 0; i--) {
            // Verifica se o algarismo é 1
            if ((clue / (int)Math.pow(10, i - 1)) % 10 == 1) {
                // Pinta o algarismo no index (guess.length() - i) de preto
                guess_colored.append(
                    StringColouring.toColoredString(String.valueOf(guess.charAt(guess.length() - i)), StringColouring.BLACK));
            }
            // Verifica se o algarismo é 2
            if ((clue / (int)Math.pow(10, i - 1)) % 10 == 2) {
                // Pinta o algarismo no index (guess.length() - i) de amarelo
                guess_colored.append(
                    StringColouring.toColoredString(String.valueOf(guess.charAt(guess.length() - i)), StringColouring.YELLOW));
            }
            // Verifica se o algarismo é 3 
            if ((clue / (int)Math.pow(10, i - 1)) % 10 == 3) {
                // Pinta o algarismo no index (guess.length() - i) de verde
                guess_colored.append(
                    StringColouring.toColoredString(String.valueOf(guess.charAt(guess.length() - i)), StringColouring.GREEN));
            }
        }
        return guess_colored.toString();
    }

   
    /**
     * dadas duas Strings guess e word,
     * que se assumem ter o mesmo tamanho, retorna o inteiro que representa a pista a dar à jogada
     * guess se a palavra a adivinhar for word.
     * No caso de uma letra de word, que só ocorre uma vez nesta palavra, estar em várias posições
     * erradas de guess, apenas a letra na posição mais à esquerda é identificada como letra certa na
     * posição errada. 
     * @param guess palavra que o jogador escolheu
     * @param word palavra a advinhar
     * @return o inteiro que representa a pista a dar à jogada guess se a palavra a adivinhar for word
     * @requires {@code guess != null && guess e word têm o mesmo tamanho}
     */
    public static int clueForGuessAndWord(String guess, String word) {
        int clue = 0;
        // Ciclo para percorrer guess
        for(int i = 0; i < guess.length(); i++){
            clue *= 10;
            // Verifica se word contém o caractere situado no index i da guess
            if(word.contains(String.valueOf(guess.charAt(i)))){
                // Verifica se o caractere situado no index i da guess está no mesmo index na word
                if(guess.charAt(i) == word.charAt(i)){
                    clue += 3;
                } else {
                    clue += 2;
                    /* Subsitui o caractere situado no index i da guess por um espaço em branco
                    *
                    * Isto serve para, no caso de uma letra de word, que só ocorre uma vez nesta palavra,
                    * estar em várias posições erradas de guess, apenas a letra na posição mais à esquerda 
                    * é identificada como letra certa na posição errada 
                    */
                    word = word.replaceFirst(String.valueOf(guess.charAt(i)), " ");
                }
            } else {
                clue += 1;
            }
        }
            
        return clue;
    } 
    
    /**
     * dado um objeto do tipo
     * DictionaryIP que se assume não ser null, um número inteiro clue que se assume representar uma
     * pista para palavras desse dicionário e uma String guess que se assume ter o tamanho certo, retorna
     * o número de palavras válidas do dicionário que se fossem a palavra a adivinhar, dariam origem à
     * pista clue para guess. 
     * @param dictionary contém a lista das palavras jogáveis 
     * @param clue número inteiro que representa a pista para guess de tamanho size
     * @param guess palavra que o jogador escolheu
     * @return o número de palavras válidas do dicionário que se fossem a palavra a adivinhar, dariam origem à pista clue para guess
     * @requires {@code dictionary != null && clue > 0 & guess ter o tamanho certo}
     */
    public static int howManyWordsWithClue(DictionaryIP dictionary, int clue, String guess) {
        int counter = 0;
        // Ciclo para percorrer o dicionário
        for(int i = 0; i < dictionary.lenght(); i++){
            String word = dictionary.getWord(i);
            // Verifica se clue é válida para a palavra do dicionário no índice i
            if(clue == clueForGuessAndWord(guess, word))
                counter++;
        }
        return counter;
    }

    
    /**
     * dado um objeto do tipo
     * DictionaryIP, que se assume não ser null e uma String guess que se assume ter o tamanho certo,
     * retorna o inteiro que representa a pista para guess que serve para mais palavras do dicionário
     * dado. No caso de haver pistas empatadas, dentre estas, é escolhida a menor.
     * Note que as pistas podem ser percorridas recorrendo às funções minClue e a nextClue descritas
     * acima. A pista calculada diz-se que é a melhor porque é a que torna mais difícil o jogador acertar na
     * palavra. 
     * @param dictionary contém a lista das palavras jogáveis 
     * @param guess palavra que o jogador escolheu
     * @return o inteiro que representa a pista para guess que serve para mais palavras do dicionário dado
     * @requires {@code dictionary != null & clue > 0 & guess ter o tamanho certo}
     */
    public static int betterClueForGuess(DictionaryIP dictionary, String guess) {
        int betterClueForGuess = 0;
        int howManyWordsWithClue = 0;
        // Ciclo para percorrer as clue's
        for(int clue = minClue(guess.length()); !isMaxClue(clue, guess.length()); clue = nextClue(clue, guess.length())) {
            // Verifica se a clue atual está presente em mais palavras do que a última clue guardada
            if (howManyWordsWithClue(dictionary, clue, guess) > howManyWordsWithClue) {
                howManyWordsWithClue = howManyWordsWithClue(dictionary, clue, guess);
                betterClueForGuess = clue;
                }
        }
        return betterClueForGuess;
    }

    
    /**
     * dado um objeto do tipo Dictionary que
     * se assume não ser null, e uma String guess que se assume ter o tamanho certo:
     * 1. calcula a melhor pista para guess face ao dicionário dado, recorrendo à função anterior,
     * betterClueForGuess
     * 2. remove do dicionário todas as palavras que não resultariam nessa pista
     * 3. retorna a pista
     * 
     * @param dictionary contém a lista das palavras jogáveis 
     * @param guess palavra que o jogador escolheu
     * @return pista
     * @requires {@code dictionary != null && clue > 0 & guess ter o tamanho certo}
     */
    public static int playGuess(DictionaryIP dictionary, String guess) {
        int clue = betterClueForGuess(dictionary, guess);

        for (int i = 0; i < dictionary.lenght(); i++) {
            if (clue != clueForGuessAndWord(guess, dictionary.getWord(i)))
                dictionary.selectForRemove(i);
        }
        dictionary.removeSelected();
        return clue;
    }
}