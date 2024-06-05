package capolavorocasino;

import java.util.*;


/*
il prrogramma simula un casino
 */
public class CapolavoroCasino {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("benvenuto nel casino");

        
     
     
        
        System.out.println("""
                           ----------------------------------------
                            Scelga il gioco a cui vuole giocare 
                                a - blackjack  
                                b - slot 
                                c - dadi    
                                d - roulette
                           ----------------------------------------
                           """);
   
       String scelta = in.nextLine();
        
        
       

        switch (scelta) {
            case "a" -> {
                int playerScore;
                int dealerScore;
                String choice = "s";
                String playAgain;
                
                System.out.println("Nuova mano di blackjack!");
                
                System.out.println("inserire il saldo:  ");
                int saldoFinale = in.nextInt();

                do {
                    

                    int playerCard1 = random.nextInt(10) + 1;
                    int playerCard2 = random.nextInt(10) + 1;
                    int dealerCard1 = random.nextInt(10) + 1;
                    int dealerCard2 = random.nextInt(10) + 1;

                    playerScore = playerCard1 + playerCard2;
                    dealerScore = dealerCard1 + dealerCard2;

                    System.out.println("quanto vuoi puntare:");
                    int puntata = in.nextInt();

                    if (puntata > saldoFinale) {
                        System.out.println("saldo insufficiente per continuare");
                        playAgain = "n";
                        break;
                    }
                    int saldoDP = saldoFinale - puntata;

                    System.out.println("Il tuo punteggio e': " + playerScore);
                    System.out.println("Il punteggio del dealer e': " + dealerCard1);
                    in.nextLine();

                    if (playerScore == 21) {
                        System.out.println("Blackjack! Hai vinto!");
                    } else {
                        System.out.println("Vuoi pescare un'altra carta? (s/n)");
                        choice = in.nextLine();
                    }

                    while (choice.equals("s") && playerScore < 21) {
                        int newCard = random.nextInt(10) + 1;
                        System.out.println("Hai pescato un " + newCard);
                        playerScore += newCard;
                        System.out.println("Il tuo punteggio e': " + playerScore);
                        System.out.println("Vuoi pescare un'altra carta? (s/n)");
                        choice = in.nextLine();
                    }

                    if (playerScore <= 21) {

                        while (dealerScore < 17) {
                            int newCard = random.nextInt(10) + 1;
                            dealerScore += newCard;
                        }

                        System.out.println("Il punteggio finale del dealer e': " + dealerScore);

                        if (dealerScore > 21 || (playerScore > dealerScore && playerScore <= 21)) {
                            System.out.println("Hai vinto!");
                            saldoFinale = saldoDP + (puntata * 2);
                        } else {
                            System.out.println("Il dealer vince.");
                            saldoFinale = saldoDP;
                        }
                    } else {
                        System.out.println("hai sballato, il dealer vince.");
                        saldoFinale = saldoDP;
                    }

                    if (saldoFinale <= 0) {
                        System.out.println("saldo insufficiente per continuare");
                        break;
                    } else {
                        System.out.println("il saldo finale e': " + saldoFinale);
                        System.out.println("vuoi giocare ancora? (s/n)");
                        playAgain = in.nextLine();
                    }

                    if (playAgain.equals("n")) {
                        break;
                    }
                } while (playAgain.equals("s"));
               
            }

            case "b" -> {
                System.out.println("benvnuto alle slot: ");
                System.out.println("""
                                 ---se la slot fa 3 volte 7---
                                 ---oppure 3 volte 9 hai vinto---
                                 in tutti gli altri casi hai perso.
                                   """);
                char risposta = 0;
                                int rulli[] = new int[3];


                System.out.println("inserire il saldo:  ");
                int saldoFinale = in.nextInt();

                do {

                    System.out.println("quanto vuoi puntare:");
                    int puntata = in.nextInt();

                    if (puntata > saldoFinale) {
                        System.out.println("saldo insufficiente per continuare");
                        risposta = 'n';
                        break;
                    }
                        int saldoDP = saldoFinale - puntata;

                    System.out.print("[");
                    for (int i = 0; i < rulli.length; i++) {
                        rulli[i] = (int) (Math.random() * 10) + 1;
                        System.out.print(rulli[i] + " ");
                    }
                    System.out.println("]");

                    int contatore7 = 0;
                    int contatore9 = 0;

                    for (int i = 0; i < rulli.length; i++) {
                        if (rulli[i] == 7) {
                            contatore7++;
                        } else if (rulli[i] == 9) {
                            contatore9++;
                        }
                    }
                    
                    if (contatore7 == 3 || contatore9 == 3) {
                        System.out.println("hai vinto!!!");
                        saldoFinale = saldoDP + (puntata * 2);
                    } else {
                        System.out.println("hai perso...");
                        saldoFinale = saldoDP;
                    }

                    if (saldoFinale <= 0) {
                        System.out.println("saldo insufficiente per continuare");
                        break;
                    } else {
                        System.out.println("il saldo finale e': " + saldoFinale);
                        System.out.println("vuoi giocare ancora? (s/n)");
                        risposta = in.next().toLowerCase().charAt(0);
                    }
                   
                } while (risposta == 's');

            }

            case "c" -> {

                System.out.println("""
                                   benvenuto al gioco dei dadi: 
                                                       REGOLE:
                                   -se i dadi fanno piu di 10 il banco vince
                                   -se i dadi fanno meno di 10 e indovini quanto fanno vinci
                """);
                
                
                System.out.println("inserire il saldo: "); 
                int saldoFinale = in.nextInt();
                
                char risposta = 0;
                 
                do{
                
                System.out.println("inserire la puntata: ");
                int puntata = in.nextInt();
                
                
                if(puntata > saldoFinale){
                    System.out.println("saldo insufficiente inserire una puntata minore o uguale di: " + saldoFinale);
                    puntata = in.nextInt();
                }
                
                int saldoDP = saldoFinale - puntata;

                System.out.println("quanto faranno i dadi secondo te: ");
                int indovina = in.nextInt();
                
               int dado1 = (int) (Math.random() * 7)+1;
               int dado2 = (int) (Math.random() * 7)+1; 
                
                int sommaDadi = dado1+dado2;
                
                    System.out.println("lancio dei dadi effettuato e' uscito: " + sommaDadi);
                
                   
                    
                    if(sommaDadi > 10){
                        System.out.println("il banco vince");
                        saldoFinale = saldoDP;
                       
                    }else if(indovina == sommaDadi){
                        System.out.println("hai vinto!!!");
                        saldoFinale = saldoDP + (puntata * 2);
                    }else{
                        System.out.println("hai perso...");
                        saldoFinale = saldoDP;
                        
                }
                    
                   if (saldoFinale <= 0) {
                        System.out.println("saldo insufficiente per continuare");
                        break;
                    } else {
                        System.out.println("il saldo finale e': " + saldoFinale);
                        System.out.println("vuoi giocare ancora? (s/n)");
                        risposta = in.next().toLowerCase().charAt(0);
                    }

                } while (risposta == 's');
            }

            case "d" -> {
                
                String[] puntate = {"rosso", "nero", "pari", "dispari"};

                int numeroUscito = random.nextInt(37);

                System.out.print("puoi puntare su: [");
                for(int i = 0; i < puntate.length; i++){
                    System.out.print(puntate[i] + " , ");
                } 
                System.out.println("]");
                
                System.out.println("inserisci la puntata: ");

                String puntataGiocatore = in.nextLine();

                System.out.println("Il numero uscito sulla roulette e': " + numeroUscito);

                if (puntataGiocatore.equals("rosso") && (numeroUscito == 1 || numeroUscito == 3 || numeroUscito == 5 || numeroUscito == 7 || numeroUscito == 9 || numeroUscito == 12 || numeroUscito == 14 || numeroUscito == 16 || numeroUscito == 18 || numeroUscito == 19 || numeroUscito == 21 || numeroUscito == 23 || numeroUscito == 25 || numeroUscito == 27 || numeroUscito == 30 || numeroUscito == 32 || numeroUscito == 34 || numeroUscito == 36)) {
                    System.out.println("hai vinto!");
                } else if (puntataGiocatore.equals("nero") && (numeroUscito == 2 || numeroUscito == 4 || numeroUscito == 6 || numeroUscito == 8 || numeroUscito == 10 || numeroUscito == 11 || numeroUscito == 13 || numeroUscito == 15 || numeroUscito == 17 || numeroUscito == 20 || numeroUscito == 22 || numeroUscito == 24 || numeroUscito == 26 || numeroUscito == 28 || numeroUscito == 29 || numeroUscito == 31 || numeroUscito == 33 || numeroUscito == 35)) {
                    System.out.println("hai vinto!");
                } else if (puntataGiocatore.equals("pari") && numeroUscito % 2 == 0) {
                    System.out.println("hai vinto!");
                } else if (puntataGiocatore.equals("dispari") && numeroUscito % 2 != 0) {
                    System.out.println("hai vinto!");
                } else {
                    System.out.println("hai perso...");
                }
            }
        
            
            
             
        }
        
        
        
        
        
      
    }

}
