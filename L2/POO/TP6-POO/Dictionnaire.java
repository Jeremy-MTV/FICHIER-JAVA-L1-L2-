public class Dictionnaire implements Triable {
    
    private String[] dic;

    Dictionnaire(String[] dic){
        this.dic = new String[dic.length];
        for(int i = 0; i<dic.length; i++){
            this.dic[i] = dic[i];
        }
    }

    public int taille(){
        return dic.length;
    }

    public boolean plusGrand(int i, int j){
        return dic[i].compareTo(dic[j]) > 0; //On compare dic[i] et dic[j]
    }

    public void echange(int i, int j){
        String tmp = dic[i];
        dic[i] = dic[j];
        dic[j] = tmp;
    }

    public String toString(){
        String acc = "";
        for(String x : dic){
            acc += x + " ";
        }
        return acc + "\n";
    }
}
