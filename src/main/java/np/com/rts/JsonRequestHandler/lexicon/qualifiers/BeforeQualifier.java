package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import np.com.rts.JsonRequestHandler.helpers.DateAndTime;

public class BeforeQualifier extends Qualifier {
    private String from,to;

    @Override
    public void calculate(String givenDate,String AMPMH,String Hours) {
        DateAndTime dateAndTime = new DateAndTime();
        if(Hours.equalsIgnoreCase("hours")){
            from = dateAndTime.getCurrentHour()-Integer.parseInt(givenDate)+":00:00";
            to = dateAndTime.getCurrentHour()-Integer.parseInt(givenDate)+":00:00";
        }else{
            String currentDate = dateAndTime.getCurrentTime();
            if(givenDate.compareTo(currentDate) > 0){
                from = currentDate;
                to = givenDate;
            }else{
                to = currentDate;
                from = "00:00:00";
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
