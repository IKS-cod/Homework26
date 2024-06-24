package Homework26.service;

import Homework26.exception.ArrayIsFullException;
import Homework26.exception.ElementNullException;
import Homework26.exception.ExitForBorderArrayException;
import Homework26.exception.NotFoundElementException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringListImpl implements StringList {
    private final static int MAXIMUM_NUMBER_OF_CELLS = 10;
    private final String[] arrayList;

    public StringListImpl() {
        arrayList = new String[MAXIMUM_NUMBER_OF_CELLS];
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        int count = 0;
        if (item != null) {
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] != null) {
                    count++;
                } else {
                    arrayList[i] = item;
                    break;
                }
            }
            if (count == arrayList.length) {
                throw new ArrayIsFullException();
            }
        } else {
            throw new ElementNullException();
        }
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(int index, String item) {
        int count = 0;
        if (item != null) {
            for (String s : arrayList) {
                if (s != null) {
                    count++;
                }
            }
            if (index <= count - 1 && index <= arrayList.length - 2) {
                if (count - 1 <= arrayList.length - 2) {
                    for (int j = count; j >= index; j--) {
                        arrayList[j + 1] = arrayList[j];
                    }
                } else {
                    throw new ArrayIsFullException();
                }
            } else {
                throw new ExitForBorderArrayException();
            }
        } else {
            throw new ElementNullException();
        }
        arrayList[index] = item;
        return item;
    }

    // Установить элемент
// на определенную позицию,
// затерев существующий.
// Выбросить исключение,
// если индекс больше
// фактического количества элементов
// или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        int count = 0;
        if (item != null) {
            for (String s : arrayList) {
                if (s != null) {
                    count++;
                }
            }
            if (index <= count - 1 && index <= arrayList.length - 1) {
                arrayList[index] = item;
            } else {
                throw new ExitForBorderArrayException();
            }
        } else {
            throw new ElementNullException();
        }
        return item;
    }

    // Удаление элемента.
// Вернуть удаленный элемент
// или исключение, если подобный
// элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        int index = -1;
        if (item != null) {
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] != null) {
                    if (arrayList[i].equals(item)) {
                        index = i;
                    }
                }
            }
            if (index >= 0) {
                arrayList[index] = null;
            } else {
                throw new NotFoundElementException();
            }
        } else {
            throw new ElementNullException();
        }
        return item;
    }

    // Удаление элемента по индексу.
// Вернуть удаленный элемент
// или исключение, если подобный
// элемент отсутствует в списке.
    @Override
    public String remove(int index) {
        String element = null;
        if (index <= arrayList.length - 1) {
            if (arrayList[index] != null) {
                element = arrayList[index];
            } else {
                throw new NotFoundElementException();
            }
        } else {
            throw new ExitForBorderArrayException();
        }
        return element;
    }

    // Проверка на существование элемента.
// Вернуть true/false;
    @Override
    public boolean contains(String item) {
        int index = -1;
        boolean flag = false;
        if (item != null) {
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] != null) {
                    if (arrayList[i].equals(item)) {
                        index = i;
                    }
                } else {
                    continue;
                }
                if (index >= 0) {
                    flag = true;
                }
            }
        } else {
            throw new ElementNullException();
        }
        return flag;
    }

    // Поиск элемента.
// Вернуть индекс элемента
// или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        int index = -1;
        if (item != null) {
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] != null) {
                    if (arrayList[i].equals(item)) {
                        index = i;
                    }
                } else {
                    continue;
                }
            }
        } else {
            throw new ElementNullException();
        }
        return index;
    }

    // Поиск элемента с конца.
// Вернуть индекс элемента
// или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        if (item != null) {
            for (int i = arrayList.length - 1; i >= 0; i--) {
                if (arrayList[i] != null) {
                    if (arrayList[i].equals(item)) {
                        index = i;
                    }
                } else {
                    continue;
                }
            }
        } else {
            throw new ElementNullException();
        }
        return index;
    }

    // Получить элемент по индексу.
// Вернуть элемент или исключение,
// если выходит за рамки фактического
// количества элементов.
    @Override
    public String get(int index) {
        String element = null;
        int count = 0;
        if (index < arrayList.length - 1) {
            for (String string : arrayList) {
                if (string != null) {
                    count++;
                }
            }
        } else {
            throw new ExitForBorderArrayException();
        }
        if (index <= count - 1) {
            element = arrayList[index];
        } else {
            throw new ExitForBorderArrayException();
        }
        return element;
    }

    // Сравнить текущий список с другим.
// Вернуть true/false или исключение,
// если передан null.
    @Override
    public boolean equals(String[] otherList) {
        boolean flag = false;
        if (flag = otherList.length == arrayList.length) {
            if (flag) {
                for (int i = 0; i < arrayList.length; i++) {
                    if (otherList[i] != null && arrayList[i] != null) {
                        if (otherList[i] != arrayList[i]) {
                            flag = false;
                        }
                    } else {
                        throw new ElementNullException();
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayList);
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        int count = 0;
        for (String s : arrayList) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    // Вернуть true,
// если элементов в списке нет,
// иначе false.
    @Override
    public boolean isEmpty() {
        boolean flag = true;
        for (String s : arrayList) {
            if (s != null) {
                flag = false;
            }
        }
        return flag;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        Arrays.fill(arrayList, null);
    }

    // Создать новый массив
// из строк в списке
// и вернуть его.
    @Override
    public String[] toArray() {
        String[] toArray;
        toArray = Arrays.copyOf(arrayList, arrayList.length);
        return toArray;
    }
}
