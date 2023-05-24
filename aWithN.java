public class aWithN {
    
    public static String chooseA(Word nextWord){
        String first = nextWord.getTerm().substring(0,0);
        if (first.equals("a")||first.equals("e")||first.equals("i")||first.equals("o")||first.equals("u")){
            return "an";
        } else{
            return "a";
        }

    }
}
