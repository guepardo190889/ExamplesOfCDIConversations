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
import javax.inject.Inject;
import javax.inject.Named;
import management.ConversationsManager;

/**
 *
 * @author b75ckd35th
 */
@Named
@ConversationScoped
public class BeanModelB implements Serializable {

    @Inject
    private Conversation conversation;
    @Inject
    private ConversationsManager conversationsManager;
    private List<String> list;
    private boolean popupCreate;
    private boolean popupEdit;

    public void beginConversation() {
//        if (this.getConversation().isTransient()) {
//            this.getConversation().setTimeout(30000); //1 minuto (60000ms) dura la conversación
//            this.getConversation().begin();
//            this.conversationsManager.getConversations().add(getConversation().getId());
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was beggined sucessfully"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Conversation was can't beggined because not is Transient"));
//        }

        System.out.println("1.- Contains ConversationBeanModelB: " + this.conversationsManager.conversationContextContainsConversation(this.conversation.getId()));
        this.conversationsManager.endALlConversations();
        System.out.println("2.- Contains ConversationBeanModelB: " + this.conversationsManager.conversationContextContainsConversation(this.conversation.getId()));
        this.conversationsManager.beginConversation("ConversationBeanModelB");
        System.out.println("3.- Contains ConversationBeanModelB: " + this.conversationsManager.conversationContextContainsConversation(this.conversation.getId()));
    }

//    public void endConversation() {
//        if (!this.conversation.isTransient()) {
//            this.getConversation().end();
//            this.conversationsManager.getConversations().remove(getConversation().getId());
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was ended sucessfully"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conversation was can't ended because not is Long Running"));
//        }
//    }

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
