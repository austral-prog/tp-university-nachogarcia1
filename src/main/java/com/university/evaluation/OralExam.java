public class OralExam implements Assessment {
    private String student;
    private String subject;
    private String evaluationName;
    private String exerciseName;
    private String grade;

    public OralExam(String student, String subject, String evaluationName, String exerciseName, String grade) {
        this.student = student;
        this.subject = subject;
        this.evaluationName = evaluationName;
        this.exerciseName = exerciseName;
        this.grade = grade;
    }

    // Implementación de los métodos de Assessment
    @Override
    public String getStudent() { return student; }

    @Override
    public String getSubject() { return subject; }

    @Override
    public String getEvaluationName() { return evaluationName; }

    @Override
    public String getExerciseName() { return exerciseName; }

    @Override
    public String getGrade() { return grade; }

    // Otros métodos específicos para OralExam
}

