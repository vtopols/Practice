public class NumberAnalyzer {
    private double num;
    public NumberAnalyzer (double num) {
        this.num = num;
    }

    public boolean isPositive() {
        return num > 0;
    }

    public boolean isNegative() {
        return num < 0;
    }

    public boolean isInt() {
        return num == (int) num;
    }

    public boolean isEven() {
        if (!isInt()) {
            return false;
        }
        return ((int) num) % 2 == 0;
    }

    public boolean isOdd() {
        if (!isInt()) {
            return false;
        }
        return ((int) num) % 2 != 0;
    }

    public boolean isPrime() {
        if (!isInt() || num <2) {
            return false;
        }
        int intNum = (int) num;
        for (int i = 2; i <= Math.sqrt(intNum); i++) {
            if (intNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public double getSqrt() {
        if (num>=0) {
            return Math.sqrt(num);
        }
        return -1;
    }

    public double getSquare() {
        return num*num;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder("Введённое число:");
        if (isPositive()) {
            info.append(" положительное,");
        } else if (isNegative()) {
            info.append(" отрицательное,");
        } else {
            info.append(" ноль,");
        }

        if (isInt()) {
            info.append(" целое,");
        } else {
            info.append(" дробное,");
        }

        if (isInt()) {
            if (isEven()) {
                info.append(" чётное,");
            } else if (isOdd()){
                info.append(" нечётное,");
            }
        } else {
            info.append(" у дробных чисел нельзя определить чётность,");
        }

        if (isInt()) {
            if (isPrime()) {
                info.append(" простое,");
            } else {
                info.append(" не простое,");
            }
        } else {
            info.append(" дробное число не может быть простым или составным,");
        }

        double sqrt = getSqrt();
        if (sqrt == -1) {
            info.append(" Корень: нельзя извлечь из отрицательного числа,");
        } else {
            info.append(" Корень: ").append(sqrt).append(",");
        }

        info.append(" Квадрат: ").append(getSquare()).append(".");

        return info.toString();
    }
}

