package com.vastika.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Driver {

	/**
	 * @make sure you write comment
	 */


	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setId(1);
		s1.setFirstName("Michael");
		s1.setLastName("Lewis");
		s1.setEmail("Lewis@gmail.com");

		Student s2 = new Student();
		s2.setId(1);
		s2.setFirstName("Michael");
		s2.setLastName("Lewis");
		s2.setEmail("Lewis@gmail.com");

		Student s3 = new Student();
		s3.setId(3);
		s3.setFirstName("Anil");
		s3.setLastName("Mandal");
		s3.setEmail("Mandal@gmail.com");

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		System.out.println("general for loop");
		Student student = null;
		for (int i = 0; i < studentList.size(); i++) {

			student = studentList.get(i);
			System.out.println(student);
		}

		// Enhanced for loop
		System.out.println("Enhanced for loop");
		for (Student x : studentList) {
			System.out.println(x);
		}
		System.out.println("iterator loop");
		Iterator<Student> it = studentList.iterator();
		while (it.hasNext()) {
			student = it.next();
			System.out.println(student);
		}

		// set example
		System.out.println("Hash set example");
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);

		Iterator<Student> itr = studentSet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		//Map example
		Map<String, Student> map = new HashMap<String, Student>();

		map.put("Michael", s1);
		map.put("Dikal", s2);
		map.put("Bhaikal", s3);
		
		//Second Map
		
		//loop using keys
		Set<String> keys = map.keySet();
		for (String key : keys) {
			student = map.get(key);
			System.out.println("key:" + key + "\tvalue:" + student);
		}
		//using entry set
		for (Entry<String,Student> entry :map.entrySet()){
			System.out.println("key:"+entry.getKey()+"\t value:"+entry.getValue());
		}
	}
}
