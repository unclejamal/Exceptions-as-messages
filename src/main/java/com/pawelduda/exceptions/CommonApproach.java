package com.pawelduda.exceptions;

public class CommonApproach {
    public static void main(String[] args) {
        new CommonUi(new CommonService()).addNumbers(1, 2, 3, 4, 5, 6);
    }

    public static class CommonUi {
        private CommonService commonService;

        public CommonUi(CommonService commonService) {
            this.commonService = commonService;
        }

        public void addNumbers(int... numbers) {
            try {
             System.out.println(commonService.addNumbers(numbers));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class CommonService {
        public int addNumbers(int[] numbers) {
            if (numbers.length > 5) throw new RuntimeException("Service supports only up to 5 numbers, but was " + numbers.length);

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
    }
}
