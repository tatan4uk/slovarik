package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyDictionary {
    Map<String,String> dictionary = new HashMap<String,String>();
    String kR;
    String vR;

    public MyDictionary()
    {
        kR="";
        vR="";
    }

    /**
     * Конструктор
     * @param keyRegex - регулярное выражению ключа
     * @param valRegex - регулярное выражению значения
     */
    public MyDictionary(String keyRegex, String valRegex)
    {
        kR=keyRegex;
        vR=valRegex;
    }

    /**
     * Метод получения словаря
     * @return - словарь
     */
    public Map<String,String> GetDictionary()
    {
        return dictionary;
    }

    /**
     * Метод переворачивает словарь (меняет местами ключи и значения)
     */
    public void swapValueToKey()
    {
        Map<String,String> result = new HashMap<>();

        String tStr;
        tStr = kR;
        kR = vR;
        vR = tStr;

        for (Map.Entry entry: dictionary.entrySet())
        {
            result.put(entry.getValue().toString(),entry.getKey().toString());
        }
        dictionary = result;
    }

    /**
     * Метод читает словарь из файла
     * @param path - путь к файлу
     */
    public void readFromFile(String path)
    {
        try
        {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader buf = new BufferedReader(fr);
            String line = buf.readLine();
            dictionaryPutString( line);
            while (line !=null)
            {
                dictionaryPutString( line);
                line = buf.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Файл успешно прочитан");
    }
    /**
     * Метод добавляет строку в словарь, если она удовлетворяет условиям одного из языков
     * @param string - строка
     */
    public void dictionaryPutString(String string)
    {
        String key ="";
        String value ="";

        if (string.contains(" - ")) {
            key = string.substring(0,string.indexOf('-')-1);
            value = string.substring(string.indexOf('-')+2, string.length());

            if( key.matches(kR) && value.matches(vR))
            {
                dictionary.putIfAbsent(key, value);
                System.out.println("Строка \"" + string + "\" добавлена в словарь");
            }
            else
                System.out.println("Строка \"" + string + "\" не удовлетворяет условиям словаря по ключу или значению");
        }
        else
            System.out.println("Строка \"" + string + "\" не удовлетворяет условиям словаря, неверная запись");
    }
    /**
     * Метод выводит словарь
     */
    public  void printDictionary() //вывод словаря
    {
        System.out.println("Словарь: ");
        System.out.println("---");
        dictionary.forEach((key,value) -> {System.out.println(key + " - " + value);});
        System.out.println("---");
    }
    /**
     * Метод удаляет по ключу
     * @param key - ключ
     */
    public void deleteKey(String key)
    {
        if (dictionary.containsKey(key))
        {
            dictionary.remove(key);
            System.out.println("Введенный ключ успешно удален");
        }
        else
        {
            System.out.println("В данном словаре введенный ключ не найден");
        }
    }
    /**
     * Метод ищет по ключу
     * @param key - ключ
     */
    public String searchKey(String key)
    {
        if (dictionary.containsKey(key))
        {
          return  dictionary.get(key);
        }
        else
        {
            System.out.println("В данном словаре введенный ключ не найден");
            return "";
        }
    }

}
