import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercent(double startDeposit, double yearRate, int depositPeriod) {
        double pay = startDeposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundFinalDeposit(pay, 2);
    }

    double calculateSimplePercent(double startDeposit, double yearRate, int depositPeriod) {
        return roundFinalDeposit(startDeposit + startDeposit * yearRate * depositPeriod, 2);
    }

    double roundFinalDeposit(double value, int places) {
        double scale = Math.pow (10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int startDeposit;
        int period;
        int typeDeposit;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        startDeposit = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeDeposit = scanner.nextInt();
        double finalDeposit = 0;
        if (typeDeposit == 1) finalDeposit = calculateSimplePercent(startDeposit, 0.06, period);
        else if (typeDeposit == 2) {
            finalDeposit = calculateComplexPercent(startDeposit, 0.06, period);
        }
        System.out.println("Результат вклада: " + startDeposit + " за " + period + " лет превратятся в "
                + finalDeposit);
    }

    public static void main(String[] args) {

        new CalculateDeposit().calculateDeposit();
    }

}
