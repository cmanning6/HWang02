package Lab01;

public class Staff extends Employee {
    public Staff() {
        super();
        generate();
        jobTitle = Names.position[rnd.nextInt(Names.position.length)];
    }

    public String toString() {
        return String.format("%s %s", super.toString(), jobTitle);
    }

    public String toString(boolean lab) {
        return lab ? "STF " + toString() : toString();
    }
    
    public String htmlRow() {
        return String.format("<tr>%s</tr>", htmlColumns());
    }
    
    public String htmlColumns() {
        return String.format("%s<td>%4s</td>", super.htmlColumns(), jobTitle);
    }

    protected String jobTitle;
}

