package com.solvd.transfercompany.people;

public enum Currency {
        NICKEL(5),
        EUR(100),
        USD(100);
        private final int VALUEINPENNIES;

        Currency(int VALUEINPENNIES) {
                this.VALUEINPENNIES = VALUEINPENNIES;
        }

        public int getVALUEINPENNIES() {
                return VALUEINPENNIES;
        }

        public final int toCoins(int pennies)
        {
                return pennies / VALUEINPENNIES;
        }
}
