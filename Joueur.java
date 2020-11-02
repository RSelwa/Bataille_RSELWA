import java.util.ArrayList;
public class Joueur {
    
    //*attributs
    public  ArrayList<Carte> jeuJoueur = new ArrayList();
    public  ArrayList<Carte> carteJouee = new ArrayList();

    //*Accesseurs
    public int getPoints(){return this.jeuJoueur.size();}
    public String getName(){return "Joueur";}


    //*Methods
    public void jouerUneCarte(){
        if(this.jeuJoueur.size() > 0){
            long l = Math.round((int)(Math.random() * (this.jeuJoueur.size())));
            int z=(int)l;
            this.carteJouee.add(this.jeuJoueur.get(z));
            this.jeuJoueur.remove(z);
        }
    }

    //assez de carte pour une bataille
    public Boolean assezCarte(){
            if(this.jeuJoueur.size() >= 2){
                return true;
            }else{
                return false;
            }
    }

    public void gagne(Joueur j2){
        for(int i = 0; i < carteJouee.size(); i++){
            this.jeuJoueur.add(this.carteJouee.get(i));
            this.jeuJoueur.add(j2.carteJouee.get(i));
        }
        
    }
    public void perd(Joueur j2){
        for(int i = 0; i < j2.carteJouee.size(); i++){
            j2.jeuJoueur.add(this.carteJouee.get(i));
            j2.jeuJoueur.add(j2.carteJouee.get(i));
        }
        
    }
    public void vider(){
        for(int i =0; i < this.carteJouee.size(); i++){
            this.carteJouee.remove(i);
        }
    }

}
