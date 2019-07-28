package rough

import akka.actor.{Actor, ActorSystem, Props}

  abstract class Msg
  case class Login(username: String, password: String) extends Msg
  case class Message(message: String) extends Msg
  case class Logout(username: String) extends Msg

  class Threaded_chat extends Actor {
    def receive = {
      case Login(username, _) => println(s"[$username] joined the chat...")
      case Message(message) => println(s"$message")
      case Logout(username) => println(s"[$username] is out")
    }
  }

  object Threaded_chat extends App {
    val system = ActorSystem("Threaded_chat")
    // implicit val materializer = ActorMaterializer.create(system)
    val myActor = system.actorOf(Props[Threaded_chat])

    val login = Login("nalin", "abc123")
    val login1 = Login("malin", "abc456")
    val msg = Message("hey whats up?")
    val msg1 = Message("nothing much")
    val logout = Logout("nalin")
    val logout1 = Logout("malin")
    myActor ! login
    myActor ! msg
    myActor ! login1

    myActor ! msg1
    myActor ! logout
    myActor ! logout

    system.terminate()
  }
