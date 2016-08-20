package raspopova.diana.sunshineapplication.repository.model;

/**
 * Created by Diana on 14.08.2016.
 */
public enum eUnits {

    METRIC("metric"),
    IMPERIAL("imperial");

    private final String text;

    /**
     * @param text
     */
    private eUnits(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

}

