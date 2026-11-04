package Lab04;

import java.io.Serializable;

public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String gender;
    String group;
    String education;
    String testPrep;
    int math;
    int english;
    int computer;
    int total;
    double average;

    public Candidate(int id, String gender, String group, String education, String testPrep,
            int math, int english, int computer, int total, double average) {
        this.id = id;
        this.gender = gender;
        this.group = group;
        this.education = education;
        this.testPrep = testPrep;
        this.math = math;
        this.english = english;
        this.computer = computer;
        this.total = total;
        this.average = average;
    }

    public String toCsv() {
        return id + "," + gender + "," + group + "," + education + "," + testPrep + ","
                + math + "," + english + "," + computer + "," + total + "," + average;
    }

    public static Candidate fromCsv(String line) {
        String[] p = line.split(",");
        return new Candidate(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4],
                Integer.parseInt(p[5]), Integer.parseInt(p[6]), Integer.parseInt(p[7]),
                Integer.parseInt(p[8]), Double.parseDouble(p[9]));
    }

    public String toString() {
        return "Candidate " + id + " | " + gender + " | " + group + " | Total: " + total + " | Average: " + average;
    }
}