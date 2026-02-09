package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water = 400, milk = 540, beans = 120, cups = 9, money = 550;
    int coffee = 0;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.start();
    }

    public CoffeeMachine() {
    }

    private void printState() {
        System.out.printf("""
                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, water, milk, beans, cups, money);
    }

    public boolean resources(int wtr, int mlk, int bns, int cups) {
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;

        } else {

            if (water < wtr) {
                System.out.println("Sorry, not enough water!");
                return false;
            }
            if (milk < mlk) {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
            if (beans < bns) {
                System.out.println("Sorry, not enough beans!");
                return false;
            }

            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }

    }


    public void start() {
        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
        while (true) {

            String choice;
            if (sc.hasNextLine()) {
                choice = sc.nextLine();
                // System.out.println();
                if (!choice.equals("exit") && !choice.equals("clean") && !choice.equals("remaining") && !choice.equals("take") && !choice.equals("fill") && !choice.equals("buy")) {
                    System.out.println();
                }


            } else {
                break; // no more input, exit gracefully
            }
            if (choice.equals("exit")) {
                break;
            } else if (choice.equals("clean")) {
                coffee = 0;
                System.out.println("I have been cleaned!");
                System.out.println();
            } else if (choice.equals("remaining")) {
                printState();
                System.out.println();


            } else if (choice.equals("buy")) {
                if (coffee == 10) {
                    System.out.println("I need cleaning!");
                    System.out.println();


                } else {
                    System.out.println();


                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,back - to main menu:");
                    String input = sc.nextLine();


                    if (input.equals("back")) {
                        System.out.println();


                        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

                        continue; // go back to main menu
                    }
                    int coffeeType;
                    try {
                        coffeeType = Integer.parseInt(input);
                    } catch (NumberFormatException e) {

                        System.out.println();

                        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

                        continue; // invalid input, go back to main menu
                    }


                    switch (coffeeType) {
                        case 1:
                            machine.espresso espr = new machine.espresso();
                            if (resources(espr.getWtr(), espr.getMlk(), espr.getBns(), cups)) {

                                water -= espr.getWtr();
                                beans -= espr.getBns();
                                milk -= espr.getMlk();
                                money += espr.getCost();
                                cups--;
                                coffee++;

                            }
                            break;


                        case 2:
                            machine.latte latte1 = new machine.latte();
                            if (resources(latte1.getWtr(), latte1.getMlk(), latte1.getBns(), cups)) {
                                water -= latte1.getWtr();
                                beans -= latte1.getBns();
                                milk -= latte1.getMlk();
                                money += latte1.getCost();
                                cups--;
                                coffee++;


                            }
                            break;


                        case 3:
                            machine.cappuccino capp = new machine.cappuccino();
                            if (resources(capp.getWtr(), capp.getMlk(), capp.getBns(), cups)) {

                                water -= capp.getWtr();
                                beans -= capp.getBns();
                                milk -= capp.getMlk();
                                money += capp.getCost();
                                cups--;
                                coffee++;


                            }
                            break;


                    }
                    System.out.println();
                }


            } else if (choice.equals("fill")) {
                System.out.println();
                int wtr, mlk, bns, cps;
                System.out.println("Write how many ml of water you want to add:");
                //int wtr = Integer.parseInt(sc.nextLine());
                try {
                    wtr = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
                    continue; // invalid input, go back to main menu

                    // invalid input, go back to main menu


                }

                water += wtr;

                System.out.println("Write how many ml of milk you want to add:");
                //int mlk = Integer.parseInt(sc.nextLine());
                try {
                    mlk = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println();

                    System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

                    continue; // invalid input, go back to main menu
                }

                milk += mlk;
                System.out.println("Write how many grams of coffee beans you want to add:");
                //int bns = Integer.parseInt(sc.nextLine());
                try {
                    bns = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println();

                    System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

                    continue; // invalid input, go back to main menu
                }

                beans += bns;
                System.out.println("Write how many disposable cups you want to add:");
                //int cps = Integer.parseInt(sc.nextLine());
                try {
                    cps = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println();

                    System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

                    continue; // invalid input, go back to main menu
                }

                cups += cps;
                System.out.println();


            } else if (choice.equals("take")) {
                System.out.println();
                System.out.printf("I gave you $%d\n", money);
                money = 0;
                System.out.println();


            }


            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

        }
    }
}
