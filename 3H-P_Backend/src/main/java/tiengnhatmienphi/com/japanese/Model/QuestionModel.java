package tiengnhatmienphi.com.japanese.Model;

import javax.persistence.Column;
import java.util.List;

public class QuestionModel {
    private String content;

    private String ansA;

    private String ansB;

    private String ansC;

    private String ansD;

    private String ansCorrect;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    public String getAnsCorrect() {
        return ansCorrect;
    }

    public void setAnsCorrect(String ansCorrect) {
        this.ansCorrect = ansCorrect;
    }
}
