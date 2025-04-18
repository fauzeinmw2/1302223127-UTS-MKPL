package lib;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public void setMonthlySalary(int grade, boolean isForeigner) {
        switch (grade) {
            case 1:
                monthlySalary = isForeigner ? (int)(3000000 * 0.5) : 3000000;
                break;
            case 2:
                monthlySalary = isForeigner ? (int)(5000000 * 0.5) : 5000000;
                break;
            case 3:
                monthlySalary = isForeigner ? (int)(7000000 * 0.5) : 7000000;
                break;
        
            default:
                break;
        }
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
