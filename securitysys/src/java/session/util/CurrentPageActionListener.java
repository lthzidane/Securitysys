/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.util;

import java.io.Serializable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "currentPageActionListener")
@RequestScoped
public class CurrentPageActionListener implements Serializable, ActionListener {

    @ManagedProperty(value = "#{mobilePageController}")
    private MobilePageController mobilePageController;

    /* Setter method for managed property mobilePageController */
    public void setMobilePageController(MobilePageController mobilePageController) {
        this.mobilePageController = mobilePageController;
    }

    /**
     * Creates a new instance of CurrentPageActionListener
     */
    public CurrentPageActionListener() {
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        this.mobilePageController.currentPageListener(event);
    }

}
