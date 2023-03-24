// import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
// import akka.actor.typed.{ActorRef, Behavior, ActorSystem}


// import java.io.{BufferedWriter, File, FileWriter}
// import scala.io.Source

// sealed trait KeyValueCommand
// case class Store(key: String, value: String, replyTo: ActorRef[StoreResult]) extends KeyValueCommand
// case class Delete(key: String, replyTo: ActorRef[DeleteResult]) extends KeyValueCommand
// case class Lookup(key: String, replyTo: ActorRef[LookupResult]) extends KeyValueCommand

// sealed trait KeyValueResult
// case class StoreResult(success: Boolean) extends KeyValueResult
// case class DeleteResult(success: Boolean) extends KeyValueResult
// case class LookupResult(result: Option[String]) extends KeyValueResult

// object KeyValueActor {
//   def apply(filePath: String): Behavior[KeyValueCommand] =
//     Behaviors.setup { context =>
//       new KeyValueActor(context, filePath)
//     }
// }

// class KeyValueActor(context: ActorContext[KeyValueCommand], filePath: String)
//   extends AbstractBehavior[KeyValueCommand](context) {

//   private val file = new File(filePath)
//   if (!file.exists()) {
//     file.createNewFile()
//   }

//   override def onMessage(msg: KeyValueCommand): Behavior[KeyValueCommand] = {
//     msg match {
//       case Store(key, value, replyTo) =>
//         if (containsKey(key)) {
//           replyTo ! StoreResult(success = false)
//           this
//         } else {
//           val writer = new BufferedWriter(new FileWriter(file, true))
//           writer.write(s"$key:$value\n")
//           writer.close()
//           replyTo ! StoreResult(success = true)
//           this
//         }

//       case Delete(key, replyTo) =>
//         if (containsKey(key)) {
//           val writer = new BufferedWriter(new FileWriter(file, true))
//           writer.write(s"$key:deleted\n")
//           writer.close()
//           replyTo ! DeleteResult(success = true)
//           this
//         } else {
//           replyTo ! DeleteResult(success = false)
//           this
//         }

//       case Lookup(key, replyTo) =>
//         val source = Source.fromFile(file).getLines().toList.reverseIterator
//         val result = source
//           .collectFirst {
//             case line if line.startsWith(s"$key:") && !line.endsWith(":deleted") =>
//               line.stripPrefix(s"$key:")
//           }
//         source.foreach(_ => ()) // force iteration until end to release resources
//         replyTo ! LookupResult(result)
//         this
//     }
//   }

//   private def containsKey(key: String): Boolean = {
//     val source = Source.fromFile(file).getLines().toList.reverseIterator
//     val result = source.exists(line => line.startsWith(s"$key:") && !line.endsWith(":deleted"))
//     source.foreach(_ => ()) // force iteration until end to release resources
//     result
//   }
// }