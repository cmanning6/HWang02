package Lab01;

import java.util.Random;

public class Member implements Comparable<Member> {
    public int compareTo( Member m ) {
        return ID - m.ID;
    }

    public Member() { 
        rnd = new Random();
        this.generate();
    }

    public void generate() {
        ID = rnd.nextInt(899999999) + 100000000;
        firstName = Names.firstName[rnd.nextInt(Names.firstName.length)];
        lastName = Names.lastName[rnd.nextInt(Names.lastName.length)];
    }

    public String toString() { return String.format("%03d-%02d-%04d %10s %10s",
            ID / 1000000, (ID / 10000) % 100, ID % 10000, lastName, firstName);   
    }

    public String toString( boolean lab ) {
        return lab ? "MEM " + toString() : toString();
    }
    
    public String htmlRow() {
        return String.format("<tr>%s</tr>", htmlColumns());
    }

    public String htmlColumns() {
        return String.format("<td>%03d-%02d-%04d&nbsp&nbsp</td><td>%15s</td><td>%15s</td>", ID / 1000000, (ID / 10000) % 100,
                ID % 10000, firstName, lastName);
    }

    protected String firstName, lastName;
    protected int ID;
    static Random rnd;
}

