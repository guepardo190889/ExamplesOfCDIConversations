/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.weld.context.ConversationContext;
import org.jboss.weld.context.ManagedConversation;
import org.jboss.weld.context.http.Http;

/**
 * Clase que provee diversos métodos para poder administrar las Conversaciones
 * que tenga el Usuario durante su sesión en el Sistema
 *
 * @author sluis
 */
@Named
@SessionScoped
public class ConversationsManager implements Serializable {

    @Http
    @Inject
    private ConversationContext conversationContext;
    @Inject
    private Conversation conversation;
    private List<String> conversations = new ArrayList<String>();

    public ConversationsManager() {
    }

    /**
     * @return the conversations
     */
    public List<String> getConversations() {
        return conversations;
    }
    
    public DataModel getConversationsDataModel() {
        return new ListDataModel(getConversations());
    }

    /**
     * @param conversations the conversations to set
     */
    public void setConversations(List<String> conversations) {
        this.conversations = conversations;
    }
    
    public String getCurrentConversation() {
        return this.conversationContext.getCurrentConversation().getId();
    }
    
    public DataModel managedConversationsDataModel() {
        List<ManagedConversation> list = new ArrayList<ManagedConversation>(this.conversationContext.getConversations());
        return new ListDataModel(list);
    }
    
    public void killLastConversation(ActionEvent actionEvent) {
        String idLastConversation = getConversations().get(getConversations().size() - 1);
        System.out.println("idLastConversation: " + idLastConversation);
        
        ManagedConversation managedConversation = this.conversationContext.getConversation(idLastConversation);
        
        if(!managedConversation.isTransient()) {
            managedConversation.end();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The las Conversation with id " + managedConversation.getId() + " was killed sucessfully"));
        }
    }
    
    public void endCurrentConversation() {
        if(!this.conversation.isTransient()) {
            String id = this.conversation.getId();
            this.conversation.end();
            this.conversations.remove(id);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Conversation with id " + id + " was ended sucessfully"));
        }
    }
}
