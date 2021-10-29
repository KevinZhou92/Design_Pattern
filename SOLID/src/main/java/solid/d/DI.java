package solid.d;

// Non dependency injection implementation
class Notification {
    private MessageSender messageSender;

    public Notification() {
        // Hard-coded initialization of a specific class
        this.messageSender = new MessageSender();
    }

    public void sendMessage(String cellphone, String message) {
        this.messageSender.send(cellphone, message);
    }
}

class MessageSender {
    public void send(String cellphone, String message) {
        //....
    }

    public static void main(String[] args) {
        Notification notification = new Notification();
    }
}

// Dependency Injection
class Notification_DI {
    private final MessageSender messageSender;

    // Pass in MessageSender in constructor
    public Notification_DI(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message) {
        this.messageSender.send(cellphone, message);
    }
}

class MessageSender_DI {
    public void send(String cellphone, String message) {
        //....
    }

    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();
        Notification_DI notification = new Notification_DI(messageSender);
    }
}



// Moreover, make MessageSender an interface
interface MessageSender_Interface {
    void send(String cellphone, String message);
}

// SMS
class SmsSender implements MessageSender_Interface {
    @Override
    public void send(String cellphone, String message) { }
}

// Inbox
class InboxSender implements MessageSender_Interface {
    @Override
    public void send(String cellphone, String message) {}
}

class Notification_DI2 {
    private final MessageSender_Interface messageSender;

    // Pass in MessageSender in constructor
    public Notification_DI2(MessageSender_Interface messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message) {
        this.messageSender.send(cellphone, message);
    }
}

class MessageSender_DI2 {
    public void send(String cellphone, String message) {
        //....
    }

    public static void main(String[] args) {
        MessageSender_Interface messageSender = new SmsSender();
        Notification_DI2 notification = new Notification_DI2(messageSender);
    }
}




