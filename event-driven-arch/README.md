
#### To start the rabbit mq server on mac

brew install rabbitmq
brew services start rabbitmq

#### to list the queue
rabbitmqctl list_queues name messages_ready messages_unacknowledged