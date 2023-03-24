// import akka.actor.{Actor, ActorSystem, Props}

// object Main {
//   def main(args: Array[String]): Unit = {
//     val system = ActorSystem("KeyValueStoreSystem")
//     val keyValueStore = system.actorOf(Props[KeyValueStore], "keyValueStore")
//     val consoleReader = system.actorOf(Props(new ConsoleReader(keyValueStore)), "consoleReader")

//     println("Welcome to the KeyValueStore!")
//     println("Type 'store key value' to store a value")
//     println("Type 'lookup key' to look up a value")
//     println("Type 'delete key' to delete a value")

//     while (true) {
//       consoleReader ! scala.io.StdIn.readLine()
//     }
//   }
// }