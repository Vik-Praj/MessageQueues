package org.example;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQMessageReceiver {
    private static String uri = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "MESSAGE_QUEUE";
    public static void main(String args[]) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(uri);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(queueName);

        MessageConsumer messageConsumer = session.createConsumer(destination);

        Message message = messageConsumer.receive();

        if(message instanceof  TextMessage){
            TextMessage textMessage1 = (TextMessage) message;
            System.out.println("Message Received: "+textMessage1.getText());
        }

        messageConsumer.close();
    }
}
