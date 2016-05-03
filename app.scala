import io.peregrine._

object MyApp extends PeregrineApp {

  register(new EmployeesController, "/employees")

}
