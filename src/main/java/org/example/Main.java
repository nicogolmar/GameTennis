package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Rematch = 0;
        Boolean continua;
        do {
            System.out.println("TOURNAMENT TENNIS!");
            Scanner sc = new Scanner(System.in);
            String nameTournament = null;
            String nextSet = "Next";
            String player1 = null;
            String player2 = null;
            int amountSet = 0;
            int count = 0;
            int sumaP1 = 0;
            int sumaP2 = 0;
            int countPlayer1 = 0;
            int countPlayer2 = 0;
            int probP1 = 0;
            int probP2 = 0;
            Boolean countGameGral = true;
            continua = true;
            Boolean comprobationSet = true;
            Boolean comprobation = true;

            //Creador de Juego


            System.out.println("Insert tournament name");
            nameTournament = sc.nextLine();


            System.out.println("Insert name Player 1");
            player1 = sc.nextLine();
            System.out.println(player1);

            System.out.println("Insert name Player 2");
            player2 = sc.nextLine();
            System.out.println(player2);


            //SELECTOR DE SETS
            do {


                try {
                    continua = false;
                    System.out.println("Enter amount of set 3 o 5");
                    amountSet = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("You must enter 3 or 5 in number of set");
                    sc.next();
                    continua = true;
                }


                if (amountSet == 3 || amountSet == 5) {
                    comprobationSet = false;
                }
            }

            while (comprobationSet);

            //MODIFICADOR DE PROBABILIDADES

            int[] countGameP1 = new int[amountSet + 1];
            int[] countGameP2 = new int[amountSet + 1];

            do {
                try {
                    continua = false;
                    System.out.println("Enter the odds of player 1 in number without symbols from 1 to 100");
                    probP1 = sc.nextInt();
                    probP2 = 100 - probP1;
                } catch (InputMismatchException e) {

                    System.out.println("You must enter a value between 1 and 100 without symbols");
                    sc.next();
                    continua = true;
                }
            }
            while (continua);


            System.out.println("Player 1's odds of winning is " + probP1 + "%");
            System.out.println("Player 2's odds of winning is " + probP2 + "%");


//CREADOR JUEGO GENERAL
            System.out.println(Game(amountSet, probP1, countPlayer1, countPlayer2, probP2, comprobation, player1, player2,
                    sumaP1, sumaP2, countGameP1, countGameP2, count, countGameGral, nextSet));


            //MUESTRA EL GANADOR
            System.out.println("--------------------------------------------------------------------");
            System.out.println(TornaumentName(nameTournament));
            System.out.println(Set(player1, sumaP1, countGameP1, player2,
                    sumaP2, countGameP2, nextSet));


    do {
        try {
            continua = false;
            System.out.println("SELECT WITH NUMBER THE OPTION YOU WANT");
            System.out.println("1-Rematch");
            System.out.println("2-Exit");
            Rematch = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("YOU MUST SELECT A NUMBER TO CONTINUE");
            System.out.println("1-Rematch");
            System.out.println("2-Exit");
            sc.next();
            continua = true;
        }
    }
    while(continua);
        }
        while (Rematch==1);
    }
