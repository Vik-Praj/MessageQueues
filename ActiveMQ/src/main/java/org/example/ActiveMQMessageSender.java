package org.example;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQMessageSender {
    private static String uri = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "MESSAGE_QUEUE";
    public static void main(String args[]) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(uri);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(queueName);

        MessageProducer messageProducer = session.createProducer(destination);

        TextMessage textMessage = session.createTextMessage("This is Vikas. I am sending this message");

        messageProducer.send(textMessage);

        messageProducer.close();
    }
}
