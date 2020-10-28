public class Carte {
   public static String [] couleurs = {"Pique", "Coeur", "Carreau", "Trefle"};
   public static int [] valeurs = {1,2,3,4,5,6,7,8,9,10,11,12,13};
   public static String [] nomCartes = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
    
   //*attributs
   private String couleur;
   private int valeur;
   private String  nomCarte;
   private int compare;
    //*constructeur
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
        this.nomCarte = nomCartes[valeur-1];

    }
    //*Accesseurs
    public String getCouleur(){return couleur;}
    public int getValeur(){return valeur;}
    public String getNom(){return nomCarte;}
    public String getCarte(){return nomCarte +" de "+ couleur;}
    public int getWin(){return compare;}

    //*methods
    public void comparer(Carte c2){
        if(this.valeur > c2.valeur){
            this.compare = 1;
        }
        else if (this.valeur < c2.valeur){
            this.compare = -1;
        }
        else{
            this.compare = 0;
        } 
    }
    
    
}
