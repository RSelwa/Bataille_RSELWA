import java.util.ArrayList;
public class Joueur {
    
    //*attributs
    public  ArrayList<Carte> jeuJoueur = new ArrayList();
    public  ArrayList<Carte> carteJouee = new ArrayList();

    //*Accesseurs
    public int getPoints(){return jeuJoueur.size();}
    public String getName(){return "Joueur";}


    //*Methods
    public void jouerUneCarte(){
        if(jeuJoueur.size() > 0){
            long l = Math.round((int)(Math.random() * (jeuJoueur.size())));
            int z=(int)l;
            carteJouee.add(jeuJoueur.get(z));
            jeuJoueur.remove(z);
        }
    }

    //assez de carte pour une bataille
    public Boolean assezCarte(){
            if(jeuJoueur.size() >= 2){
                return true;
            }else{
                return false;
            }
    }
    // public Boolean assezCarte(Boolean x, int n){
    //     if(x == false){
    //         if(n > 2){
    //             return true;
    //         }else if (n >= 1){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public Boolean assezCarte(Boolean x){
    //     if(x == false){
    //         if(jeuJoueur.size() > 2){
    //             return true;
    //         }else if (jeuJoueur.size() > 1){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public void gagne(Joueur j2){
        for(int i = 0; i < carteJouee.size(); i++){
            jeuJoueur.add(carteJouee.get(i));
            jeuJoueur.add(j2.carteJouee.get(i));
        }
        
    }
    public void perd(Joueur j2){
        for(int i = 0; i < j2.carteJouee.size(); i++){
            j2.jeuJoueur.add(carteJouee.get(i));
            j2.jeuJoueur.add(j2.carteJouee.get(i));
        }
        
    }
    public void vider(){
        for(int i =0; i < carteJouee.size(); i++){
            carteJouee.remove(i);
        }
    }

}
