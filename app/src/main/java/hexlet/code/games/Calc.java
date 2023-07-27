package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Arrays;

public class Calc implements Game {


    /**
     * @return возвращает правила игры
     */
    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }


    /**
     * @return задаёт вопрос игры и возвращает строку с ответом
     */
    @Override
    public String getQuestionAndAnswer() {
        var signsArray = Arrays.asList("+", "-", "*");
        var operationalSign = signsArray.get(Utils.getRandomNumber(signsArray.size()));
        int firstNumber = Utils.getRandomNumber(Engine.SUPREMUM);
        int secondNumber = Utils.getRandomNumber(Engine.SUPREMUM);
        int calcAnswer = 0;

        calcAnswer = switch (operationalSign) {
            case ("+") -> firstNumber + secondNumber;
            case ("-") -> firstNumber - secondNumber;
            case ("*") -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operationalSign);
        };
        System.out.printf("Question: %d %s %d%n", firstNumber, operationalSign, secondNumber);
        System.out.print("Your answer: ");
        return String.valueOf(calcAnswer);
    }
}
