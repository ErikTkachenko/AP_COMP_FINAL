import java.util.ArrayList;
public class WordChooser {
    
    //TODO GET WORDCHOOSER TO ACCEPT ALL KINDS OF WORDS
    public static Word ChooseWord(Character chara, ArrayList<Word> words){

        double seed = chara.getSentiment();
        seed = seed - Math.random()*0.15;
        seed = seed + Math.random()*0.15;
        if(seed < 0){
            seed = 0;
        }else if(seed > 1){
            seed = 1;
        }
        Word wordchosen = new Word("",-999);

        while(wordchosen.getTerm().equals("")){
            for(Word w:words){
                if(wordchosen.getTerm().equals("")){
                    double range = Math.random()*0.2;
                    if(Math.abs(w.getSentiment() - seed) < range){
                        if(Math.random() > 0.5){
                            wordchosen = w;
                        }
                    }
                }
            }
        }

        return wordchosen;


    }

    public static Word ChooseWordManualSeed(double s, ArrayList<Word> words){

        double seed = s;
        seed = seed - Math.random()*0.15;
        seed = seed + Math.random()*0.15;
        if(seed < 0){
            seed = 0;
        }else if(seed > 1){
            seed = 1;
        }
        Word wordchosen = new Word("",-999);

        while(wordchosen.getTerm().equals("")){
            for(Word w:words){
                if(wordchosen.getTerm().equals("")){
                    double range = Math.random()*0.2;
                    if(Math.abs(w.getSentiment() - seed) < range){
                        if(Math.random() > 0.5){
                            wordchosen = w;
                        }
                    }
                }
            }
        }

        return wordchosen;


    }


}
