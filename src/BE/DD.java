package BE;

import java.text.SimpleDateFormat;

public class DD {
    private SimpleDateFormat dateFormat ;

    public DD(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
