/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author b75ckd35th
 */
@Named
@ConversationScoped
public class BeanModelB implements Serializable {

    @Inject
    private Conversation conversation;
    private List<String> list;
    private boolean popupCreate;
    private boolean popupEdit;

    public void beginConversation() {
        System.out.println("BeanModelB.beginConversation()");
        endConversation();
        
        if (this.getConversation().isTransient()) {
            this.getConversation().setTimeout(60000); //1 minuto (60000ms) dura la conversación
            this.getConversation().begin();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was beggined sucessfully"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was can't beggined because not is Transient"));
        }
    }

    public void endConversation() {
        System.out.println("BeanModelB.endConversation()");
        if (!this.conversation.isTransient()) {
            this.getConversation().end();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was ended sucessfully"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was can't ended because not is Long Running"));
        }
    }

    public void loadList() {
        this.list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            this.list.add("Element " + i);
        }
    }

    public void addItem() {
        this.list.add("Element " + (this.list.size() + 1));
    }

    public void removeItem() {
        this.list.remove(this.list.size() - 1);
    }

    /**
     * @return the conversation
     */
    public Conversation getConversation() {
        return this.conversation;
    }

    /**
     * @param conversation the conversation to set
     */
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    /**
     * @return the popupCreate
     */
    public boolean isPopupCreate() {
        return popupCreate;
    }

    /**
     * @param popupCreate the popupCreate to set
     */
    public void setPopupCreate(boolean popupCreate) {
        this.popupCreate = popupCreate;
    }

    /**
     * @return the popupEdit
     */
    public boolean isPopupEdit() {
        return popupEdit;
    }

    /**
     * @param popupEdit the popupEdit to set
     */
    public void setPopupEdit(boolean popupEdit) {
        this.popupEdit = popupEdit;
    }

    /**
     * @return the list
     */
    public List<String> getList() {
        if (this.list == null) {
            loadList();
        }
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }
}
