import com.google.gwt.layout.client.*;
import com.google.gwt.layout.client.Layout;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.*;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;

@Theme("valo")
public class Login extends UI {
    Navigator navigator;
    protected static final String LOGINVIEW = "LoginView";

    public class LoginView extends VerticalLayout implements View {

        private TextField getLogin = new TextField("login name");
        private final PasswordField getPassword = new PasswordField("password");

        public LoginView() {

            Button startRegistration = new Button("Registration",
                    new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent event) {
                            navigator.navigateTo(LOGINVIEW);
                        }
                    });
            startRegistration.addStyleName(Reindeer.BUTTON_LINK);

            Button LoginButton = new Button("Login",
                    new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent event) {
                            navigator.navigateTo("");
                        }
                    });


            //Layout of main page
            VerticalLayout vLayout = new VerticalLayout();

            vLayout.setSizeFull();
            //Item allocation
            //Main Login Panel
            Panel mainLogin = new Panel("Login");
            mainLogin.setHeight("250px");
            mainLogin.setWidth("350px");
            //Another vertical layout to allocate items
            VerticalLayout vLayout2 = new VerticalLayout();
            vLayout2.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
            vLayout2.addComponent(getLogin);
            vLayout2.addComponent(getPassword);
            vLayout2.addComponent(LoginButton);
            vLayout2.addComponent(startRegistration);
            mainLogin.setContent(vLayout2);
            vLayout.addComponent(mainLogin);
            vLayout.setComponentAlignment(mainLogin, Alignment.MIDDLE_CENTER);
            addComponent(vLayout);
        }


        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            Notification.show("Welcome !");
        }
    }
    @Override
    public void init(VaadinRequest request) {
        Page.getCurrent().setTitle("Example IT App");
        navigator = new Navigator(this, this);
        navigator.addView("", new LoginView());
    }

}
//class LoginPage extends VerticalLayout {
//    Navigator navigator;
//    private final TextField getLogin = new TextField("login name");
//    private final PasswordField getPassword = new PasswordField("password");
//    private final Button LoginButton = new Button("Login");
//    private Button startRegistration = new Button("Registration");
//
//    public void setStartRegistration(Button startRegistration) {
//        this.startRegistration = startRegistration;
//        startRegistration.addStyleName(Reindeer.BUTTON_LINK);
//        startRegistration.addClickListener(new Button.ClickListener(){
//            public void buttonClick(Button.ClickEvent event) {
//                Notification.show("Starting registration !");
//                navigator.navigateTo("LoginView");
//            }
//        });
//    }
//
//    public LoginPage() {
//        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
//        addComponent(getLogin);
//        addComponent(getPassword);
//        addComponent(LoginButton);
//        addComponent(startRegistration);
//        setStartRegistration(startRegistration);
//        setSizeFull();
//        addStyleName("LoginView");
//    }
//}
//
//class RegisterPage extends VerticalLayout {
//    private final TextField login = new TextField("login name");
//    private final TextField mail = new TextField("e-mail address");
//    private final PasswordField password = new PasswordField("password");
//    private final TextField name = new TextField("Name");
//    private final TextField surname = new TextField("Surname");
//    private final Button RegisterButton = new Button("Register");
//
//    public RegisterPage(){
//        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
//        addComponent(name);
//        addComponent(surname);
//        addComponent(mail);
//        addComponent(login);
//        addComponent(password);
//        addComponent(RegisterButton);
//        setSizeFull();
//    }
//}