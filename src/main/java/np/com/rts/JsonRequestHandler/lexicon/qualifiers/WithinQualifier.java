package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import np.com.rts.JsonRequestHandler.helpers.DateAndTime;

public class WithinQualifier extends Qualifier{
    String from, to;
    @Override
    public void calculate(String time,String AMPMH,String Hours) {
        DateAndTime dateAndTime = new DateAndTime();
        int limit = Integer.valueOf(time);
        int current = dateAndTime.getCurrentHour();
        if(current-limit<0){
            from="00:00:00";
        }else {
            from = dateAndTime.standardizeTime(String.valueOf(current-limit),"HOURS");
        }
        to=dateAndTime.getCurrentTime();
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }
}
