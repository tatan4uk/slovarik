package org.example;

public interface IMyDictionary
{
    /**
     * Метод переворачивает словарь
     */
    public void swapValueToKey();
    /**
     * Метод читает из файла
     * @param path - путь к файлу
     */
    public void readFromFile(String path);
    /**
     * Метод получает строку, соответствующую регулярному выражению
     * @param string - строка
     */
    public void dictionaryPutString(String string);
    /**
     * Метод удаляет по ключу
     * @param key - ключ
     */
    public void deleteKey(String key);
    /**
     * Метод ищет по ключу
     * @param key - ключ
     */
    public void searchKey(String key);
}
