import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
/**
 * Created by Konrad on 2014-10-31.
 */
@Theme("valo")
public class Login extends UI {
    @Override
    public void init(VaadinRequest request) {
        Page.getCurrent().setTitle("ULTIMATE WEB PM APP");
        VerticalLayout layout = new VerticalLayout();
        Panel loginPanel = new Panel("Login");
        layout.setSizeFull();
        loginPanel.setWidth("250px");
        loginPanel.setHeight("250px");
        loginPanel.setContent(layout);
        loginPanel.setContent(new View());
        layout.addComponent(loginPanel);
        layout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        setContent(layout);

    }
}
class View extends VerticalLayout {

    private final TextField getLogin = new TextField("login name");
    private final PasswordField getPassword = new PasswordField("password");
    private final Button LoginButton = new Button("Login");

    public View() {
        getLogin.setRequired(true);
        getPassword.setRequired(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponent(getLogin);
        addComponent(getPassword);
        addComponent(LoginButton);
        setSizeFull();
        addStyleName("myview");
    }

}