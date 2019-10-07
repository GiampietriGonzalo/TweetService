package ayds.tweetsservice;

public class DataModule {

    private static DataModule instance;

    private DataModule() {}

    public static DataModule getInstance() {
        if (instance == null) {
            instance = new DataModule();
        }
        return instance;
    }

    public TweetsRepository getExternalService() {
        TwitterService externalService = ExternalServiceModule.getInstance().getTwitterlService();
        return new TweetsRepositoryImp(externalService);
    }
}
