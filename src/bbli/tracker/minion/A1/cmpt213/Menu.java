package bbli.tracker.minion.A1.cmpt213;

import java.util.Scanner;

/**
 * A class for displaying a text menu.
 * @author Bei Bei Li
 */
public class Menu {

    //fields
    private String title;
    private String[] options;

    /**
     * Constructor to instantiate the menu object.
     * @param title Title of the menu.
     * @param options Options of the menu.
     */
    public Menu(String title, String[] options){
        this.title = title;
        this.options = options;
    }

    /**
     * Displays the menu and lists the options.
     */
    public void display(){
        System.out.println();
        System.out.println("***************");
        System.out.println("*  " + this.title + "  *");
        System.out.println("***************");

        for (int i = 0; i < this.options.length; i++){
            int optionIndex = i+1;
            System.out.println( optionIndex + ". " + this.options[i]);
        }

    }

    /**
     * Method that asks the user to enter a number to make a menu option selection for this method.
     * @return The index (Integer) of the selected option.
     */
    public int getSelection(){
        int minOption = 1;
        int maxOption = 6;
        return getNumberBetween(minOption, maxOption);
    }

    /**
     * Prompts the user to enter a number between the two parameter values, reads in a value from the keyboard with error handling.
     * @param min Minimum option index the user can select.
     * @param max Maximum option index the user can select.
     * @return The index (Integer) of the selected option.
     */
    //not tied to any specific Menu instance
    //can be called from any code that needs the user to enter a number from within a range
    public static int getNumberBetween(int min, int max){
        Scanner in = new Scanner(System.in);
        int getOption;

        System.out.print("> ");
        getOption = in.nextInt();

        //refactor this???
        if (getOption < min || getOption > max){
            while (getOption < min || getOption > max) {
                System.out.println("Error: Please enter a selection between " + min + " and " + max);
                System.out.print("> ");
                getOption = in.nextInt();
            }
        }
        return getOption;
    }

}


