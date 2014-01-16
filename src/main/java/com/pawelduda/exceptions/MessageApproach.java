package com.pawelduda.exceptions;

public class MessageApproach {
    public static void main(String[] args) {
        new MessageUi(new MessageService()).addNumbers(1, 2, 3, 4, 5, 6);
    }

    public static interface AddNumbersValidationListener {
        void serviceSupportsOnlyUpToFiveMembers(int actualLength);
    }

    public static class MessageUi implements AddNumbersValidationListener {
        private MessageService messageService;

        public MessageUi(MessageService messageService) {
            this.messageService = messageService;
        }

        public void addNumbers(int... numbers) {
            System.out.println(messageService.addNumbers(numbers, this));
        }
        
        @Override
        public void serviceSupportsOnlyUpToFiveMembers(int actualLength) {
            System.out.println("<html><body><p class=\"error\">We are sorry. Our service supports only 5 numbers but you entered <b>" + actualLength + " <b>. Please buy the full version!</p></body></html>");
        }

    }

    public static class MessageService {
        public int addNumbers(int[] numbers, AddNumbersValidationListener addNumbersValidationListener) {
            if (numbers.length > 5) addNumbersValidationListener.serviceSupportsOnlyUpToFiveMembers(numbers.length);

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
    }
}
