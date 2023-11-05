package week5;

public class lab5 {
    public interface NationalService {
        int getDaysLeft();

        void work();
    }

    public class CivilService implements NationalService {
        private int daysLeft;

        public CivilService() {
            this.daysLeft = 362;
        }

        @Override
        public int getDaysLeft() {
            return daysLeft;
        }

        @Override
        public void work() {
            if (daysLeft > 0) {
                daysLeft--;
            }
        }

    }

    public class MilitaryService implements NationalService {
        private int daysLeft;

        public MilitaryService(int daysLeft) {
            this.daysLeft = daysLeft;
        }

        @Override
        public int getDaysLeft() {
            return daysLeft;
        }

        @Override
        public void work() {
            if (daysLeft > 0) {
                daysLeft--;
            }
        }
    }
}

