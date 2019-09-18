package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary =
                new HashMap<>();
        dictionary.put("Большой",
                new String[]{"Колосальный", "Громадный", "Огромный", "Гигантский"});
        dictionary.put("Человек",
                new String[]{"Персона", "Личность", "Индивидум"});
        dictionary.put("Дом",
                new String[]{"Жилище", "Хата", "Квартира", "Недвижимость"});
        dictionary.put("Красивый",
                new String[]{"Прекрасный", "Очаровательный", "Симпатичный", "Привлекательный"});

        HashMap<String,String[]> bigDictionary = new HashMap<>();

        Set<String> keys = dictionary.keySet();
        Iterator iterator =keys.iterator();
        while (iterator.hasNext()){
        String key = iterator.next().toString();
        String[] values = dictionary.get(key);
        bigDictionary.put(key,values);
            for (int i =0; i<values.length;i++) {
                String newKey = values[i];
                ArrayList<String> strArr = new ArrayList<>(values.length);
                strArr.addAll(Arrays.asList(values));
                strArr.remove(newKey);
                strArr.add(key);
                String[] newVal = new String[strArr.size()];
                newVal = strArr.toArray(newVal);
                bigDictionary.put(newKey, newVal);
            }


        }

        System.out.println("Введите слово");
        Scanner scanner = new Scanner(System.in);
        String sentences =scanner.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null){
                int randomNumber = r.nextInt(synonyms.length);
                System.out.printf(synonyms[randomNumber] + " ");}
            else {
                System.out.println("Не понял вас");
            }
        }
    }
}




