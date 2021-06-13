# Angular
## in employee.service.ts
'http://localhost:8080/employees' <strong>link from which angular has to fetch data from spring </strong>

    export class EmployeeService {
    private baseUrl='http://localhost:8080/employees' <strong>from angular has to fetch data from spring </strong>
    constructor(private http:HttpClient) { }

    getEmployees():Observable<Employee[]>{
      return this.http.get<Employee[]>(`${this.baseUrl}`);
    }
    }
## in employee.component.ts
 <strong> in ngOnInit() call employeeService</strong>
 
    export class EmployeeComponent implements OnInit {
      employees!: Employee[];
      constructor(private employeeService:EmployeeService) { }
      ngOnInit(): void {
        this.employeeService.getEmployees().subscribe((data:Employee[])=>{
          console.log(data)
          this.employees=data;
        })
      }
    }
## in employee.component.html
     <table class="table table-striped">
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>salary</th>
                    <th>permanent</th>
                    <th>department</th>
                    <th>skills</th>
                </thead>
                <tbody>
                    <tr *ngFor="let emp of employees">
                        <td>{{emp.id}} </td>
                        <td>{{emp.name}} </td>
                        <td>{{emp.salary}} </td>
                        <td>{{emp.permanent}} </td>
                        <td>
                            <table><tr><td>{{emp.department.id}} </td><td>{{emp.department.name}} </td></tr></table>                           
                        </td>
                        <td>
                            <table><tr *ngFor= "let s of emp.skills"><td>{{s.id}}</td><td>{{s.name}}</td></tr></table>
                        </td>
                     </tr>
                </tbody>
            </table>

#Spring
<strong>"http://localhost:4200" spring allows access from this link of angular </strong>
  
    import org.springframework.web.bind.annotation.CrossOrigin;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    public class EmployeeController {
      @Autowired
      private EmployeeServices employeeServices;

      @GetMapping("/employees")
      public List<Employee> getAllEmployees() {
		    return employeeServices.employeeList();
	    }
    }
