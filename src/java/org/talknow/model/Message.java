package org.talknow.model;

public class Message {
    private String sender;
    private String messageContent;

    public Message() {
    }

    public Message(String sender, String messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
    }
    
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" + "sender=" + sender + ", messageContent=" + messageContent + '}';
    }
    
}
