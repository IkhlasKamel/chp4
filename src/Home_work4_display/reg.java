/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_display;

/**
 *
 * @author LapCity
 */
public class reg {
    int studantid;
    int courseid;
    int semstar;

    public int getStudantid() {
        return studantid;
    }

    public void setStudantid(int studantid) {
        this.studantid = studantid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSemstar() {
        return semstar;
    }

    public void setSemstar(int semstar) {
        this.semstar = semstar;
    }

    @Override
    public String toString() {
     return String.format("%-5s %-10s %-10s", studantid, courseid, semstar);

    }
    
    
}
