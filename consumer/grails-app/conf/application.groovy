environments {
    development {
        rabbitmq {
            connection = {
                connection host: "localhost", username: "guest", password: "guest"
            }
            queues = {
                queue name: "reverse"
            }
        }
    }
    production {
        rabbitmq {
            connection = {
                connection host: "rabbitmq", username: "guest", password: "guest"
            }
            queues = {
                queue name: "reverse"
            }
        }
}   }

