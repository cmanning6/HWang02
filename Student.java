import java.util.Random;

public class Student extends Member {
        public Student() { // Default Constructor
                Random rnd = new Random();
                generate(rnd.nextInt(department.length()), rnd.nextFloat());                        
        } 
        public void generate() {
                        
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
        //public String htmlRow(){ }
        // public String htmlColumns();
        protected String major;
        protected float GPA;
}
