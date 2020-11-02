import java.util.ArrayList;
public class Bataille {

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
                    System.out.println("Le Joueur 1 gagne le tour avec un "+j1.carteJouee.get(i).getCarte()+ "contre un "+ j2.carteJouee.get(i).getCarte());
                }else if (j1.carteJouee.get(i).getWin() == (-1)){
                    j2.gagne(j1);
                    System.out.println("Le Joueur 2 gagne le tour avec un "+j2.carteJouee.get(i).getCarte()+ "contre un "+ j1.carteJouee.get(i).getCarte());
                }else{ 
                    if((j1.assezCarte())&&(j2.assezCarte())){
                        batailled(j1,j2);
                    }else{
                        if(j1.jeuJoueur.size() < j2.jeuJoueur.size()){
                            j1.gagne(j2);
                        }else{
                            j2.gagne(j1);
                        }

                    }
                }
            }


            //* vidage des cartes jouées
            j1.vider();
            j2.vider();
            
            
            System.out.println("Score de J1 : "+j1.jeuJoueur.size());
            System.out.println("Score de J2 : "+j2.jeuJoueur.size());
            
            duel = (j1.jeuJoueur.size() > 0) && (j2.jeuJoueur.size() > 0);
        }
    
        //! ENDGAME (lol les avengers)
        if(j1.jeuJoueur.size() == 0){
            System.out.println("Le joueur 2 a gagné la partie");
        }else if(j2.jeuJoueur.size() == 0){
            System.out.println("Le joueur 1 a gagné la partie");
        }   
    }

    public static void batailled(Joueur j1,Joueur j2){
        j1.jouerUneCarte();
        j1.jouerUneCarte();
        j2.jouerUneCarte();
        j2.jouerUneCarte();
        j1.carteJouee.get(j1.carteJouee.size() - 1 ).comparer(j2.carteJouee.get(j1.carteJouee.size()  - 1));
        if(j1.carteJouee.get(j1.carteJouee.size()  - 1).getWin() == (1)){
            j1.gagne(j2);
        }else if (j1.carteJouee.get(j1.carteJouee.size()  - 1).getWin() == (-1)){
            j2.gagne(j1);
        }else{
            if((j1.assezCarte())&&(j2.assezCarte())){
            batailled(j1,j2);
            }else{
                if(j1.jeuJoueur.size() < j2.jeuJoueur.size()){
                    j1.gagne(j2);
                }else{
                    j2.gagne(j1);
                }
            }
        }
        j2.vider();
        j1.vider();
    }
   
}
