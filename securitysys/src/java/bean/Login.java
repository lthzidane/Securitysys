/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import lombok.Data;
import bean.LoginDao;
/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
@Data
public class Login  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    private String msg;

   public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Se crea una  nueva instancia para login
     * @return 
     */
    public String validateUsernamePassword(){
        boolean valid = LoginDao.validate(username, password);
        if (valid) {
            HttpSession session = SessionBean.getSession();
               session.setAttribute("username", username);
                return "admin";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage( FacesMessage.SEVERITY_WARN, 
                            "Usuario y Contraseña invalida",
                            "Por favor ingrese Usuario y Contraseña"));
           return "login"; 
        }
    }
    
    //logout
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
    } 
    //public Login() {
    //}
    
