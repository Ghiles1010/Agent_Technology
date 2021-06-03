package part_2.raisoneur;

public class Promotion {

    private int nbPersones, pourcentage;

    public Promotion(int nbPersones, String pourcentage) {
        this.nbPersones = nbPersones;

        this.pourcentage = Integer.parseInt(pourcentage.substring(0, pourcentage.length()-1));
    }

    public int getNbPersones() {
        return nbPersones;
    }

    public int getPourcentage() {
        return pourcentage;
    }
}
