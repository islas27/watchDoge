import io.peregrine._
import com.mongodb.casbah.Imports._

case class Message(message : String)

class EmployeesController extends Controller {





  def buildComputerInitialData(req: Request): Option[MongoDBObject] = {
    for {
      idComputer <- req.param("idComputer")
      osType <- req.param("osType"),
      osVersion <- req.param("osVersion"),
      processorBrand <- req.param("processorBrand"),
      processorModel <- req.param("processorModel"),
      hdBrand <- req.param("hdBrand"),
      hdModel <- req.param("hdModel"),
      hdCapacity <- req.param("hdCapacity"),
      hdUsedCapacity <- req.param("hdUsedCapacity"),
      ramCapacity <- req.param("ramCapacity"),
      ramFrequency <- req.param("ramFrequency"),
      netCardData <- req.param("netCardData"),
      videoCardBrand <- req.param("videoCardBrand"),
      videoCardModel <- req.param("videoCardModel")
    } yield MongoDBObject(

    )
  }
}
