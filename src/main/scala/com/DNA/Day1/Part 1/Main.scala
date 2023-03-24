// object Main extends App {
//   val storeSystem = new StoreSystem
//   storeSystem.store("key1", "value1")
//   storeSystem.store("key2", "value2")
//   storeSystem.store("key3", "value3")

//   val value1 = storeSystem.lookup("key1")
//   println(s"Value for key1: $value1") // Value for key1: Some(value1)

//   val value2 = storeSystem.lookup("key2")
//   println(s"Value for key2: $value2") // Value for key2: Some(value2)

//   val value3 = storeSystem.lookup("key3")
//   println(s"Value for key3: $value3") // Value for key3: Some(value3)

//   storeSystem.delete("key2")
//   val deletedValue = storeSystem.lookup("key2")
//   println(s"Deleted value for key2: $deletedValue") // Deleted value for key2: None
// }