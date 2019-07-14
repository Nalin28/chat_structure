package rough

object BasicExample extends App {

  // options availables
  abstract class Msg
  case class Login(username: String, password: String) extends Msg

  case class Message(message: String) extends Msg

  case class Logout(username: String) extends Msg

  def receive(msg: Msg): Unit = msg match {
    case Login(username, _) => println(s"[$username] joined the chat...")
    case Message(message) => println(s"$message")
    case Logout(username) => println(s"[$username] is out")
  }
    val login = Login("nalin", "abc123")
    val msg = Message("hey whats up?")
    val logout = Logout("nalin")

    receive(login)
    receive(msg)
    receive(logout)
}