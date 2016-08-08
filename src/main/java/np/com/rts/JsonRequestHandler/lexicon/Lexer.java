package np.com.rts.JsonRequestHandler.lexicon;

import np.com.rts.JsonRequestHandler.helpers.DateAndTime;

import java.util.*;

public class Lexer {
    public enum Type {
        DateTodayFrom, Qualifier, AMPM,Hours, Time;
    }

    public static HashMap<Type, String> lex(String[] intervalWordArray) {
        HashMap<Type, String> result = new HashMap<Type, String>();
        for (String intervalWord: intervalWordArray) {
            switch (intervalWord.toUpperCase()) {
                case "TODAY":
                    result.put(Type.DateTodayFrom, "TODAY");
                    break;
                case "WITHIN":
                    result.put(Type.Qualifier, "WITHIN");
                    break;
                case "AFTER":
                    result.put(Type.Qualifier, "AFTER");
                    break;
                case "BEFORE":
                    result.put(Type.Qualifier, "BEFORE");
                    break;
                case "AM":
                    result.put(Type.AMPM, "AM"); result.put(Type.Hours,"null");
                    break;
                case "PM":
                    result.put(Type.AMPM, "PM"); result.put(Type.Hours,"null");
                    break;
                case "HOURS":
                    result.put(Type.Hours, "HOURS"); result.put(Type.AMPM,"null");
                    break;
            }
            if (DateAndTime.checkDateFormat(intervalWord) || intervalWord.matches("-?\\d+(\\.\\d+)?")) {
                result.put(Type.Time, intervalWord);
            }
        }
        return result;
    }


}


