package com.pawelduda.exceptions;

public class MessageLikeApproach {
    public static void main(String[] args) {
        new MessageLikeUi(new MessageLikeService()).addNumbers(1, 2, 3, 4, 5, 6);
    }

    public static class MessageLikeUi {
        private MessageLikeService messageLikeService;

        public MessageLikeUi(MessageLikeService messageLikeService) {
            this.messageLikeService = messageLikeService;
        }

        public void addNumbers(int... numbers) {
            try {
                System.out.println(messageLikeService.addNumbers(numbers));
            } catch (ServiceSupportsOnlyUpToFiveMembers e) {
                System.out.println("<html><body><p class=\"error\">We are sorry. Our service supports only 5 numbers but you entered <b>" + e.actualLength + " <b>. Please buy the full version!</p></body></html>");
            }
        }
    }

    public static class MessageLikeService {
        public int addNumbers(int[] numbers) {
            if (numbers.length > 5) throw new ServiceSupportsOnlyUpToFiveMembers(numbers.length);

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
    }

    public static class ServiceSupportsOnlyUpToFiveMembers extends RuntimeException {
        public int actualLength;

        public ServiceSupportsOnlyUpToFiveMembers(int actualLength) {
            super("Service supports only up to 5 numbers, but was " + actualLength);
            this.actualLength = actualLength;
        }
    }
}
