// Superclass Course
class Course {
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

// Subclass OnlineCourse extending Course
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass PaidOnlineCourse extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: " + fee + ", Discount: " + discount + "%" + ", Final Fee: " + getFinalFee());
    }
}

// Main class to demonstrate the course hierarchy
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course basicCourse = new Course("Mathematics", 8);
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 12, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Data Science", 16, "Coursera", true, 500, 20);

        basicCourse.displayInfo();
        System.out.println();
        onlineCourse.displayInfo();
        System.out.println();
        paidCourse.displayInfo();
    }
}
