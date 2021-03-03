package cn.xpleaf.calcite.simple.object;

public class HrSchema {
    public final Employee[] emps = {
            new Employee(100, 10, "Bill", 10000, 1000),
            new Employee(200, 20, "Eric", 8000, 500),
            new Employee(150, 10, "Sebastian", 7000, null),
            new Employee(110, 10, "Theodore", 11500, 250),
    };

    @Override
    public String toString() {
        return "HrSchema";
    }

    public static class Employee {
        public int empid;
        public int deptno;
        public String name;
        public float salary;
        public Integer commission;

        public Employee(int empid, int deptno, String name, float salary,
                        Integer commission) {
            this.empid = empid;
            this.deptno = deptno;
            this.name = name;
            this.salary = salary;
            this.commission = commission;
        }

        @Override
        public String toString() {
            return "Employee [empid: " + empid + ", deptno: " + deptno
                    + ", name: " + name + "]";
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this
                    || obj instanceof Employee
                    && empid == ((Employee) obj).empid;
        }
    }
}