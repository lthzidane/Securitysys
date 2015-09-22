/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Data;

/**
 *
 * @author LOTHAR
 */
@ManagedBean
@SessionScoped
@Data
public class Login  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    
}
