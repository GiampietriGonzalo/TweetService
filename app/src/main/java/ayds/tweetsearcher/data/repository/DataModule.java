package ayds.tweetsearcher.data.repository;

import ayds.tweetsearcher.data.repository.external.servicesbroker.ExternalServiceModule;
import ayds.tweetsearcher.data.repository.external.servicesbroker.TwitterService;
import ayds.tweetsearcher.domain.TweetsRepository;

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
