package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

public abstract class Qualifier {
    private static final String BEFORE = "BEFORE",AFTER = "AFTER", WITHIN = "WITHIN";

    public abstract void calculate(String time, String AMPMH, String Hours) ;

    public abstract String getFrom();
    public abstract String getTo();

    public static Qualifier getQualifierByName(String name) {
        switch (name) {
            case BEFORE:
                return new BeforeQualifier();
            case AFTER:
                return new AfterQualifier();
            case WITHIN:
                return new WithinQualifier();
            default:
                return null;
        }
    }
}
