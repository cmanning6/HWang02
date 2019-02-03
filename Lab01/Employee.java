package Lab01;
import java.util.Random;
import static Lab01.Member.rnd;

public class Employee extends Member {
    public Employee() {
        super();
        rnd = new Random();
        generate();
        department = Names.department[rnd.nextInt(10)];
        yearsHired = rnd.nextInt(15) + 2004;
    }

    public String toString() {
        return String.format("%s %s %d", super.toString(), department,
                    yearsHired);
    }

    public String toString(boolean lab) {
        return lab ? "EMP " + toString() : toString();
    }

    public String htmlRow() {
        return String.format("<tr>%s</tr>", htmlColumns());
    }
    public String htmlColumns() {
        return String.format("%s<td></td><td></td><td>%s&nbsp</td><td>&nbsp%d</td>",  super.htmlColumns(),
                    department, yearsHired);
    }

    protected String department; int yearsHired;
}

