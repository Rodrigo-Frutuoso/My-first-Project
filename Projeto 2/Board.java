/**
 * Os objetos deste tipo representam o estado do tabuleiro de um jogo de Ipurdle.
 * 
 * @author Rodrigo Frutuoso 61865
 * @author Tiago Leite 61863
 *
 * Compilar: javac Board.java
 * Executar: java Board
 */
public class Board {

    private int wordSize;
    private int maxGuesses;
    private int guesses;
    private String[] guessesArray;
    private Clue[] cluesArray;
    
    /**
     * cria um tabuleiro para o jogo de Ipurdle com os dados fornecidos no estado inicial (vazio)
     * @param wordSize
     * @param maxGuesses
     * @requires wordSize >= 1 e maxGuesses >= 1
     */
    public Board(int wordSize, int maxGuesses) {
        this.wordSize = wordSize;
        this.maxGuesses = maxGuesses;
        this.guessesArray = new String[maxGuesses];
        this.cluesArray = new Clue[maxGuesses];
    }
    /**
     * @return tamanho das palavras que podem ser guardadas no tabuleiro
     */
    public int wordLength() {
        return wordSize;
    }
    /**
     * @return número máximo de tentativas
     */
    public int maxGuesses() {
        return maxGuesses;
    }
    /**
     * @return número de tentativas que já foram feitas
     * @requires 0 <= guesses() && guesses() <= maxGuesses()
     */
    public int guesses() {
        return guesses;
    }
    /**
     * regista palavra e pista fornecidas
     * @param guess
     * @param clue
     * @requires guess.length() == clue.length() == wordLength() && guesses() < maxGuesses()
     */
    public void insertGuessAndClue(String guess, Clue clue) {
        this.guessesArray[guesses] = guess;
        this.cluesArray[guesses] = clue;
        ++guesses;
    }
    /**
     * @return representação textual do estado do tabuleiro como se ilustra abaixo: 
     *  +---------------+
     *  | WHILE | ____* |
     *  +---------------+
     *  | FIELD | __o__ |
     *  +---------------+
     *  | ABOVE | ***** |
     *  +---------------+
     */
    @Override
    public String toString() {
        // Isto corresponde à quantidade the caracteres em:  "| " + " | " + " |" 
        final int CHARACTERS_IN_THE_LINE = 7;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < guesses; i++) {
            sb.append("+");
            /*
             * Ciclo para preencher as linhas no meio das guesses com "-",
             * a quantidade de "-" é o tamanhao da clue + o tamanho da guess,
             * ou seja, wordSize * 2, + CHARACTERS_IN_THE_LINE - 2, este 2
             * representa os dois "+" no ínicio e no final da linha
             */
            for (int k = 0; k < wordSize + wordSize + CHARACTERS_IN_THE_LINE - 2; k++) {
                sb.append("-");
            }
            sb.append("+" + "\n");
            sb.append("| " + guessesArray[i] + " | " + cluesArray[i] + " |\n");
            if (i == guesses - 1) {
                sb.append("+");
                for (int k = 0; k < wordSize + wordSize + CHARACTERS_IN_THE_LINE - 2; k++) {
                    sb.append("-");
                }
                sb.append("+" + "\n");
            }
        }
        return sb.toString();
    }
}/**
 * Os objetos deste tipo representam o estado do tabuleiro de um jogo de Ipurdle.
 * 
 * @author Rodrigo Frutuoso 61865
 * @author Tiago Leite 61863
 *
 * Compilar: javac Board.java
 * Executar: java Board
 */
public class Board {

    private int wordSize;
    private int maxGuesses;
    private int guesses;
    private String[] guessesArray;
    private Clue[] cluesArray;
    
    /**
     * cria um tabuleiro para o jogo de Ipurdle com os dados fornecidos no estado inicial (vazio)
     * @param wordSize
     * @param maxGuesses
     * @requires wordSize >= 1 e maxGuesses >= 1
     */
    public Board(int wordSize, int maxGuesses) {
        this.wordSize = wordSize;
        this.maxGuesses = maxGuesses;
        this.guessesArray = new String[maxGuesses];
        this.cluesArray = new Clue[maxGuesses];
    }
    /**
     * @return tamanho das palavras que podem ser guardadas no tabuleiro
     */
    public int wordLength() {
        return wordSize;
    }
    /**
     * @return número máximo de tentativas
     */
    public int maxGuesses() {
        return maxGuesses;
    }
    /**
     * @return número de tentativas que já foram feitas
     * @requires 0 <= guesses() && guesses() <= maxGuesses()
     */
    public int guesses() {
        return guesses;
    }
    /**
     * regista palavra e pista fornecidas
     * @param guess
     * @param clue
     * @requires guess.length() == clue.length() == wordLength() && guesses() < maxGuesses()
     */
    public void insertGuessAndClue(String guess, Clue clue) {
        this.guessesArray[guesses] = guess;
        this.cluesArray[guesses] = clue;
        ++guesses;
    }
    /**
     * @return representação textual do estado do tabuleiro como se ilustra abaixo: 
     *  +---------------+
     *  | WHILE | ____* |
     *  +---------------+
     *  | FIELD | __o__ |
     *  +---------------+
     *  | ABOVE | ***** |
     *  +---------------+
     */
    @Override
    public String toString() {
        // Isto corresponde à quantidade the caracteres em:  "| " + " | " + " |" 
        final int CHARACTERS_IN_THE_LINE = 7;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < guesses; i++) {
            sb.append("+");
            /*
             * Ciclo para preencher as linhas no meio das guesses com "-",
             * a quantidade de "-" é o tamanhao da clue + o tamanho da guess,
             * ou seja, wordSize * 2, + CHARACTERS_IN_THE_LINE - 2, este 2
             * representa os dois "+" no ínicio e no final da linha
             */
            for (int k = 0; k < wordSize + wordSize + CHARACTERS_IN_THE_LINE - 2; k++) {
                sb.append("-");
            }
            sb.append("+" + "\n");
            sb.append("| " + guessesArray[i] + " | " + cluesArray[i] + " |\n");
            if (i == guesses - 1) {
                sb.append("+");
                for (int k = 0; k < wordSize + wordSize + CHARACTERS_IN_THE_LINE - 2; k++) {
                    sb.append("-");
                }
                sb.append("+" + "\n");
            }
        }
        return sb.toString();
    }
}