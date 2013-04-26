/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.backing;

import bean.model.BeanModelA;
import javax.enterprise.inject.Model;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

/**
 *
 * @author b75ckd35th
 */
@Model
public class BeanBackingA {
    
    @Inject
    private BeanModelA beanModelA;
    
    public String goToPageA() {
        this.beanModelA.beginConversation();
        return "/views/pageA";
    }
    
    public DataModel getListDataModel() {
        return new ListDataModel(this.beanModelA.getList());
    }
    
    public void openPopupCreate(ActionEvent actionEvent) {
        setPopupCreate(true);
    }
    
    public void closePopupCreate(ActionEvent actionEvent) {
        setPopupCreate(false);
    }    
    
    public void openPopupEdit(ActionEvent actionEvent) {
        setPopupEdit(true);
    }
    
    public void closePopupEdit(ActionEvent actionEvent) {
        setPopupEdit(false);
    }
    
    public void addItem(ActionEvent actionEvent) {
        this.beanModelA.addItem();
    }
    
    public void removeItem(ActionEvent actionEvent) {
        this.beanModelA.removeItem();
    }

    /**
     * @return the popupCreate
     */
    public boolean isPopupCreate() {
        return this.beanModelA.isPopupCreate();
    }

    /**
     * @param popupCreate the popupCreate to set
     */
    public void setPopupCreate(boolean popupCreate) {
        this.beanModelA.setPopupCreate(popupCreate);
    }

    /**
     * @return the popupEdit
     */
    public boolean isPopupEdit() {
        return this.beanModelA.isPopupEdit();
    }

    /**
     * @param popupEdit the popupEdit to set
     */
    public void setPopupEdit(boolean popupEdit) {
        this.beanModelA.setPopupEdit(popupEdit);
    }    
}
