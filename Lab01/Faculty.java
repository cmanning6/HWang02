package Lab01;
import java.util.Random;
import static Lab01.Member.rnd;

public class Faculty extends Employee {
    public Faculty() {
        super();
        rnd = new Random();
        generate();
        degreeHeld = Names.degree[rnd.nextInt(Names.degree.length)];
    }

    public String toString() {
        return (String.format("%s %s", super.toString(), degreeHeld));
    }

    public String toString(boolean lab) {
        return lab ? "FAC " + toString() : toString();
    }
    
    public String htmlRow() {
        return (String.format("<tr>%s</tr>", htmlColumns()));
    }

    public String htmlColumns() {
        return (String.format("%s<td></td><td>%s</td>", super.htmlColumns(),
                    degreeHeld));
    }
    
    protected String degreeHeld;
}