//FUNCION GANADOR


        //FUNCION RETURN SET
        public static String Set (String player1,int sumaP1, int[] countGameP1,
        String player2, int sumaP2, int[] countGameP2, String nextSet){


            System.out.print(player1 + " ");
            for (int g = 0; g < countGameP1.length - 1; g++) {
                sumaP1 = countGameP1[g] + sumaP1;
                System.out.print(countGameP1[g]);
                System.out.print(" ");
            }
            System.out.println();
            System.out.print(player2 + " ");
            for (int g = 0; g < countGameP2.length - 1; g++) {
                sumaP2 = countGameP2[g] + sumaP2;
                System.out.print(countGameP2[g]);
                System.out.print(" ");

            }
            System.out.println();
            System.out.println(Winner(sumaP1,sumaP2,player1,player2,nextSet));

            return nextSet;
        }


        //FUNCION EVALUA GANADOR
        public static String TornaumentName (String nameTournament){

            nameTournament = "The name Tournament is : " + nameTournament;

            System.out.println();

            return nameTournament;

        }


        public static String Game ( int amountSet, int probP1, int countPlayer1, int countPlayer2, int probP2,
        boolean comprobation,
        String player1, String player2,int sumaP1, int sumaP2, int[] countGameP1, int[] countGameP2, int count,
        boolean countGameGral, String nextSet){
            String next = "finish";
            //CICLO PARA EL SET
            for (int k = 0; k < amountSet + 1; k++) {
//CICLO PARA EL GAME

                do {

                    for (int i = 0; i <= 6; i++) {

                        //COMPROBACION DE PROBABILIDAD
                        if (probP1 == 100) {
                            do {
                                int prob = (int) (Math.random() * 100 + 0);
                                if ((prob < probP1)) {
                                    countPlayer1 = countPlayer1 + 15;


                                } else if (prob > probP2) {
                                    countPlayer2 = countPlayer2 + 15;


                                }
                                System.out.println("POINT PLAYER 1: " + countPlayer1 + " POINT PLAYER 2: " + countPlayer2);

                                if (countPlayer2 == 40 || countPlayer1 == 40) {

                                    comprobation = false;
                                    i = 6;

                                    System.out.println(Set(player1, sumaP1, countGameP1, player2,
                                            sumaP2, countGameP2, nextSet));


                                }

                            }

                            while (comprobation);
                        }


                        //COMPROBACION DE PROBABILIDAD
                        if (probP2 == 100) {
                            do {
                                int prob = (int) (Math.random() * 100 + 0);
                                if ((prob < probP1)) {
                                    countPlayer1 = countPlayer1 + 15;


                                } else if (prob < probP2) {
                                    countPlayer2 = countPlayer2 + 15;


                                }
                                System.out.println("POINT PLAYER 1: " + countPlayer1 + "POINT PLAYER 2: " + countPlayer2);

                                if (countPlayer2 == 45 || countPlayer1 == 45) {

                                    comprobation = false;
                                    i = 6;
                                    System.out.println(Set(player1, sumaP1, countGameP1, player2,
                                            sumaP2, countGameP2, nextSet));

                                }
                            }

                            while (comprobation);


                        }
                        //COMPROBACION DE PROBABILIDAD
                        else {
                            do {
                                int prob = (int) (Math.random() * 100 + 0);
                                if ((prob >= probP1)) {
                                    countPlayer1 = countPlayer1 + 15;


                                } else if (prob < probP2) {
                                    countPlayer2 = countPlayer2 + 15;


                                }
                                System.out.println("POINT PLAYER 1: " + countPlayer1 + " " + "POINT PLAYER 2: " + countPlayer2);
                                if (countPlayer2 == 45 || countPlayer1 == 45) {

                                    comprobation = false;
                                    i = 6;
                                    System.out.println(Set(player1, sumaP1, countGameP1, player2,
                                            sumaP2, countGameP2, nextSet));

                                }
                            }

                            while (comprobation);
                        }


                    }

                    //EVALUA LOS GAMES
                    if (countPlayer1 > countPlayer2) {
                        System.out.println("WIN THE GAME PLAYER 1");
                        System.out.println("NEXT SERVE PLAYER 2");
                        countGameP1[count]++;
                        countPlayer1 = 0;
                        countPlayer2 = 0;

                    } else {
                        System.out.println("WIN THE GAME PLAYER 2");
                        System.out.println("NEXT SERVE PLAYER 1");
                        countGameP2[count]++;
                        countPlayer1 = 0;
                        countPlayer2 = 0;

                    }

                    if (countGameP1[count] >= 6 || countGameP2[count] >= 6) {
                        count++;


                        if (countGameP1[0] + countGameP1[1] + countGameP1[2] + countGameP1[3] >= 21 && amountSet == 5 ||
                                countGameP2[0] + countGameP2[1] + countGameP2[2] + countGameP2[3] >= 21 && amountSet == 5 ||
                                countGameP1[0] + countGameP1[1] + countGameP1[2] >= 18 && amountSet == 5 ||
                                countGameP2[0] + countGameP2[1] + countGameP2[2] >= 18 && amountSet == 5) {
                            countGameGral = false;
                            k = amountSet;
                        }

                        if (countGameP1[0] + countGameP1[1] >= 12 && amountSet == 3 ||
                                countGameP2[0] + countGameP2[1] >= 12 && amountSet == 3) {
                            countGameGral = false;
                            k = amountSet;
                        }

                    } else if (count == amountSet) {
                        countGameGral = false;

                    }


                }
                while (countGameGral);

            }

            return next;
        }

    public static String Winner ( int sumaP1, int sumaP2, String player1, String player2, String nextSet){
        nextSet = "FINISH THE GAME";
        if (sumaP1 > sumaP2) {

            System.out.println("The Player: " + player1 + " is the win!!");

        } else if (sumaP2>sumaP1){
            System.out.println("The Player: " + player2 + " is the win!!");
        }
        return nextSet;
    }
    }




