import io.peregrine._
import com.mongodb.casbah.Imports._

case class Message(message : String)

class EmployeesController extends Controller {

  val mongoClient = MongoClient("localhost", 27017)
  val db = mongoClient("watchDoge")
  val coll = db("employees")

  post("/"){ req =>
    buildEmployee(req) match{
      case None => json(Message("Incomplete Request")).status(400)
      case Some(doc) => json(coll.insert(doc))
    }
  }

  //Get all valid employees
  get("/") { req =>
    json(coll.find(MongoDBObject("isValid" -> "true")))
  }

  //Get all employees, valid or not
  get("/all/") { req =>
    json(coll.find())
  }

  //Get specified employee
  get("/:idEmployee") { req =>
    val id = req.param("idEmployee").getOrElse("-1")
    coll.findOne(MongoDBObject("idEmployee" -> id)) match {
      case None    => json(Message("Record not found"))
      case Some(u) => json(u)
    }
  }

  //Update specified User
  put("/:idEmployee") { req =>
    val id = req.param("idEmployee").getOrElse("-1")
      coll.findOne(MongoDBObject("idEmployee" -> id)) match {
      case None     => json(Message("Original record not found")).status(400)
      case Some(doc)  => buildEmployee(req) match {
        case None     => json(Message("Incomplete Request")).status(400)
        case Some(newDoc)  => json(coll.update( doc, newDoc ))
        }
    }
  }

  //Delete specified User
  delete("/:idEmployee") { req =>
    val id = req.param("idEmployee").getOrElse("-1")
    json(coll.remove(MongoDBObject("idEmployee" -> id)))
  }

  def buildEmployee(req: Request): Option[MongoDBObject] = {
    for {
      idEmployee <- req.param("idEmployee")
      name <- req.param("name")
      lastName <- req.param("lastName")
      address <- req.param("address")
      personalPhone <- req.param("personalPhone")
      mobilePhone <- req.param("mobilePhone")
      dob <- req.param("dob")
      doh <- req.param("doh")
      department <- req.param("department")
      job <- req.param("job")
      phoneExtension <- req.param("phoneExtension")
      manager <- req.param("manager")
      isValid <- req.param("isValid")
    } yield MongoDBObject("idEmployee" -> idEmployee,
      "name" -> name,
      "lastName" -> lastName,
      "personalData" -> MongoDBObject(
        "address" -> address,
        "personalPhone" -> personalPhone,
        "mobilePhone" -> mobilePhone,
        "dob" -> dob
      ),
      "doh" -> doh,
      "department" -> department,
      "job" -> job,
      "phoneExtension" -> phoneExtension,
      "manager" -> manager,
      "isValid" -> isValid
    )
  }

}
