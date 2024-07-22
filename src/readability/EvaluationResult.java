package readability;

public enum EvaluationResult {
    KINDERGARTEN(1, 6),
    FIRST_GRADE(2, 7),
    SECOND_GRADE(3, 8),
    THIRD_GRADE(4, 9),
    FOURTH_GRADE(5, 10),
    FIFTH_GRADE(6, 11),
    SIXTH_GRADE(7, 12),
    SEVENTH_GRADE(8, 13),
    EIGHT_GRADE(9, 14),
    NINTH_GRADE(10, 15),
    TENTH_GRADE(11, 16),
    ELEVENTH_GRADE(12, 17),
    TWELFTH_GRADE(13, 18),
    COLLEGE_STUDENT(14, 19);

    final int score;
    final int targetAge;

    EvaluationResult(int score, int targetAge) {
        this.score = score;
        this.targetAge = targetAge;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public static EvaluationResult fromScore(int score) {
        for (EvaluationResult result : values()) {
            if (result.score == score) {
                return result;
            }
        }
        throw new IllegalArgumentException("Score should be within 1-14");
    }
}
