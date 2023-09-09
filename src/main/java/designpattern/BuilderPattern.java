package designpattern;

class Student {

	private final String name;
	private final String dept;
	private final String rollNo;
	private final String address;

	Student(StudentBuilder studentBuilder) {
		name = studentBuilder.name;
		dept = studentBuilder.dept;
		rollNo = studentBuilder.rollNo;
		address = studentBuilder.address;
	}

	public String getName() {
		return this.name;
	}

	public String getDept() {
		return this.dept;
	}

	public String getRollNo() {
		return this.rollNo;
	}

	public String getAddress() {
		return this.address;
	}

	public static class StudentBuilder {

		private final String name;
		private final String dept;
		private String rollNo;
		private String address;

		public StudentBuilder(String studentName, String studentDept) {

			name = studentName;
			dept = studentDept;
		}

		public StudentBuilder rollNo(String studentRollNo) {
			rollNo = studentRollNo;
			return this;
		}

		public StudentBuilder address(String studentAddress) {
			address = studentAddress;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

}

class StudentBuilderMain {

	public static void main(String[] args) {
		
	Student st1 = new Student.StudentBuilder("myname", "physics")
						.rollNo("100")
						.address("SF")
						.build();


		System.out.println(st1);

	}


}