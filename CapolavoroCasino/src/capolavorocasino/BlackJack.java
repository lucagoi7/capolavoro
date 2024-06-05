/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capolavorocasino;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author luca.goi
 */
public class BlackJack {

    int playerScore;
    int dealerScore;
    
    Random random = new Random();

    public void play() {
        Scanner in = new Scanner(System.in);
        String choice = null;
        String playAgain;

        do {
            System.out.println("Nuova mano di blackjack!");

            int playerCard1 = random.nextInt(10) + 1;
            int playerCard2 = random.nextInt(10) + 1;
            int dealerCard1 = random.nextInt(10) + 1;
            int dealerCard2 = random.nextInt(10) + 1;

            playerScore = playerCard1 + playerCard2;
            dealerScore = dealerCard1 + dealerCard2;

            System.out.println("Il tuo punteggio e': " + playerScore);
            System.out.println("Il punteggio del dealer e': " + dealerCard1);

            if (playerScore == 21) {
                System.out.println("Blackjack! Hai vinto!");
            } else {
                System.out.println("Vuoi pescare un'altra carta? (s/n)");
                choice = in.nextLine();
            }

            while (choice.equals("s")) {
                int newCard = random.nextInt(10) + 1;
                System.out.println("Hai pescato un " + newCard);
                playerScore += newCard;

                if (playerScore > 21) {
                    System.out.println("Hai sballato!");
                    break;
                }

                System.out.println("Il tuo punteggio e': " + playerScore);
                System.out.println("Vuoi pescare un'altra carta? (s/n)");
                choice = in.nextLine();
            }

            while (dealerScore < 17) {
                int newCard = random.nextInt(10) + 1;
                dealerScore += newCard;
            }

            System.out.println("Il punteggio finale del dealer e': " + dealerScore);

            //Quando il player vince
            // il suo punteggi oè maggiore di quello del dealer e minore di 21
            // playerScore > dealerScore && playerScore <=21
            if (dealerScore > 21 || (playerScore > dealerScore && playerScore <= 21)) {
                System.out.println("Hai vinto!");
            } else {
                System.out.println("Il dealer vince.");
            }

            System.out.println("Vuoi giocare di nuovo? (s/n)");
            playAgain = in.nextLine();

            if (playAgain.equals("n")) {
                break;
            }
        } while (playAgain.equals("s"));
        in.close();
    }

}
