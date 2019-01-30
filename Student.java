import java.util.Random;

public class Student extends Member {
        public Student() { 
                Random rnd = new Random();
                generate(rnd.nextInt(department.length()), rnd.nextFloat());                        
        } // Default Constructor
        public void generate(String m, float g) {
                major = m;
                GPA   = g;         
        } // Fills out data members
                
        @Override
        public String toString(){
                return toString(false);
        }
                    
        @Override
        public String toString(boolean label){
                return String.format("%3s %s %15s %1.2f", label ? "STU" : "",
                                  super.toString(), major, GPA);
        }

        @Override
        public String htmlRow(){
            return String.format("<tr>%s</tr>", htmlColumns());
        }

        @Override
        public String htmlColumns(){
            return String.format("%s<td>%s</td><td>%1.2f</td>", super.htmlColumns, major, GPA);
        }
        protected String major;
        protected float GPA;
}
