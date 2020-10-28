import java.util.ArrayList;
public class Bataille {
public static void bataille(Joueur j1,Joueur j2, int i){
        j1.jouerUneCarte();
        j1.jouerUneCarte();
        j2.jouerUneCarte();
        j2.jouerUneCarte();
        i=+2;
        j1.carteJouee.get(i).comparer(j2.carteJouee.get(i));
        if(j1.carteJouee.get(i).getWin() == (1)){
            j1.gagne(j2);
        }else if (j1.carteJouee.get(i).getWin() == (-1)){
            j2.gagne(j1);
        }else{
           System.out.println("bat²");   
        }
        //j1.vider();
        //j2.vider();
    }
    public static void main(String[]args){
        

        int couleursMax = Carte.couleurs.length;
        int valeursMax = Carte.valeurs.length;
        boolean duel = true;
        ArrayList<Carte> jeu = new ArrayList();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        //!Paquets de Carte
        for(int i = 0; i < couleursMax; i++){
            for(int j =0; j<valeursMax; j++){
                jeu.add(new Carte(Carte.couleurs[i],Carte.valeurs[j]));
            }
        }
        //!creation paquets joueur
        for(int i= jeu.size() / 2; i > 0; i--){
            int z=(int) (Math.round((int)(Math.random() * (jeu.size()/2))));
            j1.jeuJoueur.add(jeu.get(z));
            jeu.remove(z);
            j2.jeuJoueur.add(jeu.get(z));
            jeu.remove(z);
        }

        //!Partie

        while(duel){
            j1.jouerUneCarte();
            j2.jouerUneCarte();
            //*Comparatif cartes jouées
            for(int i = 0; i < j1.carteJouee.size(); i++){
                j1.carteJouee.get(i).comparer(j2.carteJouee.get(i));
                if(j1.carteJouee.get(i).getWin() == (1)){
                    j1.gagne(j2);
                    //System.out.println("Le Joueur 1 gagne le tour avec un "+j1.carteJouee.get(i).getCarte()+ "contre un "+ j2.carteJouee.get(i).getCarte());
                }else if (j1.carteJouee.get(i).getWin() == (-1)){
                    j2.gagne(j1);
                    // System.out.println("Le Joueur 2 gagne le tour avec un "+j2.carteJouee.get(i).getCarte()+ "contre un "+ j1.carteJouee.get(i).getCarte());
                }else{ 
                        bataille(j1,j2,i);
                }
            }


            //* vidage des cartes jouées
            j1.vider();
            j2.vider();
            
            
            System.out.println("J1 SIZE : "+j1.jeuJoueur.size());
            System.out.println("J2 SIZE : "+j2.jeuJoueur.size());
            
            duel = (j1.jeuJoueur.size() > 0) && (j2.jeuJoueur.size() > 0);
        }
        //! ENDGAME (lol les avengers)
        if(j1.jeuJoueur.size() == 0){
            System.out.println("Le joueur 2 a gagné la partie");
        }else if(j2.jeuJoueur.size() == 0){
            System.out.println("Le joueur 1 a gagné la partie");
        }
    }
}
