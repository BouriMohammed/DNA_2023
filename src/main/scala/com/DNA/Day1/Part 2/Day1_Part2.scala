// import akka.actor.{Actor, ActorSystem, Props}

// case class Store(key: String, value: String)
// case class Lookup(key: String)
// case class Delete(key: String)

// class KeyValueStore extends Actor {
//   private var store = Map.empty[String, String]

//   override def receive: Receive = {
//     case Store(key, value) =>
//       store += (key -> value)
//       println(s"Stored value $value with key $key")
//     case Lookup(key) =>
//       store.get(key) match {
//         case Some(value) => println(s"Value for key $key: $value")
//         case None => println(s"No value found for key $key")
//       }
//     case Delete(key) =>
//       store -= key
//       println(s"Deleted value for key $key")
//   }
// }

// class ConsoleReader(keyValueStore: akka.actor.ActorRef) extends Actor {
//   override def receive: Receive = {
//     case input: String =>
//       val args = input.trim.split(" ")
//       args.headOption match {
//         case Some("store") =>
//           if (args.length == 3) {
//             val key = args(1)
//             val value = args(2)
//             keyValueStore ! Store(key, value)
//           } else {
//             println("Usage: store key value")
//           }
//         case Some("lookup") =>
//           if (args.length == 2) {
//             val key = args(1)
//             keyValueStore ! Lookup(key)
//           } else {
//             println("Usage: lookup key")
//           }
//         case Some("delete") =>
//           if (args.length == 2) {
//             val key = args(1)
//             keyValueStore ! Delete(key)
//           } else {
//             println("Usage: delete key")
//           }
//         case _ =>
//           println("Unknown command")
//       }
//   }
// }