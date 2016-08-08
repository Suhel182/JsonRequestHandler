package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import np.com.rts.JsonRequestHandler.helpers.DateAndTime;

public class AfterQualifier extends Qualifier{
    String to, from;
    @Override
    public void calculate(String givenDate, String AMPMH, String Hours) {
        DateAndTime dateAndTime = new DateAndTime();
        if(Hours.equalsIgnoreCase("hours")){
            from = dateAndTime.getCurrentHour()+Integer.valueOf(givenDate)+":00:00";
            to = from;
        }else{
            String currentDate = dateAndTime.getCurrentTime();
            if(currentDate.compareTo(givenDate) > 0){
                from = currentDate;
                to = givenDate;
            }else{
                from = givenDate;
                to = currentDate;
            }
        }
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
