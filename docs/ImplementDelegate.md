To implement a generated API Controller Delegate, follow these steps:

1. Create a kotlin controller class, extending from the generated delegator class
2. Override function to return the desired response object and status
3. annotate the class as @Component with corresponding delegator class as argument
   (this annotation is required to autowire the class with the corresponding generated conroller)

Example:

```kotlin
@Component("roomsControllerDelegate")
class RoomController : RoomsControllerDelegate {
   override fun getRooms(): ResponseEntity<List<Room>> {
      val rooms = listOf<Room>(
      Room("test", "test1"),
      Room("test2", "test3"),
      Room("test4", "test5")
      )
      return ResponseEntity(rooms, HttpStatus.OK)
   }
}
```

