public class Verb extends Word{
    private String contTense;

    public Verb (String t, String cont, double s){
        super(t,s);
        contTense = cont;
    }

    public String getCont(){
        return contTense;
    }
}
