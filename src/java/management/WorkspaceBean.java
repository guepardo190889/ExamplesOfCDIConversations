package management;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.weld.context.ConversationContext;
import org.jboss.weld.context.ManagedConversation;
import org.jboss.weld.context.http.Http;
/**
 * This bean needs <strong>Weld</strong>.
 *
 * @author Luca
 *
 */
@Named
@RequestScoped
public class WorkspaceBean implements Serializable {
    private static final long serialVersionUID = -457959303651081423L;
//    @Inject
//    @Http
//    private ConversationContext conversationContext;
//    @Inject
//    private Logger logger;
//    /**
//     * Tells whether a ManagedConversation has timed out.
//     *
//     * @param conv
//     * @return <i>true</i> if it has timed out; <i>false</i> if it has not timed
//     *         out yet
//     */
//    public static boolean timedOut(ManagedConversation conv) {
//        return conv.getTimeout() < (new Date().getTime() - conv.getLastUsed());
//    }
//    /**
//     * Get the list of active (long running OR once long-running, then timed-out
//     * but still active) conversation Id's.
//     *
//     * @return a List<String> of conversation ids
//     */
//    public List<String> getActiveConversationIds() {
//        List<String> result = new ArrayList<String>();
//        for (Iterator<ManagedConversation> i = getActiveConversations()
//                .iterator(); i.hasNext();) {
//            result.add(i.next().getId());
//        }
//        return result;
//    }
//    /**
//     * Get a list of the active ManagedConversation. To be in the list, a
//     * conversations must satisfy one of these two requirements:
//     * <ul>
//     * <li>It's long running and has not timed out yet;</li>
//     * <li>It was long running and has timed out.</li>
//     * </ul>
//     * The list does NOT contain transient conversations.
//     *
//     * @return a Collection of org.jboss.weld.context.ManagedConversation,
//     *         sorted by conversation id.
//     */
//    public Collection<ManagedConversation> getActiveConversations() {
//        List<ManagedConversation> result = new ArrayList<ManagedConversation>(
//                conversationContext.getConversations());
//        // Weld's documentation reads:
//        // "conversations are not assigned ids until they become non-transient."
//        // Actually, that's not the case! ConversationContext.getConversations()
//        // lacks the current conversation even though it's already long running!
//        //
//        // We workaround by adding the current conversation, if it's long
//        // running.
//        ManagedConversation currentConversation = conversationContext
//                .getCurrentConversation();
//        if (!currentConversation.isTransient()) {
//            if (!result.contains(currentConversation))
//                result.add(currentConversation);
//        }
//        // Sort the conversations by conversation id in ascending order
//        Collections.sort(result, new ManagedConversationComparator());
//        return result;
//    }
//    /**
//     * Get the list of active, long running, not yet timed-out conversation
//     * Id's.
//     *
//     * @return
//     */
//    public List<String> getLongRunningConversationIds() {
//        List<String> result = new ArrayList<String>();
//        for (Iterator<ManagedConversation> i = getLongRunningConversations()
//                .iterator(); i.hasNext();) {
//            result.add(i.next().getId());
//        }
//        return result;
//    }
//    /**
//     * Get all AND ONLY the <strong>long running</strong> active conversations
//     * that haven't timed out yet.
//     *
//     * @return a Collection of long running
//     *         org.jboss.weld.context.ManagedConversation, sorted by
//     *         conversation id.
//     */
//    public Collection<ManagedConversation> getLongRunningConversations() {
//        Collection<ManagedConversation> result = new ArrayList<ManagedConversation>();
//        ManagedConversation conv;
//        // Get all the active conversations
//        Collection<ManagedConversation> activeConversations = getActiveConversations();
//        for (Iterator<ManagedConversation> i = activeConversations.iterator(); i
//                .hasNext();) {
//            conv = i.next();
//            // If the conversation is STILL long running, add it to the result
//            if (!timedOut(conv)) {
//                result.add(conv);
//            }
//        }
//        return result;
//    }
//    /**
//     * Logs info about the workspace
//     */
//    private void output() {
//        logger.info("Current Conversation: "
//                + conversationContext.getCurrentConversation());
//        logger.info("Long Running Conversations: ");
//        Iterator<ManagedConversation> i = getLongRunningConversations()
//                .iterator();
//        while (i.hasNext()) {
//            logger.info(i.next());
//        }
//        logger.info("Active Conversations: ");
//        i = getActiveConversations().iterator();
//        while (i.hasNext()) {
//            logger.info(i.next());
//        }
//    }
//    /*
//     * Life cycle methods
//     */
//    @PostConstruct
//    public void postConstruct() {
//        logger.info("postConstruct()");
//        output();
//    }
//    @PreDestroy
//    public void preDestroy() {
//        logger.info("preDestroy()");
//        output();
//    }
}