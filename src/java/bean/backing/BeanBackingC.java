/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.backing;

import bean.model.BeanModelA;
import bean.model.BeanModelB;
import bean.model.BeanModelC;
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
public class BeanBackingC {

    @Inject
    private BeanModelA beanModelA;
    @Inject
    private BeanModelB beanModelB;
    @Inject
    private BeanModelC beanModelC;    

    public String goToPageB() {
        this.beanModelC.beginConversation();
        return "/views/pageC";
    }

    public DataModel getListDataModel() {
        return new ListDataModel(this.beanModelC.getList());
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
        this.beanModelC.addItem();
    }

    public void removeItem(ActionEvent actionEvent) {
        this.beanModelC.removeItem();
    }

    /**
     * @return the popupCreate
     */
    public boolean isPopupCreate() {
        return this.beanModelC.isPopupCreate();
    }

    /**
     * @param popupCreate the popupCreate to set
     */
    public void setPopupCreate(boolean popupCreate) {
        this.beanModelC.setPopupCreate(popupCreate);
    }

    /**
     * @return the popupEdit
     */
    public boolean isPopupEdit() {
        return this.beanModelC.isPopupEdit();
    }

    /**
     * @param popupEdit the popupEdit to set
     */
    public void setPopupEdit(boolean popupEdit) {
        this.beanModelC.setPopupEdit(popupEdit);
    }
}
