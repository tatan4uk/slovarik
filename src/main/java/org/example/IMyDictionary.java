package org.example;

public interface IMyDictionary
{
    /**
     * Метод читает из файла
     * @param path - путь к файлу
     * @return - успешно ли выполнено
     */
    public boolean readFromFile(String path);
    /**
     * Метод получает строку, соответствующую регулярному выражению
     * @param string - строка
     * @param invert - перевернуть словарь
     */
    public void dictionaryPutString(String string, boolean invert);
    /**
     * Метод удаляет по ключу
     * @param key - ключ
     */
    public void deleteKey(String key);
    /**
     * Метод ищет по ключу
     * @param key - ключ
     * @return - полученную строку
     */
    String searchKey(String key);
}
