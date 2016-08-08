package np.com.rts.JsonRequestHandler.lexicon;

import np.com.rts.JsonRequestHandler.helpers.DateAndTime;
import np.com.rts.JsonRequestHandler.lexicon.qualifiers.Qualifier;
import np.com.rts.JsonRequestHandler.DatabaseHandler;
import np.com.rts.JsonRequestHandler.helpers.ValueCalculator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LexiconInterpretor extends Lexer {

    public float getValueForLexicon(String station, String parameter, String dataRetrivalType, String intervalLexicon) throws SQLException, ClassNotFoundException {
        HashMap<Type, String> hashMap = lex(intervalLexicon.split("\\s+"));
        DateAndTime dateAndTime = new DateAndTime();
        DatabaseHandler connecter = new DatabaseHandler();
        String qualifierString = hashMap.get(Type.Qualifier);
        Qualifier qualifier = Qualifier.getQualifierByName(qualifierString);
        if (qualifier == null) {
            throw new IllegalArgumentException("Bad qualifier specified: " + qualifierString);
        }
        if(hashMap.containsKey(Type.AMPM)){
            hashMap.replace(Type.Time,dateAndTime.standardizeTime(hashMap.get(Type.Time),hashMap.get(Type.AMPM)));
        }
        if(!hashMap.containsKey(Type.AMPM)){
            hashMap.put(Type.AMPM,"null");
        }
        if(!hashMap.containsKey(Type.Hours)){
            hashMap.put(Type.Hours,"null");
        }
        qualifier.calculate(hashMap.get(Type.Time),hashMap.get(Type.AMPM),hashMap.get(Type.Hours));
        String from = qualifier.getFrom();
        String to = qualifier.getTo();
        from = dateAndTime.getDate() + " " + from;
        to = dateAndTime.getDate() + " " + to;
        ArrayList<Float> valuesWithinRange = connecter.getValue(connecter.getStationId(station), connecter.getParameterId(parameter), from, to);
        return ValueCalculator.calculate(valuesWithinRange, dataRetrivalType);
    }
}
