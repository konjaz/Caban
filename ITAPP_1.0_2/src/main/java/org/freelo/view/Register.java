package org.freelo.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;

/**
 * Created by Konrad on 2014-11-16.
 */
public class Register extends VerticalLayout implements View {

    public static final String NAME = "register";


    private final Label title = new Label("Registration");
    private final TextField username = new TextField("Username");
    private final PasswordField password = new PasswordField("Password");
    private final TextField mail = new TextField("E-mail Address");
    private final TextField name = new TextField("Name");
    private final TextField surname = new TextField("Surname");
    private final Button RegisterMe;

    public Register(){
        setSizeFull();
        RegisterMe = new Button("Proceed", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String username = String.valueOf(getSession().getAttribute("user"));
                Notification welcome = new Notification(username + " registered !");
                welcome.setDelayMsec(20000);
                welcome.setPosition(Position.MIDDLE_CENTER);
                welcome.show(Page.getCurrent());
                getUI().getNavigator().navigateTo(NAME);
            }
        });
        VerticalLayout mainregpage = new VerticalLayout(title, username, password, mail, name, surname, RegisterMe);
        mainregpage.setMargin(new MarginInfo(true, true, true, true));
        mainregpage.setSpacing(true);

        VerticalLayout viewLayout = new VerticalLayout(mainregpage);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(mainregpage, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        addComponent(viewLayout);
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        username.focus();
    }
}
