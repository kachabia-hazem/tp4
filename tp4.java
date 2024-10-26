public class Dictionnaire {
    private int nb_mots;
    Mot_dict[] Tab;
    private String nom;


    public Dictionnaire(int n, String nom) {
        this.nom = nom;
        this.nb_mots = 0;
        Tab = new Mot_dict[n]; 
    }


    void ajouter_mot(Mot_dict m) {
        if (nb_mots < Tab.length) { 
            Tab[nb_mots] = m;  
            nb_mots++;  
        } else {
            System.out.println("Le dictionnaire est plein.");
        }
    }

    void trier() {
        for (int i = 1; i < nb_mots; i++) {
            Mot_dict ch = Tab[i];
            int j = i - 1;
            while (j >= 0 && Tab[j].getMot().compareTo(ch.getMot()) > 0) {
                Tab[j + 1] = Tab[j];
                j = j - 1;
            }
            Tab[j + 1] = ch;
        }
    }

    void supprimer(Mot_dict m) {
        int index = -1;
        for (int i = 0; i < nb_mots; i++) {
            if (Tab[i].equals(m)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < nb_mots - 1; i++) {
                Tab[i] = Tab[i + 1]; 
            }
            nb_mots--;
        } else {
            System.out.println("Mot non trouvé.");
        }
    }

 
    String recherche_dicho(String mott) {
        int g = 0;
        int d = nb_mots - 1;
        while (g <= d) {
            int milieu = g + (d - g) / 2;
            Mot_dict mot = Tab[milieu];
            int comparaison = mot.getMot().compareTo(mott);
            if (comparaison == 0) {
                return mot.getdefinition();
            } else if (comparaison > 0) {
                d = milieu - 1;  
            } else {
                g = milieu + 1;  
            }
        }
        return "Mot non trouvé.";
    }
    public void lister_dict() {
        for (int i = 0; i < nb_mots; i++) { 
            Mot_dict mot = Tab[i];
            System.out.print(mot.getMot() + " , " + mot.getdefinition ()+ " || ");
        }
    }

    int nbr_synonyme(Mot_dict m) {
        int nb = 0;
        for (int i = 0; i < nb_mots; i++) {
            if (m.synonyme(Tab[i])) {
                nb++;
            }
        }
        return nb;  
    }
}

public class Mot_dict {
	private String Mot;
	private String definition;
	public Mot_dict(String m,String def) {
		this.Mot=m;
		this.definition=def;
	}
	String getMot() {
		return this.Mot;
	}
	String getdefinition() {
		return this.definition;
	}
	void setMot(String m) {
		this.Mot=m;
	}
	void setdefinition(String d) {
		this.definition=d;
	}
	boolean synonyme(Mot_dict mot) {
		if(this.definition.equals(mot.definition)){
			return true;
		}
		else {
			return false;
		}	
	}
	public static void  main (String[] args) {
		 Mot_dict m=new Mot_dict("hazem","un eleve poli");
		 Mot_dict m2=new Mot_dict("ahmed","un eleve impoli");
		 Mot_dict m3=new Mot_dict("wassim","un eleve poli");
		 Mot_dict m4=new Mot_dict("aya","une eleve polie");
		 Mot_dict m5=new Mot_dict("salma","une eleve impoli");
		 
		 Dictionnaire d=new Dictionnaire(20,"larouss");
		 d.ajouter_mot(m);
		 d.ajouter_mot(m2);
		 d.ajouter_mot(m3);
		 d.ajouter_mot(m4);
		 d.ajouter_mot(m5);
		 System.out.println(m.synonyme(m3));
		 System.out.println(m.synonyme(m2));
		 d.trier();
		 d.supprimer(m2);
		 d.lister_dict();
		 
		 
		 
		 
		
		
		
	}
	

}
