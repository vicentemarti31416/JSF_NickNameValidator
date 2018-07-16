package beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "indexBean")
@RequestScoped
public class IndexBean {

    @Inject
    private UsersFacadeLocal usersFacadeLocal;
    private List<Users> listUsers;
    private String nickname;
    private String message = "";

    public IndexBean() {
    }

    @PostConstruct
    public void getUsersList() {
        this.listUsers = usersFacadeLocal.findAll();
    }

    public void checkNickname() {
        if (listUsers.stream().anyMatch(user -> user.getNickname().equals(nickname))) {
            message = "Nickname en uso, por favor, elija otro";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
