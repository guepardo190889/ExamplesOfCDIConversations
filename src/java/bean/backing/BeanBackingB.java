/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.backing;

import bean.model.BeanModelB;
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
public class BeanBackingB {

    @Inject
    private BeanModelB beanModelB;

    public String goToPageB() {
        this.beanModelB.beginConversation();
        return "/views/pageB";
    }

    public DataModel getListDataModel() {
        return new ListDataModel(this.beanModelB.getList());
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
        this.beanModelB.addItem();
    }

    public void removeItem(ActionEvent actionEvent) {
        this.beanModelB.removeItem();
    }

    /**
     * @return the popupCreate
     */
    public boolean isPopupCreate() {
        return this.beanModelB.isPopupCreate();
    }

    /**
     * @param popupCreate the popupCreate to set
     */
    public void setPopupCreate(boolean popupCreate) {
        this.beanModelB.setPopupCreate(popupCreate);
    }

    /**
     * @return the popupEdit
     */
    public boolean isPopupEdit() {
        return this.beanModelB.isPopupEdit();
    }

    /**
     * @param popupEdit the popupEdit to set
     */
    public void setPopupEdit(boolean popupEdit) {
        this.beanModelB.setPopupEdit(popupEdit);
    }
}
