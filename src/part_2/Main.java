package part_2;

public class Main {

    public static int[] T = new int[12];

    public static void main(String[] args) {


        // Initialization of the array
        for(int i = 0; i < 12 ; i++)
            T[i] = i+1;


        String jade_args[] = new String[2];
        jade_args[0] = "-gui";
        jade_args[1] = "";
        // Pour chaque agent, on passe le début et la fin de ce qu'il doit afficher
        String agent = "Printer_%d:Print_agent(%d,%d)";

        // creating the argument
        for(int i = 0; i < 9; i+=4)
            jade_args[1] += String.format(agent, i/4, i, i+4) + ";";

        // removing last semicolon
        int len = jade_args[1].length();
        jade_args[1] = jade_args[1].substring(0, len-1);


        /*** L'affichage ne sera pas ordonné
         car l'ordre d'exécution est aléatoir **/

        jade.Boot.main(jade_args);

    }

}