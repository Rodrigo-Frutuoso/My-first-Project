/**
 * Os objetos deste tipo representam clues para palavras de um certo tamanho (wordSize)
 * 
 * @author Rodrigo Frutuoso 61865
 * @author Tiago Leite 61863
 *
 * Compilar: javac Clue.java
 * Executar: java Clue
 */
public class Clue {

    private int orderNumber;
    private int wordSize;
    private LetterStatus[] elements;

    /**
     * este método serve para comparar se dois LetterStatus são iguais, ou seja, compara os elementos de uma clue
     * @param elements
     * @param elements1
     * @return true se os elementos das duas clues forem iguais 
     */
    public static boolean equalsElements (LetterStatus[] elements, LetterStatus[] elements1) {
        boolean error = elements.length != elements1.length;
        int i =  0;
        while (!error && i < elements.length){
            error = elements[i] != elements1[i];
            i++;
        }
        return !error;
    }
    
    /**
     * constrói uma clue com os elementos dados
     * @param elements
     * @requires elements != nul
     */
    public Clue(LetterStatus[] elements) {
        this.elements = elements;
        wordSize = elements.length;
        orderNumber = 1;
        
        // elements1 corresponde à minClue
        LetterStatus[] elements1 = new LetterStatus[wordSize];
        for (int i = 0; i < wordSize; i++) {
            elements1[i] = LetterStatus.INEXISTENT;
        }

        boolean carry; 
        
        /*
         * este ciclo serve para descobrir o orderNumber da clue que vai ser criada com elements.
         * começa com a minClue e e vai avançando nas clues até que o elements1 seja igual ao elements,
         * cada vez que a clue aumenta temos de ter cuidado para verificar se há carry, se houver
         * verificamos se elements1[j]== LetterStatus.CORRECT_POS e caso isso seja verdade significa que
         * vai haver carry outra vez. O ciclo continua enquanto houver carry.
         */
        while (!equalsElements(elements, elements1)) {
            carry = true;
            for (int j = elements1.length - 1; j >= 0 && carry; j--) {
                if (carry) {
                    if (elements1[j]== LetterStatus.CORRECT_POS) {
                        elements1[j] = LetterStatus.INEXISTENT;
                        carry = true;
                    } else {
                        // se o elements1[j] estivesse a INEXISTENT passa a WRONG_POS e se estivesse a WRONG_POS passa a CORRECT_POS
                        elements1[j] = LetterStatus.values()[elements1[j].ordinal() + 1];
                        carry = false;
                    }
                }
            }
            ++orderNumber;
        }
    }

    /**
     * constrói uma clue dado um orderNumber e um wordSize
     * @param orderNumber
     * @param wordSize
     * @requires wordSize > 0 e 1 ≤ orderNumber ≤ 3 ^(wordSize)
     */
    public Clue(int orderNumber, int wordSize) {
        this.orderNumber = orderNumber;
        this.wordSize = wordSize;
        
        // inicialização dos elementos todos a INEXISTENT
        this.elements = new LetterStatus[wordSize];
        for (int i = 0; i < wordSize; i++) {
            elements[i] = LetterStatus.INEXISTENT;
        }

        boolean carry;

        /*
         * este pedaço de código é quase idêntico ao do construtor acima,
         * mas agora sabemos o orderNumber e queremos dar valores aos elements da clue.
         * Começamos outra vez com a minClue e vamos avançando até ao orderNumber desejado.
         * 
         * o orderNumber só começa em 1 mas precisamos de acessar ao índice 0 do elements, 
         * por isso o i = 0 e i <= orderNumber - 1 no for.
         */
        for (int i = 0; i < orderNumber - 1; i++) {
            carry = true;
            for (int j = elements.length - 1; j >= 0 && carry; j--) {
                if (carry) {
                    if (elements[j]== LetterStatus.CORRECT_POS) {
                        elements[j] = LetterStatus.INEXISTENT;
                        carry = true;
                    } else {
                        elements[j] = LetterStatus.values()[elements[j].ordinal() + 1];
                        carry = false;
                    }
                }
            }
        }

    }

    /**
     * @return o tamamho de uma clue
     */
    public int length() {
        return elements.length;
    }

    /**
     * @return o orderNumber de uma clue
     */
    public int orderNumber() {
        return this.orderNumber;
    }

    /**
     * @return um vetor com os elementos da clue
     */
    public LetterStatus[] letterStatus() {
        return this.elements;
    }

    /**
     * @return true se a clue tiver todos os elementos a CORRECT_POS
     */
    public boolean isMax() {
        for (int i = 0; i < this.length(); i++) {
            if (letterStatus()[i] != LetterStatus.CORRECT_POS) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return uma representação textual de uma lista onde são usados os símbolos *, o e _ para representar a clue.
     * 
     *  * -> letra na posição correta
     *  o -> letra na posição errada 
     *  _ -> letra inexistente
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
           if (elements[i] == LetterStatus.CORRECT_POS) {
               sb.append("*");
           } else if (elements[i] == LetterStatus.WRONG_POS) {
               sb.append("o");
           } else {
               sb.append("_");
           }
        }
        return sb.toString();
    }
}