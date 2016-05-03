case class Processor(
  brand: String,
  model: String
)
case class HardDrive(
  brand: String,
  model: String,
  capacity: String,
  userCapacity: Int
)
case class Ram(
  capacity: Int,
  frequency: Int
)
case class NetworkCard(
  brand: String,
  model: String,
  macAddress: String,
  ip: String,
  mode: String,
)
case class VideoCard(
  brand: String,
  model: String
)
case class PersonalData(
  address: String,
  personalPhone: String,
  mobilePhone: String,
  dob: String
)
case class Employee(
  idEmployee: String,
  name: String,
  lastName: String,
  personalData: PersonalData,
  doh: String,
  department: String,
  job: String,
  phoneExtension: String,
  manager: Employee,
  isValid: Boolean
)

case class Equipment(
  idMachine: String,
  osType: String,
  osVersion: String,
  processor: Processor,
  hardDrive: HardDrive,
  ram: Ram,
  networkCard: List[NetworkCard],
  videoCard: VideoCard,
  updates: String,
  uptime: String,
  map: String,
  assignedEmployee: Employee,
  isValid: Boolean
)
