package com.solvd.transfercompany.people;

public enum Currency {
        NICKEL(5),
        EUR(100),
        USD(100);
        private final int valueInPennies;

        Currency(int valueInPennies) {
                this.valueInPennies = valueInPennies;
        }

        public int getValueInPennies() {
                return valueInPennies;
        }

        public final int toCoins(int pennies)
        {
                return pennies / valueInPennies;
        }
}
