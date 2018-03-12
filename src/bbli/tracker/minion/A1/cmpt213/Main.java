package bbli.tracker.minion.A1.cmpt213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that is the main application for Minion Tracker; it provides a list of options user can select and use.
 * @author Bei Bei Li
 */
public class Main {

    //Create an List interface of minions to hold the set of minions the user enters.
    //List is interface and an Arraylist Implements it
    private static List<Minion> minionsHolder = new ArrayList<>(); //project language level must be 7 or above

    private static String[] options = {
            "List minions",
            "Add a new minion",
            "Remove a minion",
            "Attribute evil deed to a minion",
            "DEBUG: Dump objects (toString)",
            "Exit"
    };

    private static Menu optionsMenu = new Menu("Main Menu", options);

    /**
     * Main application to run the minion tracker.
     * @param args Supplied comment-line arguments, not used in main.
     */
    public static void main(String[] args) {
        boolean isExiting = false; //checking for option 6
        Scanner in = new Scanner(System.in);
        int getOption;
        int minionIndex;

        //Application Start
        authorDisplay();

        int test = 0;
        do {
            optionsMenu.display();
            getOption = optionsMenu.getSelection();

            //Option Cases
            switch(getOption){
                case 1: //list minions
                    listMinions(minionsHolder);
                    break; //must break or continue execution of code
                case 2: //add minions
                    Minion newMinion = addMinion();
                    minionsHolder.add(newMinion);
                    break;
                case 3: //remove minions
                    minionIndex = selectMinion(minionsHolder, optionsMenu);
                    removeMinion(minionsHolder, minionIndex);
                    break;
                case 4: //add evil deed
                    minionIndex = selectMinion(minionsHolder, optionsMenu);
                    attributeEvilDeed(minionsHolder, minionIndex);
                    break;
                case 5: //toString()
                    dumpObjects(minionsHolder);
                    break;
                case 6: //exit
                    System.out.println("Now Exiting...Thanks for Using the Tracker :)");
                    isExiting = true;
                default: //code style: All switch statements should include a "default" label. assert false if impossible.
                    assert false;
            }

        } while (!isExiting);

    }


    private static void authorDisplay(){
        String authorName = "Bei Bei Li";
        System.out.println("***************************************");
        System.out.println("Welcome to the Evil Minion Tracker (tm)");
        System.out.println("by " + authorName + ".");
        System.out.println("***************************************");
    }

    /**
     * Display a list of minions in the given list.
     * @param minionsHolder The list containing the minions.
     */
    private static void listMinions(List<Minion> minionsHolder){
        int minionIndex = 1; //index for the for-each loop

        System.out.println("\nList of Minions:");
        System.out.println("****************");

        if (minionsHolder.size() == 0){
            System.out.println("No minions found.");
        }
        else {
            for (Minion eachMinion : minionsHolder) {
                System.out.println(minionIndex + ". " +
                        eachMinion.getName() + ", " +
                        eachMinion.getHeightInM() + "m, " +
                        eachMinion.getEvilDeedCount() + " evil deed(s)"
                );
                minionIndex++;
            }
        }

    }

    private static Minion addMinion(){
        Scanner in = new Scanner(System.in);
        int defaultDeed = 0;

        System.out.print("Enter minion's name:  ");
        String minionName = in.nextLine();
        System.out.print("Enter minion's height: ");
        double minionHeight = in.nextDouble();
        Minion newMinion = new Minion(minionName,defaultDeed,minionHeight);
        return newMinion;
    }

    /**
     * Method to find the index of the selected minion.
     * @param minionsHolder The list containing the minions.
     * @param optionsMenu The menu containing the options.
     * @return The index (Integer) of the user selected minion in the minion list.
     */
    private static int selectMinion(List<Minion> minionsHolder, Menu optionsMenu){
        int minIndex = 0;
        int maxIndex = minionsHolder.size();

        listMinions(minionsHolder);

        System.out.println("(Enter 0 to cancel)");
        int minionIndex = optionsMenu.getNumberBetween(minIndex, maxIndex);
        return minionIndex;
    }

    private static void removeMinion(List<Minion> minionsHolder, int minionIndex){
        int actualMinionIndex;

        if (minionIndex != 0){
            actualMinionIndex = minionIndex - 1;
            minionsHolder.remove(actualMinionIndex);
        }
    }

    private static void attributeEvilDeed(List<Minion> minionsHolder, int minionIndex){
        int actualMinionIndex;
        Minion minion;

        if (minionIndex != 0){
            actualMinionIndex = minionIndex - 1;
            minion = minionsHolder.get(actualMinionIndex);
            minion.incrementEvilDeeds();
            System.out.println(minion.getName() + " has now done " + minion.getEvilDeedCount() + " evil deed(s)!");
        }

    }

    private static void dumpObjects(List<Minion> minionsHolder){
        int minionIndex = 1; //index for the for-each loop

        System.out.println("All minion objects:");

        if (minionsHolder.size() == 0){
            System.out.println("No minion objects found.");
        }
        for (Minion eachMinion : minionsHolder){
            System.out.println(minionIndex + ". "+ eachMinion.toString());
            minionIndex++;
        }

    }

}

//---------------------------------------PERSONAL COMMENTS--------------------------------------------------------------

//Notes from Lief (TA) Office Hour

//handle InputMismatchException? We can use error checking - try{}catch{}

//scanner int then string problem. We can call nextLine() immediately after nextInt().

//arraylist declaration - code implementation and list interface

//.idea submission - hidden in the folder containing src

//screenshot of debugger - for cmpt 276 not us

//static in main? We can use static whenever the declared item is shared or there is only one of it.
//no instantiation in the future. --- should not matter for main but static is okay :)

//REPL console

//class and method javadoc required; public should all have javadoc; big private methods should have javadoc as well