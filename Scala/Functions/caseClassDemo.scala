package ScalaHandsOn

 //case class demo
object caseClassDemo {
  def main(args: Array[String]) {
     
    case class Person(name:String, phoneNumber: String)
    val george = Person("George", "1234")
    val kate = Person("Kate", "4567")
    
    println(george.phoneNumber)
    println(Person("george","1234") == Person("Kate","1234"))        //false
    println(Person("george","1234") == Person("george","1234"))      //true
    
    
    abstract class Notification
    case class Email(sourceEmail: String, title: String, body: String) extends Notification
    case class SMS(sourceNumber: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification
    
    
    //Like java, break before the symbol for non-assignment operators.
    //Break after the symbol for = and for...

    val emailFromJohn = Email("john.doe@mail.com", "A meeting is scheduled",
                              "Tomorrow morning 9:am, and please click this link")
    val title = emailFromJohn.title
    println(title)                            //A meeting is scheduled
    
    //emailFromJohn.title = "Goodbye From John!" // This is a compilation error.
    //But we can use copy method
    val editEmail = emailFromJohn.copy(title = "Reshedule the meeting", body = "The meeting has been postponed.")
    println(editEmail.title)                 //Reshedule the meeting
    println(editEmail.body)                  //The meeting has been postponed.
    
    val firstSMS =SMS("800-810-4456", "Hello!")
    val secondSMS = SMS("555-435-2134", "Great!")
    if (firstSMS == secondSMS) 
      println("They are equal!")
    else 
      println("They are not equal!")        //They are not equal!
    println("SMS is: " + firstSMS)          //SMS is: SMS(800-810-4456,Hello!)
  
    
    def showNotification(notification: Notification): String ={
      notification match {
        case Email(email, title, _) =>
          "You got an email from " + email + " with tilte: " + title
        case SMS(number, message) =>
          "You got an SMS from" + number + "! Message: " + message
        case VoiceRecording(name, link) =>
          "You received a voice Recording from " + name + "! Click the link to hear it" + link
      }
    }
    
    val someSMS = SMS("001", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom","voicerecording.org/id/001")
    
    println(showNotification(someSMS))
    //You got an SMS from001! Message: Are you there?
    
    println(showNotification(someVoiceRecording))
    //you received a voice Recording from Tom! Click the link to hear itvoicerecording.org/id/001
    
   
    def showNotificationSpecial(notification: Notification, specialEmail:
        String, specialNumber: String): String = {
      
      notification match {
        case Email(email,_,_) if email == specialEmail =>
          "You got an email from special someone!"
        case SMS(number, _) if number == specialNumber =>
          "You got an SMS from special someone!"
        case other => 
          showNotification(other)
      }
    }
    
    val SPECIAL_NUMBER = "55555"
    val SPECIAL_EMAIL = "jane@gmail.com"
    val someSms = SMS("001", "Are you there?")
    val someVoiceRecordings = VoiceRecording("Tom", "voicerecording.org/id/123")
    val specialEmail = Email("jane@gmail.com", "Meeting tomorrow afternoon?", "I am free after 5!")
    val specialSms = SMS("555", "I'm here! Where are you?")
    
    println(showNotificationSpecial(someSms,SPECIAL_EMAIL,SPECIAL_NUMBER ))
    //You got an SMS from001! Message: Are you there?
    
    println(showNotificationSpecial(someVoiceRecordings,SPECIAL_EMAIL,SPECIAL_NUMBER ))
    //You received a voice Recording from Tom! Click the link to hear itvoicerecording.org/id/123
  }
}