package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "RU";
//            }
//
//            @Override
//            public String getCompany() {
//                return "Home";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Aleksey";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Kolchenko";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 7;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 12345678;
//            }
//        });
//        System.out.println(incomeDataAdapter.getName());
//        System.out.println(incomeDataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            // +7(001)234-56-78
            int t1 = data.getCountryPhoneCode();
            int t2 = data.getPhoneNumber();
            String res = String.format("+%d(%2$s)%3$s-%4$s-%5$s", t1,
                    String.format("%010d", t2).substring(0, 3),
                    String.format("%010d", t2).substring(3, 6),
                    String.format("%010d", t2).substring(6, 8),
                    String.format("%010d", t2).substring(8));

            return res;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}