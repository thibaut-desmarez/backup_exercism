public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= 5 ? 0.85 : 1;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >=20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double theoricSalary = 1000 * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        return theoricSalary > 2000 ? 2000 : theoricSalary;
    }
}
