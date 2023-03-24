// import akka.actor.typed.ActorSystem

// object Main {
//   def main(args: Array[String]): Unit = {
//     val system = ActorSystem(KeyValueActor("data.txt"), "key-value-system")
    
//     // Send some messages to the actor
//     val replyTo = system.ignoreRef[KeyValueResult] // ActorRef that ignores replies
//     system ! Store("foo", "bar", replyTo)
//     system ! Lookup("foo", replyTo)
//     system ! Delete("foo", replyTo)
    
//     // Shut down the actor system
//     system.terminate()
//   }
// }