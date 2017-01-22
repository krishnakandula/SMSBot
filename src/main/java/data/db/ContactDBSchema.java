package data.db;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class ContactDBSchema {
    public static final class ContactTable {
        public static final String name = "contacts";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String PHONE_NUMBER = "number";
        }
    }
}
