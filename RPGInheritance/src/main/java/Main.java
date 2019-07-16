import java.util.*;

public class Main {

    public static void main(String[] args) {
        Farmer farmer = new Farmer("farmer", 75, 100, 75, 10,
                1, 0);
        Constable constable = new Constable("constable", 60, 100, 60,
                20, 5, 0);
        Warrior warrior = new Warrior("warrior", 75, 100, 100,
                50, 10, 100);


        Scanner scan = new Scanner(System.in);
        Random selector = new Random();
        ArrayList<PlayerInfo> player1 = new ArrayList<PlayerInfo>();
        player1.add(farmer);
        player1.add(constable);
        player1.add(warrior);

        String[] challengers = {"wizard", "dragon", "ogor", "pirate"};
        int challengerHealth = 100;
        int challengerHPdamage = 50;
        int challengerSpecial = 1;
        int challengerStamina = 25;
        int challengerShield = 50;


        int apples = 3;
        int appleHealing = 25;
        boolean gameStart = true;


        String challenger = challengers[selector.nextInt(challengers.length)];
        int challengerHP = selector.nextInt(challengerHealth);
        Beginning:
        while(gameStart){
            System.out.println("\t << Welcome to KINGDOM TURF WARS! >>");
            System.out.println("\nChoose who you will be entering this war with! Will it be the:");
            System.out.println("1)Farmer   2)Constable  or  3)Warrior");
            int selection = scan.nextInt();
            String hero;
            PlayerInfo selectedHero = player1.get(0);
            switch (selection) {
                case 1:
                    hero = "farmer";
                    break;
                case 2:
                    hero = "constable";
                    break;
                case 3:
                    hero = "warrior";
                    break;
                default:
                    hero = null;
            }
            for (int i = 0; i < player1.size(); i++) {
                if (player1.get(i).getName() == hero) {
                    selectedHero = player1.get(i);
                }
            }

            System.out.println("OK! I SEE YOU! You are the " + selectedHero.getName() + "!!!\n");
            System.out.println("*********************************************************");
            System.out.println("|            GET READY TO FIGGGGGHHHTT!!!               |");
            System.out.println("*********************************************************");

            RPG:
            while (gameStart) {
                System.out.println("OooOOh mann!! Here comes the " + challenger + "!");
                System.out.println("*******************************************************");
                System.out.println("\n\tThe " + challenger + "'s Health HP is:" + challengerHP + "\tYour Health HP is:" + selectedHero.getHealth());
                while (challengerHealth > 0) {
                    System.out.println("\nWhat is your plan? Should the " + selectedHero.getName() + ":");
                    System.out.println("1:Attack  2:Heal  3:Special move 4: RUNNN!!! ");
                    int choice = scan.nextInt();
                    if (choice < 1 && choice > 4) {
                        System.out.println("Let's try this again! What is your plan?");
                        choice = scan.nextInt();
                    }
                    //Impacts to enemy
                    int damageChallenger = selector.nextInt(selectedHero.getAttackPower());
                    challengerHealth -= damageChallenger;
                    challengerStamina -= 10;

                    //Impacts to hero
                    int damageHero = selector.nextInt(challengerHPdamage);
                    int heroHealth = selectedHero.getHealth();
                    int staminaHP = selectedHero.getStamina();
                    int strengthHP = selectedHero.getStrength();
                    int speedHP = selectedHero.getSpeed();
                    int shieldHP = selectedHero.getShieldStrength();

                    heroHealth -= damageHero;
                    staminaHP -= challengerSpecial;
                    strengthHP -= challengerSpecial;
                    shieldHP -= challengerSpecial;
                    speedHP -= challengerSpecial;
                    if (shieldHP < 0) {
                        shieldHP = 0;
                    }
                    if (heroHealth < 1) {
                        System.out.println("You tried your best, but the " + challenger + " was a little better!");
                        System.out.println("<-------------------------GAME OVER!----------------------------->");
                        continue RPG;
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("Attack it is!");
                            System.out.println("\nPOWWW! You hit " + challenger + " with " + damageChallenger + " points!");
                            System.out.println("OUCHHH!! The " + challenger + " hit us with " + damageHero + " points!");
                            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("The " + challenger + "'s HP:" + challengerHealth + "\t\tthe " + challenger + "'s stamina:" + challengerStamina);
                            System.out.println("Your HP:" + heroHealth + "   Your stamina:" + staminaHP + "   Your strength:" + strengthHP);
                            System.out.println("Your speed:" + speedHP + "   Your shield strength:" + shieldHP);
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            break;
                        case 2:
                            if (apples > 0) {
                                System.out.println("This should make " + selectedHero.getName() + " feel better!");
                                heroHealth += appleHealing;
                                apples--;
                                System.out.println("The " + selectedHero.getName() + " ate the apple and now has " + heroHealth + " HP!");
                                System.out.println("You now have " + apples + " apples left!");
                            } else if (apples <= 0) {
                                System.out.println("You are out of apples, you can no longer heal yourself! You should RUN!");
                            }
                            break;
                        case 3:
                            System.out.println("THE SPECIAL MOOOOVEEE!!!");
                            if (selectedHero.getName().equals("farmer")) {
                                farmerSpecialty(apples);

                            } else if (selectedHero.getName().equals("constable")) {
                                System.out.println("The constable used his jurisdiction and arrested the " + challenger + ".");
                                System.out.println("The arrest decreased " + challenger + "'s HP by 10 and increased the constable's");
                                System.out.println("own by 15!");
                                challengerHealth -= 10;
                                heroHealth += 15;
                                System.out.println(challenger + " HP:" + challengerHealth + "\tYour HP:" + heroHealth);
                            } else if (selectedHero.getName().equals("warrior")) {
                                decreaseShield(challenger, challengerShield);
                            }
                            break;
                        case 4:
                            System.out.println("RUNNNN FORREST RUNNN!!!");
                            System.out.println("You have successfully avoided a fight and lived to see");
                            System.out.println("another day [or until another challenger returns!]");
                            break;

                    }

                    System.out.println("\n****************************************************************************");
                    System.out.println("What would you like to do now?");
                    System.out.println("1)Fight again \t2)Exit the war");
                    int choice1 = scan.nextInt();

                    while (choice1 < 1 && choice1 > 2) {
                        System.out.println("Let's try this again. Please choose either 1 or 2!");
                        choice1 = scan.nextInt();

                    }
                    if (choice1 == 1) {
                        System.out.println("We will fight again!!");
                        System.out.println(" ");
                        continue Beginning;
                    } else if (choice1 == 2) {
                        System.out.println("You've fought a good war! See you next time!");
                        return;
                    }
                }


            }
        }
    }

    private static void farmerSpecialty(int apples){
        System.out.println("The farmer has just plowed and harvested his field, " +
                "adding 2 more apples to your inventory!");
        apples++;
        apples++;
        System.out.println("You now have " + apples + " apples! Enjoy!");
    }
    private static void decreaseShield(String challenger , int challengerShield) { System.out.println("The warrior struck the " + challenger +
            "'s shield with his sword, decreasing");
        System.out.println("the " + challenger + "'s shield strength by 10!");
        System.out.println(challenger + "'s shield strength was: " + challengerShield);
        challengerShield -= 10;
        System.out.println(challenger + "'s shield strength is now: " + challengerShield);
    }


}