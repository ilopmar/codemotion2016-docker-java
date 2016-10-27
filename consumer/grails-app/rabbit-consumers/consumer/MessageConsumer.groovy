package consumer

class MessageConsumer {

    static rabbitConfig = [
        queue: "reverse"
    ]

    void handleMessage(String message) {
        println "Mensaje recibido: ${message}"

        new Message(message: message.reverse()).save()
    }
}
