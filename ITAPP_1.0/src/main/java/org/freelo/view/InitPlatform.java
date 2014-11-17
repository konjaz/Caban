package org.freelo.view;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;


/**
 * Created by Konrad on 2014-11-16
 */
public class InitPlatform extends UI {

    @Override
    public void init(VaadinRequest request) {
        new Navigator(this, this);
        Page.getCurrent().setTitle("Example IT App");
        getNavigator().addView("", Login.LoginView.class);
    }


}
