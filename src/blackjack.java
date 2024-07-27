import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class blackjack {
    // Constantes para cada carta específica
    public static final int ACE_SPADES = 1;
    public static final int TWO_SPADES = 2;
    public static final int THREE_SPADES = 3;
    public static final int FOUR_SPADES = 4;
    public static final int FIVE_SPADES = 5;
    public static final int SIX_SPADES = 6;
    public static final int SEVEN_SPADES = 7;
    public static final int EIGHT_SPADES = 8;
    public static final int NINE_SPADES = 9;
    public static final int TEN_SPADES = 10;
    public static final int JACK_SPADES = 11;
    public static final int QUEEN_SPADES = 12;
    public static final int KING_SPADES = 13;

    public static final int ACE_HEARTS = 14;
    public static final int TWO_HEARTS = 15;
    public static final int THREE_HEARTS = 16;
    public static final int FOUR_HEARTS = 17;
    public static final int FIVE_HEARTS = 18;
    public static final int SIX_HEARTS = 19;
    public static final int SEVEN_HEARTS = 20;
    public static final int EIGHT_HEARTS = 21;
    public static final int NINE_HEARTS = 22;
    public static final int TEN_HEARTS = 23;
    public static final int JACK_HEARTS = 24;
    public static final int QUEEN_HEARTS = 25;
    public static final int KING_HEARTS = 26;

    public static final int ACE_DIAMONDS = 27;
    public static final int TWO_DIAMONDS = 28;
    public static final int THREE_DIAMONDS = 29;
    public static final int FOUR_DIAMONDS = 30;
    public static final int FIVE_DIAMONDS = 31;
    public static final int SIX_DIAMONDS = 32;
    public static final int SEVEN_DIAMONDS = 33;
    public static final int EIGHT_DIAMONDS = 34;
    public static final int NINE_DIAMONDS = 35;
    public static final int TEN_DIAMONDS = 36;
    public static final int JACK_DIAMONDS = 37;
    public static final int QUEEN_DIAMONDS = 38;
    public static final int KING_DIAMONDS = 39;

    public static final int ACE_CLUBS = 40;
    public static final int TWO_CLUBS = 41;
    public static final int THREE_CLUBS = 42;
    public static final int FOUR_CLUBS = 43;
    public static final int FIVE_CLUBS = 44;
    public static final int SIX_CLUBS = 45;
    public static final int SEVEN_CLUBS = 46;
    public static final int EIGHT_CLUBS = 47;
    public static final int NINE_CLUBS = 48;
    public static final int TEN_CLUBS = 49;
    public static final int JACK_CLUBS = 50;
    public static final int QUEEN_CLUBS = 51;
    public static final int KING_CLUBS = 52;

    public static void main(String[] args) {
        ArrayList<Integer> deck = new ArrayList<>();
        ArrayList<Integer> playerCards = new ArrayList<>();
        ArrayList<Integer> dealerCards = new ArrayList<>();

        // Inicializar el mazo
        initializeDeck(deck);
        // Barajar el mazo
        Collections.shuffle(deck);

        // Repartir cartas iniciales
        playerCards.add(drawCard(deck));
        playerCards.add(drawCard(deck));
        dealerCards.add(drawCard(deck));
        dealerCards.add(drawCard(deck));

        // Juego principal
        boolean playerTurn = true;
        boolean gameEnded = false;

        while (!gameEnded) {
            if (playerTurn) {
                showCards("Tus cartas:", playerCards);
                JOptionPane.showMessageDialog(null, "Puntaje: " + calculateScore(playerCards));
                int result = JOptionPane.showOptionDialog(null, "¿Quieres otra carta?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Pedir", "Plantarse"}, "Pedir");
                if (result == 0) {
                    playerCards.add(drawCard(deck));
                    if (calculateScore(playerCards) > 21) {
                        showCards("Tus cartas", playerCards);
                        JOptionPane.showMessageDialog(null, "Te has pasado de 21. ¡Perdiste!");
                        gameEnded = true;
                    }
                } else {
                    playerTurn = false;
                }
            } else {
                showCards("Cartas del dealer: " , dealerCards);
                while (calculateScore(dealerCards) < 17) {
                    dealerCards.add(drawCard(deck));
                    showCards("Cartas del dealer: " , dealerCards);
                }

                int playerScore = calculateScore(playerCards);
                int dealerScore = calculateScore(dealerCards);

                JOptionPane.showMessageDialog( null, "Puntaje del dealer: " + dealerScore);

                if (dealerScore > 21 || playerScore > dealerScore) {
                    JOptionPane.showMessageDialog(null, "¡Ganaste!");
                } else if (playerScore < dealerScore) {
                    JOptionPane.showMessageDialog(null, "¡Perdiste!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Empate!");
                }

                gameEnded = true;
            }
        }
    }

    // Inicializar el mazo con 52 cartas
    public static void initializeDeck(ArrayList<Integer> deck) {
        // Añadir cartas de tréboles
        deck.add(ACE_CLUBS); deck.add(TWO_CLUBS); deck.add(THREE_CLUBS); deck.add(FOUR_CLUBS);
        deck.add(FIVE_CLUBS); deck.add(SIX_CLUBS); deck.add(SEVEN_CLUBS); deck.add(EIGHT_CLUBS);
        deck.add(NINE_CLUBS); deck.add(TEN_CLUBS); deck.add(JACK_CLUBS); deck.add(QUEEN_CLUBS);
        deck.add(KING_CLUBS);
        // Añadir cartas de corazones
        deck.add(ACE_HEARTS); deck.add(TWO_HEARTS); deck.add(THREE_HEARTS); deck.add(FOUR_HEARTS);
        deck.add(FIVE_HEARTS); deck.add(SIX_HEARTS); deck.add(SEVEN_HEARTS); deck.add(EIGHT_HEARTS);
        deck.add(NINE_HEARTS); deck.add(TEN_HEARTS); deck.add(JACK_HEARTS); deck.add(QUEEN_HEARTS);
        deck.add(KING_HEARTS);
        // Añadir cartas de diamantes
        deck.add(ACE_DIAMONDS); deck.add(TWO_DIAMONDS); deck.add(THREE_DIAMONDS); deck.add(FOUR_DIAMONDS);
        deck.add(FIVE_DIAMONDS); deck.add(SIX_DIAMONDS); deck.add(SEVEN_DIAMONDS); deck.add(EIGHT_DIAMONDS);
        deck.add(NINE_DIAMONDS); deck.add(TEN_DIAMONDS); deck.add(JACK_DIAMONDS); deck.add(QUEEN_DIAMONDS);
        deck.add(KING_DIAMONDS);
        // Añadir cartas de picas
        deck.add(ACE_SPADES); deck.add(TWO_SPADES); deck.add(THREE_SPADES); deck.add(FOUR_SPADES);
        deck.add(FIVE_SPADES); deck.add(SIX_SPADES); deck.add(SEVEN_SPADES); deck.add(EIGHT_SPADES);
        deck.add(NINE_SPADES); deck.add(TEN_SPADES); deck.add(JACK_SPADES); deck.add(QUEEN_SPADES);
        deck.add(KING_SPADES);
    }

    // Sacar una carta del mazo
    public static int drawCard(ArrayList<Integer> deck) {
        return deck.remove(deck.size() - 1);
    }

    // Calcular el puntaje de las cartas
    public static int calculateScore(ArrayList<Integer> cards) {
        int score = 0;
        int aces = 0;

        for (int card : cards) {
            int value = getCardValue(card);
            if (value == 1) {
                aces++;
                score += 11;
            } else {
                score += value;
            }
        }

        // Ajustar el valor de los ases si el puntaje es mayor a 21
        if (score > 21 && aces > 0) {
            do {
                score -= 10;
                aces--;
            } while (score > 21 && aces > 0);
        }

        return score;
    }

    // Obtener el valor de una carta
    public static int getCardValue(int card) {
        switch (card % 13) {
            case 1:
                return 1; // As
            case 11:
            case 12:
            case 0:
                return 10; // Figuras (J, Q, K) (Nota: card % 13 es 0 para el Rey)
            default:
                return card % 13; // Cartas numéricas (2-10)
        }
    }
    // Mostrar cartas en un diálogo

    public static void showCards(String message, ArrayList<Integer> cards) {
        JPanel panel = new JPanel();
        for (int card : cards) {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Objects.requireNonNull(blackjack.class.getResource("cards/" + card + ".png"))));
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(100, 150, Image.SCALE_SMOOTH); // Redimensiona la imagen a 100x150 píxeles
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            panel.add(new javax.swing.JLabel(scaledIcon));
        }
        JOptionPane.showMessageDialog(null, panel, message, JOptionPane.PLAIN_MESSAGE);
    }
}
