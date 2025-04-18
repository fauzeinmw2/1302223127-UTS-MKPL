package lib;

import java.time.LocalDate;
import java.util.Map;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private static final Map<Integer, Integer> BASE_SALARY_MAP = Map.of(
        1, 3000000,
        2, 5000000,
        3, 7000000
    );

    public void setMonthlySalary(int grade, boolean isForeigner) {
        int baseSalary = BASE_SALARY_MAP.getOrDefault(grade, 0);
        monthlySalary = isForeigner ? (int) (baseSalary * 0.5) : baseSalary;
    }

    public int calculateAnnualTax(Family family, LocalDate joinDate) {
        int monthWorkingInYear;
        LocalDate now = LocalDate.now();

        if (now.getYear() == joinDate.getYear()) {
            monthWorkingInYear = now.getMonthValue() - joinDate.getMonthValue();
        } else {
            monthWorkingInYear = 12;
        }

        TaxCalculationData data = new TaxCalculationData(
            this.monthlySalary,
            this.otherMonthlyIncome,
            monthWorkingInYear,
            this.annualDeductible,
            family.hasSpouse(),
            family.getNumberOfChildren()
        );

        return TaxFunction.calculateTax(data);
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}
