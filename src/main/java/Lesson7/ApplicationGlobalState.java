package Lesson7;
//There is configuration class to keep App settings
public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "P2fOkl6jGKwqQT2AqFpATAdfyTLb1YOU";
   private final String DB_FILENAME = "geekbrains.db";

    private ApplicationGlobalState() {
    }

    // No-thread-safe code for simplification App
    // Better to use patterns for safety but it is to explore in future
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }
        return INSTANCE;
    }

    public String getDbFilename () { return DB_FILENAME; }
    public String getSelectedCity() { return selectedCity; }
    public void setSelectedCity(String SelectedCity) { this.selectedCity = selectedCity;}
    public String getApiKey() { return this.API_KEY; }
}
