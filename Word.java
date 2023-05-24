public class Word{
    private double sentiment;
    private String term;

    public Word(String t, double s){
        sentiment = s;
        term = t;
    }

    public String getTerm(){
        return term;
    }

    public double getSentiment(){
        return sentiment;
    }


}
