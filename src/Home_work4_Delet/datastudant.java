/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_Delet;

/**
 *
 * @author LapCity
 */
public class datastudant {
   private int id ;
   private String name;
   private String major;
  private  double grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
      @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id, name, major, grade);
    }
    
}
