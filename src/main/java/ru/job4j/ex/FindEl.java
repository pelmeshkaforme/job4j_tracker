package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] words, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(key)) {
                rsl = i;
                return rsl;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not detected.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] words = {"Table", "Chair", "Window", "Sky"};
        try {
            indexOf(words, "sky");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
