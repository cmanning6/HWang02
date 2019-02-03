package Lab01;

import java.util.Random;

public class Student extends Member {
    public Student() {
        super();
        rnd = new Random();
        major = Names.degree[rnd.nextInt(Names.degree.length)];
        gpa = rnd.nextFloat() * 3 + 1;
        this.generate();
    }

    public String toString() {
        return (String.format("%s %s %.2f", super.toString(), major, gpa));
    }
    
    public String toString(boolean lab) {
        return lab ? "STU " + toString() : toString();
    }

    public String htmlRow() {
        return String.format("<tr>%s</tr>", htmlColumns());
    }
    public String htmlColumns() {
        return String.format("%s<td>%s</td><td>%.2f</td>", super.htmlColumns(),
                major, gpa);
    }

    protected String major; float gpa;
}

