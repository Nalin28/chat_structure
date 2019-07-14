package rough

object ClassMarks extends App{

  case class Student(name: String, roll: Int, marks: Marks)
  case class Marks(physics: Int, chemistry: Int, maths: Int)

  val student1 = Student("Nalin", 23, Marks(90, 91, 92))
  val student2 = Student("Malin", 24, Marks(91, 92, 93))

  val avg1: Double = (student1.marks.physics + student1.marks.chemistry + student1.marks.maths)/3
  val avg2: Double = (student2.marks.physics + student2.marks.chemistry + student2.marks.maths)/3
  val list = List(avg1, avg2)
   avg1 match{
     case x if x > 90 =>  println(s"Good Job ${student1.name} roll number ${student1.roll}")
    case _ => println("Next year")
  }

  avg2 match{
    case x if x > 90 =>  println(s"Good Job ${student2.name} roll number ${student2.roll}")
    case _ => println("Next year")
  }

  list foreach {
    case x if x > 90 => println("Good")
    case _ => println("No Good")
  }




}
