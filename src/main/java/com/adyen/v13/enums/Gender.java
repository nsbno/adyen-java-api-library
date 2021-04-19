package com.adyen.v13.enums;

public enum Gender {
    MALE {

        public String toString() {
            return "MALE";
        }
    },
    FEMALE {

        public String toString() {
            return "FEMALE";
        }
    },
    UNKNOWN {

        public String toString() {
            return "UNKNOWN";
        }

    }
}
