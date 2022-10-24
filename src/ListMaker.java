import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    static ArrayList<String> usersList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String MenuChoice = "\nPlease select an option for the list: Add [A], Delete [D], Print [P], or Quit [Q] ";
        boolean goAgain = false;
        String userCmd = "";
        do {
            displayusersList();
            userCmd = SafeInput.getRegExString(in, MenuChoice, "[AaDdPpQq]");
            userCmd = userCmd.toUpperCase();
            switch (userCmd) {
                case "A":
                    addListItem();
                    break;
                case "D":
                    deleteListItem();
                    break;
                case "P":
                    System.out.println(usersList);
                    break;
                case "Q":
                   endList();
                    break;
            }
        }
        while (!goAgain);

    }
    private static void displayusersList() {
        String emptyList = "";
        Scanner in = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (usersList.size() != 0) {
            for (int i = 0; i < usersList.size(); i++) {
                System.out.printf("%-3d%-35s%n", i + 1, usersList.get(i));
            }
        }
        else
        {
            emptyList = SafeInput.PrettyHeader(in,"List is Empty.");
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    private static void addListItem(){
        Scanner in = new Scanner(System.in);
        String addItem = "";
        addItem = SafeInput.getNonZeroLenString(in,"What would you like to add to the list? ");
        usersList.add(addItem);

    }
    private static void deleteListItem(){
        Scanner in = new Scanner(System.in);
        int deleteItem = 0;
        deleteItem = SafeInput.getRangedInt(in,"What item number would you like to delete? ", 1, usersList.size());
        deleteItem = deleteItem - 1;
        usersList.remove(deleteItem);
    }
    private static void endList(){
        Scanner in = new Scanner(System.in);
        boolean goAgain = false;
        goAgain = SafeInput.getYNConfirm(in,"Are you sure you want to quit? [Y/N] ");
        if (goAgain){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        else
        {
            System.out.println("Okay. Let's keep going.");
        }
    }
}
