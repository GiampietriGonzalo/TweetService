package ayds.tweetsearcher.presentation.view;

import ayds.tweetsearcher.presentation.presenter.ShowTweetsPresenter;
import ayds.tweetsearcher.presentation.presenter.PresenterModule;

public class ViewModule {

    private static ViewModule instance;

    private ViewModule() {}

    public static ViewModule getInstance() {
        if (instance == null) {
            instance = new ViewModule();
        }
        return instance;
    }

    void setView(ShowTweetsView view) {
        ShowTweetsPresenter presenter = PresenterModule.getInstance().getPresenter(view);
        view.setPresenter(presenter);
    }

}
