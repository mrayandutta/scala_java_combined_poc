package javastreams.basic;

import static org.jooq.lambda.Seq.seq;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JoinUsingStream {
	public static void main(String[] args) 
	{
		
		List<Employee> employees = Arrays.asList(new Employee("Emplooyee1",false, 1, null),new Employee("Emplooyee2",false, 2, null),
				new Employee("Emplooyee3",false, 3, null),new Employee("Emplooyee4",false, 4, null));
		List<Contact> contacts = Arrays.asList(new Contact(1, "100"),new Contact(2, "200"),new Contact(3, "300"),new Contact(10, "400"));
		
		System.out.println("Start");
		/*
		
		employees.stream().flatMap(e -> contacts.stream()
				.filter(c-> e.getId().equals(c.getId()))
				.map(c->new ImmutablePair<>(c, e)))
		        .map(pair->
				{
					Employee employee = pair.getValue();
					Contact contact = pair.getKey();
					employee.setEnriched(true);
					employee.setContactNumber(contact.getContactNumber());
					return employee;
				}
				).forEach(x->System.out.println(x));;
				
				*/
				
				seq(employees).leftOuterJoin(seq(contacts), (employee, contact) -> employee.getId().equals(contact.getId()))
				//.forEach(x->System.out.println(x.v1));
				
				  .map((t)->
				  {
					  Employee employee = t.v1;
					  Contact contact = t.v2;
					  if(contact ==null)
					  {
						  System.out.println("For id "+ employee.getId() +" contact is null");
					  }
					  else 
					  {
						  System.out.println("Employee "+ employee);
						  System.out.println("Contact "+ contact);
					  }
					  return t;
				  }
				  )
				  .count();
				  //.forEach(x->System.out.println(x.v1));
				

				
		/*
				employees.stream().leftOuterJoin(contacts.stream(), (t, u) -> Objects.equals(t, u))
				  .forEach(System.out::println);
				  */
/*
				employees.stream()
				.flatMap(v1 -> contacts.stream()
				              .filter(v2 -> Objects.equals(v1, v2))
				              .onEmpty(null)
				              .map(v2 -> tuple(v1, v2)))
				.forEach(System.out::println);
				
				*/
		
		
		
		
	}

}
